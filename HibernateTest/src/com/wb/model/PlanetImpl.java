package com.wb.model;

import java.util.Set;

/**
 */
public class PlanetImpl implements Planet {

	private int id;
	
	private String name;
	
	private Set<Person> person;
	
	private int age;
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlanetImpl [id=" + id + ", name=" + name + ", person=..." + ", age=" + age + "]";
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.wb.model.Planet#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see com.wb.model.Planet#setName()
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.wb.model.Planet#getPerson()
	 */
	@Override
	public Set<Person> getPerson() {
		// TODO Auto-generated method stub
		return person;
	}

	/* (non-Javadoc)
	 * @see com.wb.model.Planet#setPerson()
	 */
	@Override
	public void setPerson(Set<Person> p) {
		// TODO Auto-generated method stub
		this.person = p;
	}

}
