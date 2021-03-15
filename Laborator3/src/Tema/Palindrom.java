package Tema;
import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder inv = new StringBuilder(str);
        if(inv.reverse().toString().equals(str)){
            System.out.println("Este palindrom");
        }
        else{
            System.out.println("Nu este palindrom");
        }
    }

}
