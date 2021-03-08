// Write a program to create a Room object, the attributes of this object are room number, room type and room floor.
// Define a constructor for this class as well as accessors and mutators for all the attributes. Create two objects
// of type and display the information for them on separate lines.

package com.company.problema2;

public class Room {
    private int roomNumber;
    private String roomType;
    private int floor;

    public Room(){}

    public Room(int roomNumber, String roomType, int floor) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getFloor() {
        return floor;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Your room is a " + this.roomType + " room, floor " + this.floor + ", number " + this.roomNumber + ". Have a nice day!";
    }
}

class Main{
    public static void main(String[] args) {
        Room room1 = new Room(27, "Double", 3);
        Room room2 = new Room(19, "Standard", 2);

        System.out.println(room1.toString());
        System.out.println();
        System.out.println(room2.toString());

    }
}