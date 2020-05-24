package models;

import java.util.Vector;

public class Database {
	private String Name,user;
	private int nombre_tables;
	private Vector<Table> tables ;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getNombre_tables() {
		return nombre_tables;
	}
	public void setNombre_tables(int nombre_tables) {
		this.nombre_tables = nombre_tables;
	}
	public Vector<Table> getTables() {
		return tables;
	}
	public void setTables(Vector<Table> tables) {
		this.tables = tables;
	}
	
	
	
	
	

}
