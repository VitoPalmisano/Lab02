package it.polito.tdp.alien.model;

import java.util.*;

public class Dictionary {

	private List<Word> dizionario = new ArrayList<>();
	
	public String nuovaTraduzione(String alienWord, String translation) {
		
		Word parolaTemp = new Word(alienWord, translation);
		boolean parolaEsistente = false;
		boolean tradGiaEsistente = false;
		
		for(Word w : dizionario) {
			if(w.equals(parolaTemp)) {
				parolaEsistente = true;
				tradGiaEsistente = w.addTranslation(translation);
				if(tradGiaEsistente)
					return "Questa traduzione e' gia' presente nel dizionario.";
			}
		}

		if(!parolaEsistente) {
			dizionario.add(parolaTemp);
		}

		String s = "Nuova traduzione: '"+alienWord+"' si traduce come";
		
		for(Word w : dizionario) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				for(String t : w.getTranslations()) {
					s += " '"+t+"';";
				}
			}
		}
		
		return s;
	}
	
	public String traduci(String parola) {
		
		String s = "";
		
		if(parola.contains("?")) {
			int l = parola.length();
			int cont;
			boolean trovata = false;
			s = "Probabili corrispondenze della ricerca legata a '"+parola+"': ";
			for(Word w : dizionario) {
				cont = 0;
				if(l==w.getAlienWord().length()) {
					for(int i = 0; i<l; i++) {
						if(parola.charAt(i)==w.getAlienWord().charAt(i)) {
							cont++;
						}
					}
					if(cont==(l-1)) {
						trovata = true;
						s += "\n"+w.getAlienWord()+" =";
						for(String t : w.getTranslations()) {
							s += " '"+t+"';";
						}
					}
				}
			}
			if(!trovata)
				s += "\nNessuna";
			return s;
		}
		
		s = "'"+parola+"' si traduce come";
		
		for(Word w : dizionario) {
			if(w.getAlienWord().compareTo(parola)==0) {
				for(String t : w.getTranslations()) {
					s += " '"+t+"';";
				}
				return s;
			}
		}
		
		return null;
	}

	public void clear() {
		dizionario.clear();		
	}
}
