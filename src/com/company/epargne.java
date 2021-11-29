package com.company;

public class epargne {
    public void placement(int somme,float interet,int année){
        float sommef = somme * (1+interet*année);
        System.out.println("Vous aurez " + sommef + "€.");
    }
}
