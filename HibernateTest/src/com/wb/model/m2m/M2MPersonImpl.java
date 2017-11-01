package com.wb.model.m2m;

public class M2MPersonImpl implements M2MPerson {

    private String name;
    
    private short age;
    
    private int id;
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public short getAge() {
        return this.age;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

}
