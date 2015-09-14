package com.lxz.roughset;

public abstract class Database {
	abstract public DataObjectCollection loadData(String connectionString) throws ApplicationException;
}
