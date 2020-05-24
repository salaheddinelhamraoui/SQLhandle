package lnterface;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Table;


public class Remplir_table {
	private JTable table= new JTable();
	private DefaultTableModel model= new DefaultTableModel();
	private int clumns=0;
	public JScrollPane get_table(Table table_r) {
		table.setRowHeight(25);table.setRowHeight(0, 23);
		for(int i=0;i<table_r.getColumns().size();i++) {
			model.addColumn(table_r.getColumns().get(i).getName()+" -- "+table_r.getColumns().get(i).getType()+"");
		}
		table.setModel(model); 
		clumns=table_r.getColumns().size();
		
		
	
		JScrollPane s= new JScrollPane(table);
		return s;
	}
	public  void addRow(int lines) {
		Object[] obj= new Object[clumns];
		for(int j=0;j<clumns;j++)
			obj[j]="";
		
		for(int i=0;i<lines;i++)
			model.addRow(obj);
		
		
	}
	public void remove () {
		int i=0;
		while(table.getRowCount()!=0)
			model.removeRow(i);
		i++;
	}
	public StringBuffer toSqlCode (String table_name,Table table_r) {
		StringBuffer sqlcode = new StringBuffer("insert into ");
	
		sqlcode.append( table_name+" values ");sqlcode.append('\n');
		for (int i=0; i<table.getRowCount();i++) 
		{
			sqlcode.append("(");
			for(int j=0;j<table.getColumnCount();j++)
			{
				String tmp0=table_r.getColumns().get(j).getType();
				String[] tmp1=tmp0.split("\\(");
				if(tmp1[0].equalsIgnoreCase("int") || tmp1[0].equalsIgnoreCase("float"))
				{
					sqlcode.append(table.getModel().getValueAt(i,j));
				}
				else
				{
					sqlcode.append("'");
					sqlcode.append(table.getModel().getValueAt(i,j));
					sqlcode.append("'");
				}
								
				if(j!=(table.getColumnCount()-1)) sqlcode.append(",");
			}
			sqlcode.append(")");
			if(i!=(table.getRowCount()-1)) sqlcode.append(",");
		}
		
		return sqlcode;	
	}
	







}
