package com.example.traininggson;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class WordTranslationObserver implements PropertyChangeListener {
	public WordTranslationObserver(WordTranslation translationModel) {
		translationModel.addChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		System.out.println("Changed property: " + event.getPropertyName());
		ArrayList<Translation> translations = (ArrayList<Translation>) event.getNewValue();
		
		// Print recieved data from JSON to the console 
		// I want to be able to get translation.getText() in my Main class
		for (Translation translation : translations) {
			System.out.println(translation.getText());
		}
	}
}
