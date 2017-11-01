package com.wb.model;

import java.util.Set;

/**
 */
public interface Planet {

	public abstract String getName();
	void setName(String name);
	
	Set<Person> getPerson();
	void setPerson(Set<Person> p);
	
	int getId();
	void setId(int id);
	
	int getAge();
	void setAge(int a);
}
