package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        1. Scrieti un program care sa afișeze toate numerele pare din intervalul [0,n], unde n este un numar citit de la tastatura.
//        int n = scanner.nextInt();
//        for (int i = 0; i <= n; i++){
//            if(i%2 == 0)
//                System.out.println(i);
//        }

//        2. Scrieți un program care sa compare doua numere a și b citite de la tastaturasi sa afiseze numarul mai mare.
//        int a, b;
//        a = scanner.nextInt();
//        b = scanner.nextInt();
//
//        if(a>b)
//            System.out.println(a);
//        else
//            System.out.println(b);

//        3. Scrieți o metoda care sa calculeze factorialul unui numar n citit de la tastatura.
//        int n = scanner.nextInt(), fact = 1;
//        for(int i = 2; i <= n; i++){
//            fact = fact * i;
//        }
//
//        System.out.println(fact);

//        4. Fiind dat un numar n, scrieti o metoda care insumeaza toti multiplii de 3 si 5 pana la n (inclusiv)

//        int n = scanner.nextInt(), sum = 0;
//        for(int i = 0; i <= n; i++){
//            if(i % 3 == 0 || i % 5 == 0){
//                sum += i;
//            }
//        }
//        System.out.println(sum);

//        5. Cititi de la tastatura n numere. Elementele citite vor fi organizate in doi vectori diferiti, in functie de paritate (de ex: elementele pare in vectorul x, iar cele impare in vectorul y).

//        int n = scanner.nextInt(), x, pp = 0, pi = 0;
//        int v_p[] = new int[n];
//        int v_i[] = new int [n];
//        for(int i = 0; i < n; i++){
//            x = scanner.nextInt();
//            if(x%2==0)
//                v_p[pp++] = x;
//            else
//                v_i[pi++] = x;
//        }
//
//        for(int i = 0; i < pp; i++){
//            System.out.print(v_p[i] + " ");
//        }
//        System.out.println();
//        for(int i = 0; i < pi; i++){
//            System.out.print(v_i[i] + " ");
//        }

//        6.Cititi de la tastatura n note, numere intregi, intr-un vector. Cand cititi valoarea -1 de la tastatura, citirea notelor se opreste si programul afiseaza media acestora

//        int n = scanner.nextInt(), sum = 0;
//        int [] note = new int[n];
//        for(int i = 0; i < n; i++){
//            int x = scanner.nextInt();
//            if(x != -1){
//                note[i] = x;
//                sum += x;
//            }
//            else {
//                if(i == 0){
//                    System.out.printf("Nu au fost introduse note");
//                }
//                else{
//                    System.out.println(sum/i);
//                }
//            }
//        }
//        7. Sa se afiseze al n-lea termen din seria Fibonacci, unde n este citit de la tastatura.

//        int n = scanner.nextInt(), f1 = 0, f2 = 1;
//
//        if( n == f1 || n == f2){
//            System.out.println(n);
//        }
//        else{
//            for(int i = 3; i <= n; i++){
//                int t = f2;
//                f2 = f1 + f2;
//                f1 = t;
//            }
//            System.out.println(f2);
//        }


    }
}
