package GUI;

import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.Cavaliere;
import Core.Gestore;
import Core.Orco;

public class mainpanel extends JFrame {
	public mainpanel(String s) {
		this.setTitle(s);
		this.setSize(500,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(450,450);
		JPanel panel = this.buildpanel();
		this.add(panel);
	}
	JPanel buildpanel() {
		JPanel p = new JPanel();
		JLabel l1 = new JLabel("Elementi");
		p.add(l1);
		JComboBox b = new JComboBox();
		for( int i = 0;i<50;i++) b.addItem(""+i);
		p.add(b);
		JButton Add = new JButton("Aggiungi");
		p.add(Add);
		Add.addActionListener((ActionEvent e)->{
			Gestore g = new Gestore();
			int elementi = b.getSelectedIndex();
			for(int i=0;i<elementi;i++) {
				Scanner in = new Scanner( System.in );
				System.out.println("Scrivi i dati di un personaggio");
				int vita = in.nextInt();
				int posin = in.nextInt();
				int posatt = in.nextInt();
				if(i%2==0) {//se i è pari inserisco un orco
					Orco o1 = new Orco(vita,posin,posatt);
					g.insertPlayer(o1);					
				}
				else {
					Cavaliere c1 = new Cavaliere(vita,posin,posatt);
					g.insertPlayer(c1);
				}
				System.out.println("Inserimento completo");
				
				
			}			
		});		
		return p;	
		}
		
	}



