package Tema;
import java.util.Arrays;
import java.util.Scanner;
public class Anagrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        char chars1[] = str1.toCharArray();
        char chars2[] = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);


        if(new String(chars1).equals(new String (chars2))){
            System.out.println("Sunt anagrame");
        }
        else
            System.out.println("Nu sunt anagrame");
    }
}
