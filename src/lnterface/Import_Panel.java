package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Import_Panel extends JPanel {
	
	private static JPanel p= new  JPanel(), p1 = new JPanel();
	private static JButton browse= new JButton("<Html><strong style=color:white >Feuilleter</strong></html>");
	private static JButton valide= new JButton("<Html><strong style=color:white >Execute</strong></html>");
	private static JLabel err_message_l = new JLabel();
	private static JTextField file_path = new JTextField(30);
	

	
	
	public static JPanel get_creation_panel(boolean x) {
		browse.setBackground(Color.BLACK);
		valide.setBackground(Color.BLUE);
		p.setLayout(new BorderLayout());
		p1.setLayout(new FlowLayout());
		p1.add(file_path);
		p1.add(browse);
		p1.add(valide);
		p.add(p1,BorderLayout.CENTER);
		p.add(err_message_l,BorderLayout.SOUTH);
		
		
		return p;
	}



public static JButton getBrowse() {
		return browse;
	}







	public static void setBrowse(JButton browse) {
		Import_Panel.browse = browse;
	}



	public static JTextField getFile_path() {
		return file_path;
	}







	public static void setFile_path(JTextField file_path) {
		Import_Panel.file_path = file_path;
	}
	public static JButton getValide() {
		return valide;
	}



	public static void setValide(JButton valide) {
		Import_Panel.valide = valide;
	}



	public static JLabel getErr_message_l() {
		return err_message_l;
	}



	public static void setErr_message_l(JLabel err_message_l) {
		Import_Panel.err_message_l = err_message_l;
	}

}
