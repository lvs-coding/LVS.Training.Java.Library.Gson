package com.example.traininggson;

import java.io.IOException;

public class Main    {
	public static void main(String[] args) throws IOException {
		
		TranslationRequest request = new TranslationRequest();
		request.translate("sắt", "vie", "eng");
		
		
		
	}
}
