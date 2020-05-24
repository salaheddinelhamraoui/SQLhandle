package models;

import java.sql.Connection;
import java.sql.Statement;

public class Drop_sql {
	private static Statement stmt1;
	private static boolean x;
	
	
	
	public static boolean drop_tab(Connection cnx,String tab_name ,String db_name){
		x=false;
		String sql="DROP TABLE "+tab_name+";";
		try {
            stmt1 = cnx.createStatement();
            stmt1.execute("use "+db_name+";");
             if (stmt1.execute(sql)) {
               x=true;
            }
 
            
        }
        catch (Exception ex){
            // handle any errors
            ex.printStackTrace();
        }
		return x ;
		
	}
	
	
	public static boolean drop_db(Connection cnx,String db_name){
		x=false;
		String sql="DROP database "+db_name+";";
		try {
            stmt1 = cnx.createStatement();
             if (stmt1.execute(sql)) {
               x=true;
            }
 
            
        }
        catch (Exception ex){
            // handle any errors
            ex.printStackTrace();
        }
		return x ;
		
	}
}
