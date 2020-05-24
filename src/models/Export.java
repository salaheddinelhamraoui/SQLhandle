package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.ibatis.jdbc.ScriptRunner;

import DbManagment.DbConnection;

public class Export {
	
	private static String file_path;
	private static boolean Error_St=false;
	private String message;
	private static String dbname;
	private static String mysql_path;
	
	
	
	public Export(String file, String dbname1, String mysql_path1) {
	    file_path=file;
	    dbname=dbname1;
	    mysql_path=mysql_path1;
	    
	}
	public  void Backupdbtosql() {
	    try {

	        
	        
	        String dbUser = DbConnection.getUsername();
	        String dbPass = DbConnection.getPassword();
	        
	        String executeCmd;
	        if(dbPass.equals("")) {
	        	executeCmd = mysql_path + "\\bin\\mysqldump -u " + dbUser  + " --database " + dbname + " -r " + file_path +"\\"+dbname+".sql";
	        }else {
	        	executeCmd = mysql_path + "\\bin\\mysqldump -u " + dbUser  + " -p" + dbPass + " --database " + dbname + " -r " + file_path +"\\"+dbname+".sql";
	        }

	         
	       
	        Process runtimeProcess = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", executeCmd });
	        int processComplete = runtimeProcess.waitFor();

	        
	        if (processComplete == 0) {
	        	JOptionPane.showMessageDialog(null, "Backup Complete");
	            
	        } else {
	        	JOptionPane.showMessageDialog(null,"Backup Failure");
	        }

	    } catch (IOException | InterruptedException ex) {
	        JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
	    }
	}
	

	
	
	public String getFile_path() {
		return file_path;
	}


	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}


	public static boolean isError_St() {
		return Error_St;
	}


	public static void setError_St(boolean error_St) {
		Error_St = error_St;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDbname() {
		return dbname;
	}


	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
}
