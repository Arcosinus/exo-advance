package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        caisse Lidl = new caisse();
	    Lidl.prix5030(10.00);
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
        double prixfinal = Lidl.remisevar(prix,remise);
        if (prixfinal != 0){
            System.out.println("Votre produit vaudra " + prixfinal + "€.");
            System.out.println("Combien de billet de 20€ donnez vous ?");
            int nbbillet = remisescan.nextInt();
            Lidl.billetverif(prixfinal,nbbillet);
        }

    }
}
