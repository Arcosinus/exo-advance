package com.company;

import java.util.*;

public class caisse {
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
    public static void billetverif(double prix, int nbbillet){
        double totalbillet = nbbillet*20;
        if (totalbillet >= prix){
            System.out.println("Vous avez donnez assez de billet.");
            double arendre = (double)Math.round((totalbillet-prix)*100)/100;
            double totalarendre = arendre;
            System.out.println("Je vous rend " + arendre + "€.");
            int[] rendre = new int[11];
            while((double)Math.round((totalarendre)*100)/100 != 0.00){
                if (totalarendre >= 20){
                    totalarendre -= 20;
                    rendre[0] += 1;
                }else if (totalarendre >= 10){
                    totalarendre -= 10;
                    rendre[1] += 1;
                }else if (totalarendre >= 5){
                    totalarendre -= 5;
                    rendre[2] += 1;
                }else if (totalarendre >= 2){
                    totalarendre -= 2;
                    rendre[3] += 1;
                }else if (totalarendre >= 1){
                    totalarendre -= 1;
                    rendre[4] += 1;
                }else if (totalarendre >= 0.5){
                    totalarendre -= 0.5;
                    rendre[5] += 1;
                }else if (totalarendre >= 0.2){
                    totalarendre -= 0.2;
                    rendre[6] += 1;
                }else if (totalarendre >= 0.1){
                    totalarendre -= 0.1;
                    rendre[7] += 1;
                }else if (totalarendre >= 0.05){
                    totalarendre -= 0.05;
                    rendre[8] += 1;
                }else if (totalarendre >= 0.02){
                    totalarendre -= 0.02;
                    rendre[9] += 1;
                }else if (totalarendre >= 0.01){
                    totalarendre -= 0.01;
                    rendre[10] += 1;
                }
            }
            for (int i = 0; i < rendre.length; i++) {
                if (rendre[i] != 0){
                    if (i == 0){
                        System.out.println("En " + rendre[i] + " billet de 20€.");
                    }else if (i == 1){
                        System.out.println("En " + rendre[i] + " billet de 10€.");
                    }else if (i == 2){
                        System.out.println("En " + rendre[i] + " billet de 5€.");
                    }else if (i == 3){
                        System.out.println("En " + rendre[i] + " pièce de 2€.");
                    }else if (i == 4){
                        System.out.println("En " + rendre[i] + " pièce de 1€.");
                    }else if (i == 5){
                        System.out.println("En " + rendre[i] + " pièce de 0.5€.");
                    }else if (i == 6){
                        System.out.println("En " + rendre[i] + " pièce de 0.2€.");
                    }else if (i == 7){
                        System.out.println("En " + rendre[i] + " pièce de 0.1€.");
                    }else if (i == 8){
                        System.out.println("En " + rendre[i] + " pièce de 0.05€.");
                    }else if (i == 9){
                        System.out.println("En " + rendre[i] + " pièce de 0.02€.");
                    }else{
                        System.out.println("En " + rendre[i] + " pièce de 0.01€.");
                    }
                }
            }
        }
    }
}
