package lnterface;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.resultTable;

public class Result_Panel {
	private  JPanel p= new JPanel();
	private  JTable table= new JTable();
	private  DefaultTableModel model= new DefaultTableModel();
	
	
	public  JPanel get_resulte_panel(resultTable table_r) {
		table.setRowHeight(28);table.setRowHeight(0, 23);
		for(int i=0;i<table_r.getTable().get(0).getRow().size();i++) {
			model.addColumn(table_r.getTable().get(0).getRow().get(i).getData());
			
		}
		Object[] rows= new Object[table_r.getTable().get(0).getRow().size()];
		for(int i=1;i<table_r.getTable().size();i++) {
			for(int j=0;j<table_r.getTable().get(i).getRow().size();j++) {
				rows[j]=table_r.getTable().get(i).getRow().get(j).getData();	
			}
			model.addRow(rows);
		}
		
		table.setModel(model);
		
		JScrollPane s = new JScrollPane(table);
		p.setLayout(new BorderLayout());
		p.add(s,BorderLayout.CENTER);
	//	table.setEnabled(false);
		
		return p;
	}


	public  JPanel getP() {
		return p;
	}


	public JTable getTable() {
		return table;
	}

	
	
	
	
}
