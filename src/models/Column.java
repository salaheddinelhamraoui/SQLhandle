package models;

public class Column {
	private String name,type,Default,extra,Key;
	private boolean index,Null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String Key) {
		this.Key = Key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDefault() {
		return Default;
	}
	public void setDefault(String default1) {
		Default = default1;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}

	public boolean isIndex() {
		return index;
	}
	public void setIndex(boolean index) {
		this.index = index;
	}
	public boolean isNull() {
		return Null;
	}
	public void setNull(boolean null1) {
		Null = null1;
	}
	
}
