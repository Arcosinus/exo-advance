package com.company;

public class emprunt {
    public static void calculcout(double a, int C, int n, float t){
        double m;
        double tm = 0;
        for (int i = 0; i < n; i++) {
            m = Math.round((C*(t/1200))/(1-Math.pow((1+(t/1200)),-12*n)));
            System.out.println(m);
            tm += m;
        }
        double cost = (12*tm)-C;
        System.out.println(cost);
    }
}
