package com.example.demo;

import lombok.Data;

@Data
public class Person {

    private String name;
    private String age;

    public Person(String name,String age){
        this.name=name;
        this.age=age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Person)obj).name);
    }
}
