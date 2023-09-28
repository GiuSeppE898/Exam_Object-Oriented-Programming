package Core;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Gestore {
	ArrayList<Personaggio> p;

	public Gestore() {
		this.p = new ArrayList<Personaggio>();
	}
	public ArrayList<Personaggio> getP() {
		return p;
	}
	public void setP(ArrayList<Personaggio> p) {
		this.p = p;
	}
	public void insertPlayer(Personaggio pers) {
		this.p.add(pers);		
	}
	public void SaveOnFile() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("elenco.txt")));
			for(Personaggio p1 : p) {
				out.println(p1);				
			}
			out.close();			
		}
		catch(EOFException e1) {
			System.out.println("Stream finita");
			out.close();
		}
		catch(Exception e1) {
			e1.printStackTrace();
			out.close();
		}
	}
	public int get_Pos(Personaggio pers) {
		return pers.getPosattuale();		
	}
	public String get_Type(Personaggio pers) {
		if(pers instanceof Orco) return "Orco";
		else return "Cavaliere";
	}
	public ArrayList<String> get_Pos_all(){
		ArrayList<String> a = new ArrayList<String>();
		for(Personaggio p1: p ) {
			int pos = p1.getPosattuale();
			int id = p1.getId();
			a.add(""+pos+" "+id);
		}
		return a;		
	}
	public void PrintbyCondition(Gestore list, Predicate<Personaggio> pred, Consumer<Personaggio> cons) {
		this.p.stream().filter(pred).forEach(cons);	
	}
	public int CountbyCondition(Gestore list, Predicate<Personaggio> p1) {
		return (int) this.p.stream().filter(p1).count();
	}
	

}
