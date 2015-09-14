package com.lxz.roughset;

public class SystemParameters {
	private String m_strLogPath = "";
	private String m_strDatabase = "";
	private String m_strObjectIndexList = "";
	private String m_strAttributeIndexList = "";
	
	public String getLogPath() {
		return m_strLogPath;
	}
	
	public void setLogPath(String m_strLogPath) {
		this.m_strLogPath = m_strLogPath;
	}
	
	public String getDatabase() {
		return m_strDatabase;
	}
	
	public void setDatabase(String m_strDatabase) {
		this.m_strDatabase = m_strDatabase;
	}
	
	public String getObjectIndexList() {
		return m_strObjectIndexList;
	}
	
	public void setObjectIndexList(String m_strObjectIndexList) {
		this.m_strObjectIndexList = m_strObjectIndexList;
	}
	
	public String getAttributeIndexList() {
		return m_strAttributeIndexList;
	}
	
	public void setAttributeIndexList(String m_strAttributeIndexList) {
		this.m_strAttributeIndexList = m_strAttributeIndexList;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(" ------- System parameters ------- " + "\n");
		sb.append("Log Path ................... :" + this.getLogPath() + "\n");
		sb.append("Database Path .............. :" + this.getDatabase() + "\n");
		sb.append("Object Index List .......... :" + this.getObjectIndexList() + "\n");
		sb.append("Attribute Index List ....... :" + this.getAttributeIndexList() + "\n");
		sb.append(" --------------------------------- " + "\n");
		return sb.toString();
	}
}
