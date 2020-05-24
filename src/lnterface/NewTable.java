package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class NewTable {
	private static JPanel p= new  JPanel(),p0=new JPanel();
	private static JButton execute= new JButton("<Html><strong style=color:white >Execute</strong></html>"),clear= new JButton("<Html><strong style=color:white >Clear</strong></html>"),close= new JButton("<Html><strong style=color:white >Fermer</strong></html>");
	private static creationOfTab_down tablepan = new creationOfTab_down();
	
	public static JScrollPane get_creation_panel(boolean x) {
		execute.setBackground(Color.BLACK);close.setBackground(Color.BLACK);clear.setBackground(Color.black);
		p.setLayout(new BorderLayout());
		p.add(CreationOfTable_top.getTopPan(),BorderLayout.NORTH);
		p.add(tablepan.getDownPan(x),BorderLayout.CENTER);
		p0.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p0.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		p0.add(execute);p0.add(clear);p0.add(close);
		p.add(p0,BorderLayout.SOUTH);
		
		
		
		
		
		
		JScrollPane s= new JScrollPane(p);
		
		
		return s;
	}


	static JButton getExecute() {
		return execute;
	}


	static JButton getClose() {
		return close;
	}


	static void setExecute(JButton execute) {
		NewTable.execute = execute;
	}


	static void setClose(JButton close) {
		NewTable.close = close;
	}


	static JButton getClear() {
		return clear;
	}


	static void setClear(JButton clear) {
		NewTable.clear = clear;
	}
	
	

}
