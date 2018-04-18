package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	public List<Corso> getTuttiICorsi() {
		// TODO Auto-generated method stub
		CorsoDAO corsoDao = new CorsoDAO();
		
		return corsoDao.getTuttiICorsi();
	}
	
	public Studente getStudenteByMatricola(String matricola) {
		StudenteDAO studenteDAO = new StudenteDAO();
		
		return studenteDAO.getStudenteByMatricola(matricola);
	}

	public List<Studente> getIscrittiCorso(Corso corso) {
		// TODO Auto-generated method stub
		StudenteDAO studenteDAO = new StudenteDAO();
		
		return studenteDAO.getIsrittiCorso(corso);
	}

	public List<Corso> getIscrittoCorsi(String matricola) {
		StudenteDAO studenteDAO = new StudenteDAO();
		
		return studenteDAO.getIscrittoCorsi(matricola);
	}

	public boolean aggiungiCorsoAStudente(String matricola,String codins) {
		// TODO Auto-generated method stub
		StudenteDAO studenteDAO = new StudenteDAO();
		return studenteDAO.aggiungiCorsoAStudente(matricola,codins);
	}

}
