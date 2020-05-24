package DbManagment;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
    private  static Connection cnx=null;
	


	private  String db_type; 
	private  static  String username;
	private  static  String Password;
	private  static  String port;
	private  String error_message="";
	private  int error_statut=0;
	
	
    public  Connection getConnection() {
    	    String fname,link ;
    	    	fname="com.mysql.jdbc.Driver";
    	    	link="jdbc:mysql://localhost:"+port+"/mysql";	

    	    	
    	
    	
    	
    		try {
    			Class.forName(fname);
    			cnx=DriverManager.getConnection(link,username,Password);
    			
    		} catch (Exception e) {
    			error_message=e.getMessage();
    			error_statut=1;
    		}
    		
    		
    		
    return cnx;
    }


	public static String getPort() {
		return port;
	}


	public static void setPort(String port) {
		DbConnection.port = port;
	}


	public String getDb_type() {
		return db_type;
	}


	public static   String getUsername() {
		return username;
	}


	public static   String getPassword() {
		return Password;
	}


	public  String getError_message() {
		return error_message;
	}


	public  int getError_statut() {
		return error_statut;
	}


	public void setDb_type(String db_type) {
		this.db_type = db_type;
	}


	 public void setUsername(String username) {
		this.username = username;
	}


	 public void setPassword(String password) {
		Password = password;
	}


	public void setError_message(String error_message) {
		this.error_message = error_message;
	}


	public void setError_statut(int error_statut) {
		this.error_statut = error_statut;
	}
    static Connection getCnx() {
		return cnx;
	}
    
    


}