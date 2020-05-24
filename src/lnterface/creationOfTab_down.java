package lnterface;


import java.awt.Dimension;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class creationOfTab_down {
	private static int lines=20;
	private static JTable Table=null;
	private static DefaultTableModel model= new DefaultTableModel();
	
	public  JScrollPane getDownPan(boolean x) {
		Table= new JTable();Table.setRowHeight(28);Table.setRowHeight(0, 23);
		Model(x);       
		JScrollPane sp= new JScrollPane(Table);		
		TableColumn type_ch= Table.getColumnModel().getColumn(1);
		JComboBox<String> types_ch= new JComboBox<String>();
		types_ch.addItem("int");types_ch.addItem("varchar");types_ch.addItem("float");types_ch.addItem("date");
		type_ch.setCellEditor(new DefaultCellEditor(types_ch));
		TableColumn null_ch=Table.getColumnModel().getColumn(4);
		TableColumn auto_ch= Table.getColumnModel().getColumn(5);
		TableColumn index_ch= Table.getColumnModel().getColumn(6);
		JComboBox<String> Null_ch= new JComboBox<String>();
		Null_ch.addItem("False");Null_ch.addItem("True");
		JComboBox<String> Auto_ch= new JComboBox<String>();
		Auto_ch.addItem("False");Auto_ch.addItem("True");
		JComboBox<String> Idex_ch= new JComboBox<String>();
		Idex_ch.addItem("Primary key");Idex_ch.addItem("Index");Idex_ch.addItem("Unique");
		null_ch.setCellEditor(new DefaultCellEditor(Null_ch));
		auto_ch.setCellEditor(new DefaultCellEditor(Auto_ch));
		index_ch.setCellEditor(new DefaultCellEditor(Idex_ch));
		sp.setPreferredSize(new Dimension(400, 180));
		return sp;
	}
	
	public static Object[][] getRow(int taille){
		Object[][] data = new Object[taille][7];
		
		for(int i=0;i<taille ;i++) {
			data[i][0]="";
			data[i][1]="int";
			data[i][2]="";
			data[i][3]="";
			data[i][4]="false";
			data[i][5]="false";
			data[i][6]="---";
		}		
	return data;
	}



	static int getLines() {
		return lines;
	}



	static JTable getTable() {
		return Table;
	}


	static void setLines(int lines) {
		creationOfTab_down.lines = lines;
	}

	static void setTable(JTable table) {
		Table = table;
	}
	
	
	public static void Model(boolean x) {
		
		Table.setModel(model);
		if(x==true) {
		model.addColumn("<html><strong>NOM</strong></html>");
		model.addColumn("<html><strong>TYPE</strong></html>");
		model.addColumn("<html><strong>TAILLE</strong></html>");
		model.addColumn("<html><strong>VALEUR PAR DEFAUT</strong></html>");
		model.addColumn("<html><strong>NULL</strong></html>");
		model.addColumn("<html><strong>AUTO-INCR</strong></html>");
		model.addColumn("<html><strong>INDEX</strong></html>");
		}
		///////////////__________________________add Model(); to 
	}
	
	public static void addRow(int lines) {
		for(int i=0;i<lines;i++)
			model.addRow(new Object[] {
			"",
			"int",
			"10",
			"",
			"false",
			"false",
			"---",
			});
	}
	public static void remove () {
		int i=0;
		while(creationOfTab_down.getTable().getRowCount()!=0)
			model.removeRow(i);
		i++;
	}
	public static StringBuffer toSqlCode (JTable table,String table_name, int nombre) {
		StringBuffer sqlcode = new StringBuffer("create table ");
	
		sqlcode.append( table_name+" (");
		for (int i = 0 ; i<nombre ; i++) {
			
		
		sqlcode.append(table.getModel().getValueAt(i,0));
		 sqlcode.append(" ");
		sqlcode.append(table.getModel().getValueAt(i,1));
		sqlcode.append("(");
		sqlcode.append(table.getModel().getValueAt(i,2));
		sqlcode.append(") ");
		
		
		if ( (String) table.getModel().getValueAt(i,3) != "") {
			sqlcode.append("DEFAULT ");
			sqlcode.append("'");
			sqlcode.append(table.getModel().getValueAt(i,3));
			sqlcode.append("' ");
			
		}
		if ( (String) table.getModel().getValueAt(i,4) == "false") {
			sqlcode.append("NOT NULL ");	
			}
		else {
			sqlcode.append("NULL ");
		}
		
		if ( (String) table.getModel().getValueAt(i,5) == "True") {
			sqlcode.append("AUTO_INCREMENT ");
		}
		
		if ( (String) table.getModel().getValueAt(i,6) == "Primary key") {
			sqlcode.append("Primary key ");
		}
		if ( (String) table.getModel().getValueAt(i,6) == "Index") {
			sqlcode.append("Index ");
		}
		if((i)!=(nombre-1))
			sqlcode.append(",");
			sqlcode.append('\n');
		}
		sqlcode.append(");");
		return sqlcode;	
	}
}
