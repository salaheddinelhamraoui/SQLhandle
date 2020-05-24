package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Database;
import models.Sticture;

import models.Table;

public class St_Panel extends JPanel {

	 private  JPanel p = new JPanel();
	 
	 
	 private JTable Table=null;
	 private DefaultTableModel model= new DefaultTableModel();
	 private int dbindex;
	 private int tindex;
	
	 public  JPanel get_creation_panel(Vector<Database> databases,String dbname,String Tname) {
		 Table= new JTable();
		 Table.setRowHeight(28);Table.setRowHeight(0, 23);
			Model();       
			UploadTable(databases,dbname,Tname);
			
			p.setLayout(new BorderLayout());
			JScrollPane sp= new JScrollPane(Table);
			p.add(sp,BorderLayout.CENTER);
			p.setBorder(BorderFactory.createLineBorder(new Color(209, 209, 209),3));
	      return p;
	 }
	 
	 
	 public void Model() {
			
			Table.setModel(model); 
			model.addColumn("Nom");
			model.addColumn("Type");
			model.addColumn("valeur par defaut");
			model.addColumn("Key");
			model.addColumn("Index");
			model.addColumn("Null");
		
			
		}
	 
	 
	 public void UploadTable(Vector<Database> databases,String dbname,String Tname) {	
			 this.dbindex = Sticture.dbindex(databases,dbname);
			 this.tindex = Sticture.Tindex(databases,dbname,Tname);
		 Table T = databases.get(dbindex).getTables().get(tindex);
		 Object[] rows= new Object[6];
		for(int i = 0;i<T.getColumns().size();i++) {
			 String index;
			 String Null;
			 if(T.getColumns().get(i).isIndex()) {
				 index = "true";
			 }else {
				 index="null";
			 }
			 if(T.getColumns().get(i).isNull()) {
				 Null = "true";
			 }else {
				 Null="null";
			 }
			 rows[0]=T.getColumns().get(i).getName();
			 rows[1]=T.getColumns().get(i).getType();
			 rows[2]=T.getColumns().get(i).getDefault();
			 rows[3]=T.getColumns().get(i).getKey();
			 rows[4]=index;
			 rows[5]=Null;
			 model.addRow(rows);
			/* model.addRow(new Object[]{T.getColumns().get(i).getName(),T.getColumns().get(i).getType() , T.getColumns().get(i).getDefault(),T.getColumns().get(i).getKey(),index,Null});
             
		*/
		
		}
		
		
			

	}
	 
	 public void setTable(JTable table) {
		Table = table;
	}


	public void setDbindex(int dbindex1) {
			dbindex = dbindex1;
		}


		public void setTindex(int tindex1) {
			tindex = tindex1;
		}


}
