package com.wb.model;

import java.util.Date;

/**
 * person_id - auto int 11
 * person_name 32 varchar	not null
 * person_age 4 int
 * person_tel 11 varchar
 * person_sex 1 char
 */
public class PersonImpl implements Person {

	private int id;
	private String name;
	private int age;
	private String phoneNumber;
	private char sex;
	private Planet planet;
	private Date birth;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonImpl [id=" + id + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", sex="
				+ sex + ", planet=" + planet + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
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
	/**
	 * @return the planet
	 */
	public Planet getPlanet() {
		return planet;
	}
	/**
	 * @param planet the planet to set
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
    /**
     * @return the birth
     */
    public Date getBirth() {
        return birth;
    }
    /**
     * @param birth the birth to set
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

}
