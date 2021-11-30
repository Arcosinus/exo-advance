package com.company;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        pari quinteplus = new pari();
        System.out.println("Combien de chevaux cours ?");
        int partant = scan.nextInt();
        System.out.println("Combien en as-tu joué ?");
        int joue = scan.nextInt();
        quinteplus.chance(partant,joue);
    }
}
