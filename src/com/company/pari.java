package com.company;

public class pari {
    public int factorielle(int n){
        int factor = 1;
        for (int i = 1; i <= n; i++) {
            factor *= i;
        }
        return factor;
    }
    public void chance(int n, int p){
        int un = factorielle(n);
        int deux = factorielle(n-p);
        int trois = factorielle(p);
        int X = un / deux;
        int Y = un/ (trois * deux);
        System.out.println("Une chance sur " + X);
        System.out.println("Une chance sur " + Y);
    }
}
