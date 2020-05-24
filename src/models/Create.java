package models;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Create {
	private static Statement stmt1;
	
	
	
	public static boolean create_tab(Connection cnx,StringBuffer sql ,String db_name){

		try {
            stmt1 = cnx.createStatement();
            stmt1.execute("use "+db_name+";");
            stmt1.execute(sql.toString());
          

        }
        catch (Exception ex){
            // handle any errors
        	String err=ex.getMessage();
        	err=err.replaceFirst( "manual that corresponds to your MariaDB server version for the", "");
        	err=err.replace(';','\n');
        	
            
        	JOptionPane.showMessageDialog(new JFrame(),err
				    ,
				    "impossible",
				    JOptionPane.WARNING_MESSAGE);
        	return false;
        }
		return true ;
		
	}
	public static boolean create_db(Connection cnx,	String db_name ){
		
		String c="create database "+db_name+"";
		try {
            stmt1 = cnx.createStatement();      
            stmt1.execute(c);
          
            
        }
        catch (Exception ex){
            // handle any errors
        	String err=ex.getMessage();
        	err=err.replaceFirst( "manual that corresponds to your MariaDB server version for the", "");
        	err=err.replace(';','\n');
        	JOptionPane.showMessageDialog(new JFrame(),err
				    ,
				    "impossible",
				    JOptionPane.WARNING_MESSAGE);
            return false;
        }
		return true ;
		
	}
	public static boolean insert(Connection cnx,StringBuffer sql ,String db_name){

		try {
            stmt1 = cnx.createStatement();
            stmt1.execute("use "+db_name+";");
            stmt1.execute(sql.toString());
          

        }
        catch (Exception ex){
            // handle any errors
        	String err=ex.getMessage();
        	err=err.replaceFirst( "manual that corresponds to your MariaDB server version for the", "");
        	err=err.replace(';','\n');           
        	JOptionPane.showMessageDialog(new JFrame(),err
				    ,
				    "impossible",
				    JOptionPane.WARNING_MESSAGE);
        	return false;
        }
		return true ;
		
	}

	
	





}
