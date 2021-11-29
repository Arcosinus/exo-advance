package com.company;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        epargne caisse = new epargne();
        Scanner scan = new Scanner(System.in);
        System.out.println("Combien placé vous ?");
        int s = scan.nextInt();
        System.out.println("Avec quel taux d'intéret ?");
        float i = scan.nextFloat();
        System.out.println("Pendant combien d'année ?");
        int a = scan.nextInt();
        caisse.placement(s,i,a);
    }
}
