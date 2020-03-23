package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtDictionary;

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtDictionary.clear();
    	txtWord.clear();
    	dizionario.clear();
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String s = txtWord.getText();
    	String[] trad = s.toLowerCase().split(" ");
    	
	    if(trad.length==1 && trad[0].matches("[a-zA-Z?]*")) {
	    	txtDictionary.appendText(dizionario.traduci(s)+"\n");
	    }
	    else if (trad.length==2 && trad[0].matches("[a-zA-Z]*") && trad[1].matches("[a-zA-Z]*")) {
	    	txtDictionary.appendText(dizionario.nuovaTraduzione(trad[0], trad[1])+"\n");
	    }
	    else {
	    	txtDictionary.appendText("Gli unici caratteri ammessi per le parole sono [a-zA-Z] (ossia solo le lettere alfabetiche, siano essere maiuscole o minuscole)");
	    }
	    
	    txtDictionary.setScrollTop(Double.MAX_VALUE);
	    
	    txtWord.clear();
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDictionary != null : "fx:id=\"txtDictionary\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setDictionary (Dictionary dizionario) {
    	this.dizionario = dizionario;
    }
}
