package com.cas.entity;

public class Person {
    public Person(String name) {
        this.name = name;
    }

    private Integer id=1;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
