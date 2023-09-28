package Core;

import Exception.LimitException;
import interfaccia.PresMaster;

public abstract class Personaggio implements PresMaster {
	int id;
	static int cont=1;
	private String tipo;
	private int energia;
	private int posiniziale;
	private int posattuale;
	
	
	public Personaggio(int energia2, int posiniziale2, int posattuale2) {
		this.energia = energia2;
		this.posiniziale = posiniziale2;
		this.posattuale = posattuale2;
		id = cont;
		cont++;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getEnergia() {
		return energia;
	}


	public void setEnergia(int energia) {
		this.energia = energia;
	}


	public int getPosiniziale() {
		return posiniziale;
	}


	public void setPosiniziale(int posiniziale) {
		this.posiniziale = posiniziale;
	}


	public int getPosattuale() {
		return posattuale;
	}


	public void setPosattuale(int posattuale) {
		this.posattuale = posattuale;
	}

	@Override
	public String toString() {
		return "Personaggio [id=" + id + ", tipo=" + tipo + ", energia=" + energia + ", posiniziale=" + posiniziale
				+ ", posattuale=" + posattuale + "]";
	}


	@Override
	public void Ruota(int g) {
		System.out.println("Ruotato di "+g+" gradi");

	}

	@Override
	public void Avanti(int s) throws LimitException {
		if((this.posattuale + s)>100) throw new LimitException();
		else this.posattuale += s;

	}

	@Override
	public void Indietro(int s) throws LimitException {
		if((this.posattuale-s)>100) throw new LimitException();
		else this.posattuale -= s;

	}
	abstract void colpisci(Personaggio pers);

}
