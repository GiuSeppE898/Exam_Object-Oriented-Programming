package Test;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import Core.Cavaliere;
import Core.Gestore;
import Core.Orco;
import Core.Personaggio;

public class Test1 {
	public static void main(String Argv[]) {
		Gestore list = new Gestore();
		Orco o1 = new Orco(100,1,1);
		Orco o2 = new Orco(100,1,1);
		Cavaliere c1 = new Cavaliere(90,2,5);
		Cavaliere c2 = new Cavaliere (49,2,54);
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(c1);
		list.insertPlayer(o1);
		list.insertPlayer(o2);
		list.insertPlayer(c1);
		list.insertPlayer(c2);
		
		System.out.println("Posizione: "+list.get_Pos(o1));
		
		System.out.println("Tipo: "+list.get_Type(c1));
		
		list.SaveOnFile();
		
		System.out.println("Stampa elenco");
		
		ArrayList<String> a =list.get_Pos_all();
		System.out.println(a);
		
		
		Predicate<Personaggio> pred = p-> (p instanceof Orco);
		Consumer<Personaggio> cons = p -> {System.out.println("ID "+((Orco) p).getIdo());};
		System.out.println("STAMPA ID DEGLI ORCHI");
		list.PrintbyCondition(list,pred,cons);
		
		
		System.out.println("CONTA CAVALIERI ENERGIA>50 E POSIZIONE<50");
		Predicate <Personaggio> p1 = p->(p instanceof Cavaliere && p.getEnergia()>50 && p.getPosiniziale()<50);
		int cont = list.CountbyCondition(list,p1);
		System.out.println("NUMERO : "+cont);
		System.out.println("ID CAVALIERI ENERGIA>70");
		pred = p-> ((p instanceof Cavaliere)&&(p.getEnergia()>70));
		cons = p -> {System.out.println("ID "+((Cavaliere) p).getIdc());};
		list.PrintbyCondition(list, pred, cons);
	}

}
