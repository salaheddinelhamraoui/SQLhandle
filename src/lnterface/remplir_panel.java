package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.Create;
import models.Table;

public class remplir_panel {
	private     JPanel p0 = new JPanel(),p1= new JPanel(),p3= new JPanel() ;
	private 	JLabel lbl_linesNumber= new JLabel("le nombre des enregistrements");
	private  	JButton execute= new JButton("<Html><strong style=color:white >execute</strong></html>"),clear= new JButton("<Html><strong style=color:white >clear</strong></html>"),btn_exe= new JButton("executer");
	private 	JTextField lines_number= new JTextField(5);
	
	
	public JPanel getRemplir_panel(Table table,String db_name) {
		execute.setBackground(Color.BLACK);clear.setBackground(Color.black);
		Remplir_table tmp= new Remplir_table();
		p0.setLayout(new BorderLayout());
		p0.add(p1,BorderLayout.NORTH);p0.add(p3,BorderLayout.SOUTH);p0.add(tmp.get_table(table),BorderLayout.CENTER);
		p1.setLayout(new FlowLayout());
		p1.add(lbl_linesNumber);p1.add(lines_number);p1.add(btn_exe);
		p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			p3.add(execute);
			p3.add(clear);
			
			//----------- some actions listners for the nombre of rows 
			
			
		btn_exe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lines_number.getText().isEmpty())
					JOptionPane.showMessageDialog(new JFrame(),"le nombre des enregistrements est vide !"
						    ,
						    "impossible",
						    JOptionPane.WARNING_MESSAGE);	
				else 
				{
					tmp.addRow(Integer.parseInt(lines_number.getText()));
				}
			}
		});
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tmp.remove();
				lines_number.setText("");		
			}
		});
		

		lines_number.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	             boolean ret = true;
	                try {

	                    Double.parseDouble(lines_number.getText()+e.getKeyChar());
	                }catch (NumberFormatException ee) {
	                    ret = false;
	                }


	            if (!ret) {
	                e.consume();
	            }
	        }
	    });
		
		
		execute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(lines_number.getText().isEmpty())
					JOptionPane.showMessageDialog(new JFrame(),"remplir  au moins un enregistrement"
						    ,
						    "Message",
						    JOptionPane.WARNING_MESSAGE);
				else 
				{
				StringBuffer sql=tmp.toSqlCode(table.getName() ,table);
				
				if(Create.insert(Run.getCnx(), sql, db_name))
				{
					JOptionPane.showMessageDialog(new JFrame(), "réussir", "Message", JOptionPane.PLAIN_MESSAGE);
				}
				}
			}
		});
		
	
		return p0;
	}


}
