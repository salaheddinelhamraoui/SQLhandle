package lnterface;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CreationOfTable_top {
	private static JPanel p = new JPanel();
	private static JLabel lblDb_name= new JLabel("le nom de table");
	private static	JLabel lbl_tablesNumber= new JLabel("le nombre des colonnes");
	private static JButton  btn_exe = new JButton("executer");
	private static JTextField db_name= new JTextField(10); 
	private static	JTextField tables_number= new JTextField(5);

	
	
	public static JPanel getTopPan() {
		p.setLayout(new FlowLayout());
		p.add(lblDb_name);
		p.add(db_name);
		p.add(lbl_tablesNumber);
		p.add(tables_number);
		p.add(btn_exe);
		
		tables_number.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	             boolean ret = true;
	                try {

	                    Double.parseDouble(tables_number.getText()+e.getKeyChar());
	                }catch (NumberFormatException ee) {
	                    ret = false;
	                }


	            if (!ret) {
	                e.consume();
	            }
	        }
	    });
		
		
		return p;
		
	}



	static JButton getBtn_exe() {
		return btn_exe;
	}



	static JTextField getDb_name() {
		return db_name;
	}



	static JTextField getTables_number() {
		return tables_number;
	}



	static void setBtn_exe(JButton btn_exe) {
		CreationOfTable_top.btn_exe = btn_exe;
	}



	static void setDb_name(JTextField db_name) {
		CreationOfTable_top.db_name = db_name;
	}



	static void setTables_number(JTextField tables_number) {
		CreationOfTable_top.tables_number = tables_number;
	}
	
	


}
