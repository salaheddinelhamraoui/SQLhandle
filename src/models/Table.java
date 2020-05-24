package models;

import java.util.Vector;

public class Table {
	private String name;
	private Vector<Column> columns ;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector<Column> getColumns() {
		return columns;
	}
	public void setColumns(Vector<Column> columns) {
		this.columns = columns;
	}

}
