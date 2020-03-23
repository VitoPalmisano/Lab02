package it.polito.tdp.alien.model;

import java.util.*;

public class Word {

	private String alienWord;
	private List<String> translations;
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations = new LinkedList<>();
		translations.add(translation);
	}

	public List<String> getTranslations() {
		return translations;
	}

	public boolean addTranslation(String translation) {
		
		boolean giaPresente = false;
		for(String s : translations) {
			if(s.compareTo(translation)==0)
				giaPresente = true;
		}
		if(!giaPresente) {
			translations.add(translation);
			return false;
		}
		else
			return true;
	}

	public String getAlienWord() {
		return alienWord;
	}
	
	public boolean equals(Word w) {
		
		if(w.getAlienWord().compareTo(alienWord)==0)
			return true;
		
		return false;
	}
}
