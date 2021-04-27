package com.company;

import java.util.UUID;

abstract class Person {
    private final String personId;
    private String name;

    public Person(String id, String name) {
        this.name = name;
        this.personId = id;
    }

    public Person(String name) {
        this.name = name;
        this.personId = UUID.randomUUID().toString();
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
