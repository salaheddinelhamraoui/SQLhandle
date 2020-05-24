package models;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import org.apache.ibatis.jdbc.ScriptRunner;

public class Import {
	private String file_path;
	private static boolean Error_St=false;
	private String message;
	public Import(String file) {
	    file_path=file;
	}
	
	
	
	
	public  boolean executer(Connection cnx) {
			File f;
		try {
			f= new java.io.File(file_path);
			ScriptRunner sr = new ScriptRunner(cnx);
	      //Creating a reader object
	      Reader reader = new BufferedReader(new FileReader(file_path));
	      //Running the script
	      sr.runScript(reader);

		}
		
		catch (Exception ex){
            // handle any errors
            Error_St=true;
            
            JOptionPane.showMessageDialog(null,"Import Failure");
            message=ex.getMessage();
           
        }
		
	      
		
		return Error_St;
		
	}


	public String getMessage() {
		return message;
	}
	public static boolean isError_St() {
		return Error_St;
	}




	public static void setError_St(boolean error_St) {
		Error_St = error_St;
	}

}
