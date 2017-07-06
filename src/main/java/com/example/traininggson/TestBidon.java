package com.example.traininggson;

import java.awt.print.Printable;

public class TestBidon implements TranslationListener {
	private TranslationListener translationListener;
	
	public TestBidon() {
		translationListener = this;
	}

	@Override
	public void gotTranslations(Translation[] translation) {
		System.out.println("fuck");
		
	}

}
