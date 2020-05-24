package models;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class resultTable {
	private Vector<resultRow> table=new Vector<resultRow>();



	public Vector<resultRow> getTable() {
		return table;
	}

	public  void setTable(Vector<resultRow> table) {
		this.table = table;
	}

	public void setModel(DefaultTableModel model) {
		// TODO Auto-generated method stub
		
	}
	
	
}
