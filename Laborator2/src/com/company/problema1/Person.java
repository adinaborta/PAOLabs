// Write a program to create a Person object, with the following attributes: name as string, surname as string, age as int,
// identity number as long, type as string. Define a constructor for this class as well as accessors and mutators for all
// the attributes. Create two objects of type Person and display the information for them on separate lines.

package com.company.problema1;

public class Person {
    private String name;
    private String surname;
    private int age;
    private long identityNumber;
    private String type;

    public Person (){}

    public Person(String name, String surname, int age, long identityNumber, String type) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.identityNumber = identityNumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public long getIdentityNumber() {
        return identityNumber;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdentityNumber(long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "This is " + this.getName() + " " + this.getSurname() +
                ". I am a " + this.getAge() + " years old " + this.getType() + ". My identity number is: " + this.getIdentityNumber();
    }
}

class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Borta", "Adina", 20, 61207777777l, "woman");
        Person person2 = new Person ("Mihaela", "Ivan", 25, 603048888888l, "woman");

        System.out.printf(person1.toString());
        System.out.println();
        System.out.printf(person2.toString());

    }
}
