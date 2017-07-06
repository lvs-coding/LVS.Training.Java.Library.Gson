package com.example.traininggson;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WordTranslation {
	public static final String TRANSLATIONS = "translations";
	private static final String BASE_URL = "http://deu.hablaa.com/hs/translation/";
	private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();
	ArrayList<Translation> translations;	
	
	 public void addChangeListener(PropertyChangeListener newListener) {
	        listener.add(newListener);
	 }
	 

	 public void notifyListeners(String property, Translation[] translationArray) {
			translations = new ArrayList<>();
			// TODO Auto-generated method stub
			for (Translation t : translationArray) {
				translations.add(t);
			}
			for (PropertyChangeListener name : listener) {
	            name.propertyChange(new PropertyChangeEvent(this, "translations", null, translations));
	        }
	} 
	 
	 public void translate(String word, String from, String to) {
			final Translation[][] translations = new Translation[1][1];
			
			String url = String.format("%s%s/%s-%s",BASE_URL, word, from, to);//  args) "http://deu.hablaa.com/hs/translation/kh%C3%B4ng/vie-eng/";
			System.out.println(url);
			final Gson gson = new Gson();
			
			// should be a singleton
			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder()
			                     .url(url)
			                     .build();
			
			
			// Get a handler that can be used to post to the main thread
			client.newCall(request).enqueue(new Callback() {
			    @Override
			    public void onFailure(Call call, IOException e) {
			        e.printStackTrace();
			    }

			    @Override
			    public void onResponse(Call call, final Response response) throws IOException {
			        if (!response.isSuccessful()) {
			            throw new IOException("Unexpected code " + response);
			        }
			        
			        translations[0] = gson.fromJson(response.body().charStream(),Translation[].class);	
			        notifyListeners(TRANSLATIONS,translations[0]);
			        
			    }
			});
			
		}

}
