package Core;

public class Cavaliere extends Personaggio {
	static int contc=1;
	private int idc; //identificativo del cavaliere, permette di capire anche quanti cavalieri ci sono;
	
	
	
	public Cavaliere(int energia, int posiniziale, int posattuale) {
		super(energia, posiniziale, posattuale);
		super.setTipo("Cavaliere");
		idc = contc++;
		// TODO Auto-generated constructor stub
	}
	
	

	public int getIdc() {
		return idc;
	}



	public void setIdc(int idc) {
		this.idc = idc;
	}



	void colpisci(Personaggio pers) {
		int e = pers.getEnergia();
		if(e==0)System.out.println("Il personaggio non ha piu energia");
		else pers.setEnergia(e-1);
	}

}
