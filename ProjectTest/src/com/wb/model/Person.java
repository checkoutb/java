package com.wb.model;

/**
 * person_id - auto int 11
 * person_name 32 varchar	not null
 * person_age 4 int
 * person_tel 11 varchar
 * person_sex 1 char
 */
public interface Person {

	public int getId();		//忘记了，，不然删除怎么删？肯定要一个key的。
	
	public String getName();
	public void setName(String name);
	
	public int getAge();
	public void setAge(int age);
	
	public String getPhoneNumber();
	public void setPhoneNumber(String phone);
	
	public char getSex();
	public void setSex(char sex);
}
