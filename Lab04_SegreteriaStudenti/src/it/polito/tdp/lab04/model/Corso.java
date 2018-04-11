package it.polito.tdp.lab04.model;

public class Corso implements Comparable<Corso>{

	String codins;
	int numeroCrediti;
	String nome;
	int periodoDidattico;
	
	public Corso(String codins, int numeroCrediti, String nome, int periodoDidattico) {
		super();
		this.codins = codins;
		this.numeroCrediti = numeroCrediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}

	
	@Override
	public int compareTo(Corso corsoInput) {
		return this.nome.compareTo(corsoInput.nome);
	}
	
	/*
	 * Metodo toString()
	 */
	@Override
	public String toString() {
		return nome;
	}
}
