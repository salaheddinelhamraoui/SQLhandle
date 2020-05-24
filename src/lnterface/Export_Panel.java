package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Export_Panel extends JPanel {
	
	private static JPanel p= new  JPanel(), p1 = new JPanel();
	private static JTextField tf_db_name;
	private static JTextField tf_mysql_path;
	private static JTextField tf_save_path;
	private static JButton mysql_path_b = new JButton("<Html><strong style=color:white >Choisir</strong></html>");
	private static JButton valide_b = new JButton("<Html><strong style=color:white >Execute</strong></html>");
	private static JButton save_path_b = new JButton("<Html><strong style=color:white >Choisir</strong></html>");
	
	


	public  Export_Panel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chemin du fichier");
		lblNewLabel.setBounds(107, 108, 93, 13);
		add(lblNewLabel);
		p1.setLayout(null);
		
		tf_db_name = new JTextField();
		tf_db_name.setBounds(196, 163, 207, 19);
		p1.add(tf_db_name);
		tf_db_name.setColumns(10);
		
		tf_mysql_path = new JTextField();
		tf_mysql_path.setBounds(196, 134, 207, 19);
		p1.add(tf_mysql_path);
		tf_mysql_path.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Chemin du Mysql");
		lblNewLabel_1.setBounds(87, 137, 115, 13);
		p1.add(lblNewLabel_1);
		
		
		save_path_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		save_path_b.setBounds(426, 104, 102, 21);
		p1.add(save_path_b);
		
		
		mysql_path_b.setBounds(426, 133, 102, 21);
		p1.add(mysql_path_b);
		
		
		valide_b.setBounds(248, 192, 102, 28);
		p1.add(valide_b);
		
		tf_save_path = new JTextField();
		tf_save_path.setColumns(10);
		tf_save_path.setBounds(196, 105, 207, 19);
		p1.add(tf_save_path);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom de DB");
		lblNewLabel_1_1.setBounds(97, 166, 89, 13);
		p1.add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Chemin du fichier");
		lblNewLabel_1_2.setBounds(87, 108, 102, 13);
		p1.add(lblNewLabel_1_2);
		valide_b.setBackground(Color.BLACK);
		mysql_path_b.setBackground(Color.BLACK);
		save_path_b.setBackground(Color.BLACK);
		
		p.setLayout(new BorderLayout());
		p.add(p1,BorderLayout.CENTER);
		
		
	}
	
	public static JButton getMysql_path_b() {
		return mysql_path_b;
	}


	public static JButton getValide_b() {
		return valide_b;
	}


	public static JButton getSave_path_b() {
		return save_path_b;
	}
	
	
	public static JTextField getTf_db_name() {
		return tf_db_name;
	}


	public static JTextField getTf_mysql_path() {
		return tf_mysql_path;
	}


	public static JTextField getTf_save_path() {
		return tf_save_path;
	}


	public static JPanel get_creation_panel(boolean x) {
		
		return p;
	}

}
