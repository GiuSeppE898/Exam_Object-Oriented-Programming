package Core;

public class Orco extends Personaggio {
	   private static int conto=0;
	   private int ido; //identificativo del cavaliere, permette di capire anche quanti cavalieri ci sono;
		
		
		public Orco(int energia, int posiniziale, int posattuale) {
			super(energia, posiniziale, posattuale);
			super.setTipo("Cavaliere");
			ido = conto++;
			// TODO Auto-generated constructor stub
		}

		void colpisci(Personaggio pers) {
			int e = pers.getEnergia();
			if(e==0)System.out.println("Il personaggio non ha piu energia");
			else pers.setEnergia(e-1);
		}

		public int getIdo() {
			return ido;
		}

		public void setIdo(int ido) {
			this.ido = ido;
		}

		@Override
		public String toString() {
			return "Orco [ido=" + ido + "]";
		}
		

	}

