package com.company;

import java.util.UUID;

abstract class Person {
    private final String personId = UUID.randomUUID().toString();
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPersonId() {
        return personId;
    }
}
