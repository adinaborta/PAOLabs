// Write a program to create an object Subject with the following attributes: room as Room, noOfStudents as integer,
// teacher as Person. Define a constructor for this class as well as accessors and mutators for all the attributes.
// Create two objects of type Subject and display the information for them on separate lines.

package com.company.problema3;
import com.company.problema1.Person;
import com.company.problema2.Room;

public class Subject {
    private Room room;
    private int noOfStudents;
    private Person person;

    public Subject(){}
    public Subject(Room room, int noOfStudents, Person person) {
        this.room = room;
        this.noOfStudents = noOfStudents;
        this.person = person;
    }

    public Room getRoom() {
        return room;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public Person getPerson() {
        return person;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "You have a class in the " + this.room.getRoomType() + " room, no " + this.room.getRoomNumber() + " on the " + this.room.getFloor()
                + " floor. There are " + this.noOfStudents + " students in this class and the teacher for this subject will be " +
                this.person.getName() + " " + this.person.getSurname() + ".";
    }
}
class Main {

    public static void main(String[] args) {
        Room room1 = new Room(27, "Chemistry", 3);
        Room room2 = new Room(19, "Laboratory", 2);

        Person person1 = new Person("Borta", "Adina", 20, 61207777777l, "woman");
        Person person2 = new Person ("Mihaela", "Ivan", 25, 603048888888l, "woman");

        Subject subject1 = new Subject(room1, 30, person1);
        Subject subject2 = new Subject(room2, 35, person2);

        System.out.println(subject1.toString());
        System.out.println(subject2.toString());


    }
}