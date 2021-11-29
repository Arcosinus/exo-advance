package com.company;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void prix5030(double prix){
        System.out.println(prix+"€");
        prix *= 0.5;
        System.out.println(prix+"€");
        prix *= 0.7;
        System.out.println(prix+"€");
    }
    public static double remisevar(double prix, List<Integer> listeremise){
        boolean noerror = true;
        for (int i = 0; i < listeremise.size()-1; i++) {
            if (listeremise.get(i) < listeremise.get(i+1)){
                System.out.println("Les remises ne sont pas mise en ordre décroissant.");
                noerror = false;
                break;
            }
        }
        if (noerror) {
            for (int i = 0; i < listeremise.size(); i++) {
                prix *= (double) (100 - listeremise.get(i)) / 100;
            }
            prix = (double)Math.round(prix*100)/100;
            return prix;
        }
        return 0;
    }
    public static void main(String[] args) {
	    prix5030(10.00);
        Scanner remisescan = new Scanner(System.in);
        List<Integer> remise = new ArrayList();
        System.out.println("Quel est le prix de votre produit ?");
        double prix = remisescan.nextDouble();
        System.out.println("Combien de remise voulez vous appliquez ?");
        int nbremise = remisescan.nextInt();
        for (int i = 1; i <= nbremise ; i++) {
            System.out.println("A combien s'élève la remise " + i + " ?");
            remise.add(remisescan.nextInt());
        }
        if (remisevar(prix,remise) != 0){
            System.out.println("Votre produit vaudra " + remisevar(prix,remise) + "€.");
        }
    }
}
