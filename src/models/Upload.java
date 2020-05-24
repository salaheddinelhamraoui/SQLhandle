package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
public class Upload {
	private static Vector<Database> databases ;
    private static Vector<Column> columns;
	private static Statement stmt1,stmt2,stmt3;
	private static ResultSet resultset1,resultset2,resultset3;
	private static Vector<Table> tables ;
	
	public static Vector<Database> upload (Connection cnx){
		Database db;
		databases= new Vector<Database>();
		try {
            stmt1 = cnx.createStatement();
            resultset1 = stmt1.executeQuery("SHOW DATABASES;");
 
            if (stmt1.execute("SHOW DATABASES;")) {
                resultset1 = stmt1.getResultSet();
            }
 
            while (resultset1.next()) {
            	if(!resultset1.getString("Database").equals("information_schema") && !resultset1.getString("Database").equals("performance_schema") && !resultset1.getString("Database").equals("phpmyadmin") && !resultset1.getString("Database").equals("mysql")) {
            	db= new Database();
            	db.setName(resultset1.getString("Database"));
            	db.setTables(upload_tables(resultset1.getString("Database"),cnx));
                databases.add(db);
            	}
            }
        }
        catch (Exception ex){
            // handle any errors
            ex.printStackTrace();
        }
		
		return databases;
	}
	
	public static Vector<Table> upload_tables(String database,Connection cnx){
		tables = new Vector<Table>();
		
		
		try {
            stmt2 = cnx.createStatement();
            stmt2.execute("use "+database+" ;");
            resultset2 = stmt2.executeQuery("SHOW TABLES;");
 
            if (stmt2.execute("SHOW TABLES;")) {
                resultset2 = stmt2.getResultSet();
            }
 
            while (resultset2.next()) {
            	Table tab= new Table() ;
            	tab.setName(resultset2.getString("tables_in_"+database));
            	tab.setColumns(upload_columns(database,tab.getName(), cnx));
            	tables.add(tab);
            	
            }
        }
        catch (Exception ex){
            // handle any errors
            ex.printStackTrace();
        }
		

		
		return tables;
	}
	public static resultTable gethistorique(String db,String table, Connection cnx) {
		resultTable result=new resultTable() ;resultColumn clm=null;
		resultRow first = new resultRow();
			
				clm= new resultColumn("<html><strong>ID</strong></html>");
				first.getRow().add(clm);
				clm= new resultColumn("<html><strong>TYPE D'OPERATION</strong></html>");
				first.getRow().add(clm);
				clm= new resultColumn("<html><strong>USER</strong></html>");
				first.getRow().add(clm);
				clm= new resultColumn("<html><strong>CODE</strong></html>");
				first.getRow().add(clm);
				clm= new resultColumn("<html><strong>DATE</strong></html>");
				first.getRow().add(clm);
				
				
			
			result.getTable().add(first);
			 
		try {
            stmt1 = cnx.createStatement();
            stmt2.execute("use "+db+" ;");
            resultset1 = stmt1.executeQuery("SELECT * FROM "+table+";");
 
            if (stmt1.execute("SELECT * FROM "+table+";")) {
                resultset1 = stmt1.getResultSet();
            }
 
            while (resultset1.next()) {
            	first = new resultRow();
    		
    				
    				clm= new resultColumn(resultset1.getString("id"));
    				first.getRow().add(clm);	
    				clm= new resultColumn(resultset1.getString("typeOperation"));
    				first.getRow().add(clm);	
    				clm= new resultColumn(resultset1.getString("user"));
    				first.getRow().add(clm);	
    				clm= new resultColumn(resultset1.getString("code"));
    				first.getRow().add(clm);	
    				clm= new resultColumn(resultset1.getString("dat"));
    				first.getRow().add(clm);	
    			
    			result.getTable().add(first);
    			
            }
        }
        catch (Exception ex){
            // handle any errors
            ex.printStackTrace();
        }
		
		
		
		
		return result;
	}
	
	
	public static resultTable getSELECT(Vector<Database> v_db,String db,String table, Connection cnx) {
		resultTable result=new resultTable() ;resultColumn clm=null;
		Table r_table=Upload.getIndex(v_db, db, table);
		resultRow first = new resultRow();
			for(int i=0;i<r_table.getColumns().size();i++) {
				clm= new resultColumn(r_table.getColumns().get(i).getName());
				first.getRow().add(clm);
				
				
			}
			result.getTable().add(first);
			 ;
		try {
            stmt1 = cnx.createStatement();
            stmt2.execute("use "+db+" ;");
            resultset1 = stmt1.executeQuery("SELECT * FROM "+table+";");
 
            if (stmt1.execute("SELECT * FROM "+table+";")) {
                resultset1 = stmt1.getResultSet();
            }
 
            while (resultset1.next()) {
            	first = new resultRow();
    			for(int i=1;i<=r_table.getColumns().size();i++) {
    				
    				clm= new resultColumn(resultset1.getString(i));
    				first.getRow().add(clm);	
    			}
    			result.getTable().add(first);
    			
            }
        }
        catch (Exception ex){
            // handle any errors
            ex.printStackTrace();
        }
		
		
		
		
		return result;
	}
	
	public static Table getIndex(Vector<Database> db,String dbName,String tableName) {
		
		for(int i=0;i<databases.size();i++) 
			if(databases.get(i).getName().equals(dbName))
				for(int j=0;j<databases.get(i).getTables().size();j++) {
					if(databases.get(i).getTables().get(j).getName().equals(tableName))
						return databases.get(i).getTables().get(j);
						}
					
		return null;
	}
	public static Vector<Column> upload_columns (String database,String table, Connection cnx){
        columns = new Vector<Column>();
	
	
	try {
        stmt3 = cnx.createStatement();
        stmt3.execute("use "+database+" ;");
       
       
        if (stmt3.execute("desc "+table+" ;")) {
            resultset3= stmt3.getResultSet();
        }

        while (resultset3.next()) {
        	
        	/* nom */
        	Column c = new Column() ;
        	c.setName(resultset3.getString("Field"));
        	
        	/* type */ 
        	c.setType(resultset3.getString("Type"));
        	
        	/* null */
        	String statut;
        	statut = resultset3.getString("Null");
        	if (statut.equals("YES")) c.setNull(true);
        	else c.setNull(false);
        	
        	
        	/* pk */
        	c.setKey(resultset3.getString("Key"));
        	
        	/* Default */
        	c.setDefault(resultset3.getString("Default"));
        	
        	columns.add(c);
            
        }
    }
    catch (Exception ex){
        // handle any errors
        ex.printStackTrace();
    }
	

	
	return columns;
}
	
	public static Table upload_one_table(String db ,String table,Connection cnx) {
		Table tmp = new Table();
		tmp.setName(table);
		tmp.setColumns(upload_columns(db, table, cnx));
		return tmp;
	}
	
	
	public static String get_new(Connection cnx,Vector<Database> liste){
			ResultSet resultSet;
		try {		
			
		      stmt1 = cnx.createStatement();
		      resultSet = stmt1.executeQuery("SHOW DATABASES;");
	 
	            if (stmt1.execute("SHOW DATABASES;")) {
	            	resultSet= stmt1.getResultSet();
	            }
	 
	 
			while (resultSet.next()) {
			if(!resultSet.getString("Database").equals("sqlHandle") && !resultSet.getString("Database").equals("information_schema") && !resultSet.getString("Database").equals("performance_schema") && !resultSet.getString("Database").equals("phpmyadmin") && !resultSet.getString("Database").equals("mysql")) 
			  if(!exist(liste, resultSet.getString("Database"))) {
				 return resultSet.getString("Database");
				  
			  }
			}
			resultSet.close();
        }
        catch (Exception ex){
          

        }
		return null;
		
	}
	
	
	public static  boolean exist(Vector<Database> liste,String db) {
		for(int i=0;i<liste.size();i++) 
			if(liste.get(i).getName().equalsIgnoreCase(db))
				return true;

		return false;
	}
	public static Vector<Database> uploadNewDb(Vector<Database> liste,Connection cnx) {
		String db=get_new(cnx, liste);
		Database newdb= new Database();
		newdb.setTables(upload_tables(db, cnx));
		newdb.setName(db);
		liste.add(newdb);
		
		return liste;
	}
	
	public static boolean test_historique(Connection cnx){
		ResultSet resultSet;
	try {		
		
	      stmt1 = cnx.createStatement();
	      resultSet = stmt1.executeQuery("SHOW DATABASES;");
 
            if (stmt1.execute("SHOW DATABASES;")) {
            	resultSet= stmt1.getResultSet();
            }
 
 
		while (resultSet.next()) {
			if(resultSet.getString("Database").equalsIgnoreCase("sqlHandle"))
				return true;
		
		}
		resultSet.close();
    }
    catch (Exception ex){
      

    }
	return false;
	
}
	public static void historique(Connection cnx) {
		if(!test_historique(cnx))
		{
			StringBuffer sql=new StringBuffer("CREATE TABLE sqlHandle.historique ( id INT(20) AUTO_INCREMENT PRIMARY KEY ,typeOperation VARCHAR(50) NOT NULL , CODE TEXT NOT NULL , user VARCHAR(30) NOT NULL,dat  DATETIME NOT NULL);");
			Create.create_db(cnx,"sqlHandle");
			Create.create_tab(cnx, sql, "sqlHandle");
		}
	}
	
	public static void addToHistorique(Connection cnx,String type,String user,String code) {
		StringBuffer sql=new StringBuffer("INSERT INTO historique (id,typeOperation,CODE,user,dat) VALUES ( null,'"+type+"', '"+code+"', '"+user+"',LOCALTIMESTAMP());");
		System.out.println(sql.toString());
		Create.create_tab(cnx, sql, "sqlHandle");
	}
	
	
	
	
}


