package models;

import java.util.Vector;

public class Sticture {
	
	
	
	
	public static int dbindex (Vector<Database> databases,String Dbname) {
		
		for(int i=0;i<databases.size();i++) {
			
			String s = databases.get(i).getName();
		if(Dbname.equals(s) )
		{
			
		 return i;
		}
		}
		return -1;
	}
	
	public static int Tindex(Vector<Database> databases, String Dbname, String Tname) {
		
		if (dbindex(databases,Dbname) == -1) {
			return -1;
		}else {
			for(int i=0;i<databases.get(dbindex(databases,Dbname)).getTables().size();i++) {
				if(databases.get(dbindex(databases,Dbname)).getTables().get(i).getName().equals(Tname)) {
					return i;
				}
		}
		}
		return -2;
		
		
	}

}
