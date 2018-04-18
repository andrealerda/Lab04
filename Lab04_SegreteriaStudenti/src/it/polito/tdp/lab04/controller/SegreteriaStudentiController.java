/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;
	List<Corso> corsi;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="comboCorsi"
    private ComboBox<Corso> comboCorsi; // Value injected by FXMLLoader

    
    @FXML // fx:id="btnCercaIscritti"
    private Button btnCercaIscritti; // Value injected by FXMLLoader
    

    @FXML // fx:id="btnCompletaInfo"
    private Button btnCompletaInfo; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="txtLog"
    private TextArea txtLog; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader


	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
		setComboItems();
		}

	private void setComboItems() {

		// Ottieni tutti i corsi dal model
		corsi = model.getTuttiICorsi();

		// Aggiungi tutti i corsi alla ComboBox
		Collections.sort(corsi);
		comboCorsi.getItems().addAll(corsi);
	}
    
    @FXML
    void cercaCorso(ActionEvent event) {
    	txtLog.clear();
		txtNome.clear();
		txtCognome.clear();
		
    	String matricola = txtMatricola.getText();
    	if(matricola == null) {
    		txtLog.setText("Inserire matricola");
    		return;
    	}
    	if(model.getStudenteByMatricola(matricola)==null){
    		txtLog.setText("Inserire matricola valida");
    		return;
    	}
    	
    	List<Corso> corsiPartecipa = null;
    	corsiPartecipa = model.getIscrittoCorsi(matricola);
    	for(Corso c : corsiPartecipa) {
    		txtLog.appendText(c.toString()+"\n");
    	}
    	
    }

    @FXML
    void cercaiscrtitti(ActionEvent event) {
    	txtLog.clear();
		txtNome.clear();
		txtCognome.clear();
		
		Corso corso = comboCorsi.getValue();
    	if(corso==null) {
    		txtLog.setText("Scegli un corso prima");
    		return;
    	}

    	List<Studente> studenti = null;
    	studenti = model.getIscrittiCorso(corso);
    	for(Studente s : studenti) {
    		txtLog.appendText(s.toString()+"\n");
    	}
    	
    	
    }

    @FXML
    void iscrivi(ActionEvent event) {
    	txtLog.clear();
		txtNome.clear();
		txtCognome.clear();
		
    	String matricola = txtMatricola.getText();
    	if(matricola == null) {
    		txtLog.setText("Inserire matricola");
    		return;
    	}
    	if(model.getStudenteByMatricola(matricola)==null){
    		txtLog.setText("Inserire matricola valida");
    		return;
    	}
    	Corso corso = comboCorsi.getValue();
    	if(corso==null) {
    		txtLog.setText("Scegli un corso prima");
    		return;
    	}
    	List<Corso> corsiPartecipa = null;
    	corsiPartecipa = model.getIscrittoCorsi(matricola);
    	for(Corso c : corsiPartecipa) {
    		if(corso.getCodins() == c.getCodins()) {
    			txtLog.setText("Partecipa già");
    			return;
    		}
    	}
    	if(model.aggiungiCorsoAStudente(matricola,corso.getCodins())) {
    		txtLog.setText("Inserito correttamente " +  matricola + " " + corso.getCodins());
    	}else {
    		txtLog.setText("Errore durante l'iscrizione al corso");	
    		return;
    	}
    	

    }

    @FXML
    void reset(ActionEvent event) {
    	txtCognome.clear();
    	txtLog.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    }
    

    @FXML
    void completaInfo(ActionEvent event) {
    	txtLog.clear();
		txtNome.clear();
		txtCognome.clear();
		
    	if(txtMatricola.getText()==null) {
    		txtLog.setText("Inserisci una matricola");
    		return;
    	}
    	String matricola = txtMatricola.getText();
    	Studente s = model.getStudenteByMatricola(matricola);
    	
    	txtCognome.setText(s.getCognome());
    	txtNome.setText(s.getNome());
    }



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	  assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert btnCompletaInfo != null : "fx:id=\"btnCompletaInfo\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
          assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }

}
