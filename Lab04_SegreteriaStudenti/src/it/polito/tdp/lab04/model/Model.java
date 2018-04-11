package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {

	public List<Corso> getTuttiICorsi() {
		// TODO Auto-generated method stub
		CorsoDAO corsoDao = new CorsoDAO();
		
		return corsoDao.getTuttiICorsi();
	}

}
