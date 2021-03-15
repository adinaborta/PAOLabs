package Tema;
import java.lang.Math;
import java.util.Objects;

abstract public class CandyBox {
    String flavour;
    String origin;

    public CandyBox(){
        this.flavour = "Vanilla";
        this.origin = "Japanese";
    }

    public CandyBox(String flavour, String origin) {
        this.flavour = flavour;
        this.origin = origin;
    }

    public String getFlavour() {
        return flavour;
    }

    public String getOrigin() {
        return origin;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    abstract public double getVolume();

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavour='" + flavour + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}


class Merci extends CandyBox{

    int length;

    public Merci() {
        this.length = 0;
    }

    public Merci(String flavour, String origin, int length) {
        super(flavour, origin);
        this.length = length;
    }

    @Override
    public double getVolume() {
        return Math.pow(this.length,3) / 1000.0;
    }

    @Override
    public String toString() {
        return "This Merci box contains "+ origin+ " " + flavour + " candies and it has a volume of " + this.getVolume() + " l";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merci merci = (Merci) o;
        return (this.getVolume() == merci.getVolume() && this.flavour == merci.flavour && this.origin == merci.origin);
    }
}

class Lindt extends CandyBox{

    int length;
    int width;
    int height;

    public Lindt() {
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }

    public Lindt(String flavour, String origin, int length, int width, int height) {
        super(flavour, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return length * width * height / 1000.0;
    }

    @Override
    public String toString() {
        return "This Lindt box contains "+ origin+ " " + flavour + " candies and it has a volume of " + this.getVolume() + "l";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lindt lindt = (Lindt) o;
        return this.getVolume() == lindt.getVolume() && this.flavour == lindt.flavour && this.origin == lindt.origin;
    }
}

class Milka extends CandyBox{
    int radius;
    int height;

    public Milka() {
        this.radius = 0;
        this.height = 0;
    }

    public Milka(String flavour, String origin, int radius, int height) {
        super(flavour, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.round(Math.PI * radius * radius * height) / 1000.0;
    }
    @Override
    public String toString() {
        return "This Milka box contains "+ origin+ " " + flavour + " candies and it has a volume of " + this.getVolume() + "l";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milka milka = (Milka) o;
        return this.getVolume() == milka.getVolume() && this.flavour == milka.flavour && this.origin == milka.origin;
    }
}

class CandyBag{
    CandyBox [] candyBoxes = {
            new Milka("chocolate", "italian", 10, 3),
            new Lindt("milk chocolate", "german", 5, 4, 6),
            new Lindt("milk chocolate","german",  4, 6, 5),
            new Milka("chocolate coated nut","romanian",  4, 6),
            new Merci("white chocolate", "french", 10),
            new Merci("white chocolate", "french", 10),
            new Merci()
    };
}

class Area{
    CandyBag candyBag;
    int number = 0;
    String street = "";

    public Area() {
        this.candyBag = new CandyBag();
    }

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    public void printAdress(){
        System.out.println(number + ' ' + street);
        for (int i = 0; i < this.candyBag.candyBoxes.length; i++){
            System.out.println(this.candyBag.candyBoxes[i].toString());
        }
    }

}

class Main{
    public static void main(String[] args) {
        Area area = new Area();
        area.printAdress();
    }
}












