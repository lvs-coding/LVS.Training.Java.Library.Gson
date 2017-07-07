package com.example.traininggson;

import java.io.IOException;

public class Main    {
	public static void main(String[] args) throws IOException {
		
		WordTranslation wordTranslation = new WordTranslation();
		WordTranslationObserver myObserver = new WordTranslationObserver(wordTranslation);
		wordTranslation.translate("sắt", "vie", "eng");		
		
	}
}
