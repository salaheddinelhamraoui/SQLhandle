package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class R_TO_JT {
	private String requete;
	private Statement stmt1;
	private Connection cnx;
	private String[] arrOfStr;
	private String db_name;

	public R_TO_JT(String requete1, Connection cnx1, String db_name1) {
		requete = requete1;
		cnx = cnx1;
		db_name = db_name1;
	}
	
	

	public void splite_requetes() {
		arrOfStr = requete.split(";");
		for (int i = 0; i < arrOfStr.length; i++)
			arrOfStr[i] = arrOfStr[i] + ";";
		
	}
	
	public boolean execute_requetes() {
		String s,s2,s3;
		boolean x=false;
		for (int i = 0; i < arrOfStr.length; i++) {
			s = requete_type(arrOfStr[i]);
			
			s2=arrOfStr[i];
			if(!s.equals(null)) {
				
				if(s=="no result") {
					
					try {
						x= No_result_requete(s2);
					}catch(Exception ex){
						s3=ex.getMessage();
						JOptionPane.showMessageDialog(null, s3);
					}
					
					
				}else if(s=="avec result") {
					
					try {
						result_requete(s2);
					} catch (Exception e1) {
						s3=e1.getMessage();
						JOptionPane.showMessageDialog(null, s3);
					}
					
				}
			}
				
		}
		
		
		return x;
	}
	




	public String requete_type(String single_requete) {
		boolean isFound;
		String[] T_s_no = {"update","create","drop","delete","insert"}; 
		String[] T_s_oui = {"select","desc"};
		for (int i = 0; i < T_s_no.length; i++) {
		isFound = single_requete.toLowerCase().indexOf(T_s_no[i]) !=-1? true: false;
		if(isFound == true) {
			 
			return "no result";
		}
		}
		for (int i = 0; i < T_s_oui.length; i++) {
			isFound = single_requete.toLowerCase().indexOf(T_s_oui[i]) !=-1? true: false;
			if(isFound == true) {
				 
				return "avec result";
			}
			}
		
		
		
		
		return null;
	}
	
	
	public boolean No_result_requete(String requete) {
		boolean x=false;
		try {
            //getting database connection to MySQL server
			stmt1 = cnx.createStatement();
           
            //getting PreparedStatment to execute query
			String s5="use "+db_name+";";
			
			stmt1.execute(s5);
			
            stmt1 = cnx.prepareStatement(requete);  
            stmt1.execute(requete);
            x=true;
            JOptionPane.showMessageDialog(null, "La requete est bien exécuter");
           
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        	x=false;
        } finally{
           
        }
		
	
		return x;
	}
	
	
	public boolean result_requete(String s) throws Exception {
		boolean x=false;
		
		//try {
		
			String s6="use "+db_name+";";
		stmt1 = cnx.createStatement();
        stmt1.execute(s6);
        //tmt1 = cnx.prepareStatement(s);  
		ResultSet rs = stmt1.executeQuery(s);

	    // It creates and displays the table
	    JTable table = new JTable(buildTableModel(rs));

	    // Closes the Connection

	    JOptionPane.showMessageDialog(null, new JScrollPane(table));
	    x=true;
		//}
		//catch (SQLException ex){
		//	JOptionPane.showMessageDialog(null, ex.getMessage());
        //	x=false;
		//}
	    
	    
	    
		return x;
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	
	
	public String[] getArrOfStr() {
		return arrOfStr;
	}



	public String getRequete() {
		return requete;
	}
	

}
