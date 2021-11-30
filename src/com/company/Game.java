package com.company;
import java.util.*;

public class Game {
    String user;
    int indexuser;
    int nbgame;
    int good;
    int bad;
    int difficulty;
    public void Score(int goods, int bads, int dif){
        good = goods;
        bad = bads;
        difficulty = dif;
    }
    public Game(String utilisateur,int indexutilisateur, int numgame){
        user = utilisateur;
        indexuser = indexutilisateur;
        nbgame = numgame;
        good = 0;
        bad = 0;
    }
    public String toString() {
        return indexuser + "Utilisateur=" + user + "\nDifficulty_" + nbgame + user + "=" + difficulty + "\nGood_" + nbgame + user + "=" + good + "\nBad_" + nbgame + user + "=" + bad + "\n";
    }
    public void play(int dif){
        difficulty=dif;
        Scanner gamescan = new Scanner(System.in);
        if (dif==1){
            boolean wantplay1 = true;
            int min = 500;
            int max = 900;
            while (wantplay1) {
                int addun = (int) (Math.random()*(max-min)) + min;
                int adddeux = (int) (Math.random()*(max-min)) + min;
                int addtrois = (int) (Math.random()*(max-min)) + min;
                int addquatre = (int) (Math.random()*(max-min)) + min;
                System.out.println(addun + " + " + adddeux + " + " + addtrois + " + " + addquatre);
                int somme = addun + adddeux + addtrois + addquatre;
                int reponse = gamescan.nextInt();
                if (somme==reponse){
                    good+=1;
                    System.out.println("Bonne réponse ! Ton score est de " + good + "/" + bad + " Veut tu rejouer ? oui(1) non(2)");
                    int choose = gamescan.nextInt();
                    if (choose == 2){
                        wantplay1 = false;
                        break;
                    }
                }else{
                    bad+=1;
                    System.out.println("La réponse était " + somme + " Ton score est de " + good + "/" + bad + " Veut tu rejouer ? oui(1) non(2)");
                    int choose = gamescan.nextInt();
                    if (choose == 2){
                        wantplay1 = false;
                        break;
                    }
                }
            }
        } else if (dif==2){
            boolean wantplay1 = true;
            int min = -300;
            int max = 300;
            while (wantplay1) {
                int difun = (int) (Math.random()*(max-min)) + min;
                int difdeux = (int) (Math.random()*(max-min)) + min;
                int diftrois = (int) (Math.random()*(max-min)) + min;
                int difquatre = (int) (Math.random()*(max-min)) + min;
                System.out.println(difun + " - " + difdeux + " - " + diftrois + " - " + difquatre);
                int diff = difun - difdeux - diftrois - difquatre;
                int reponse = gamescan.nextInt();
                if (diff==reponse){
                    good+=1;
                    System.out.println("Bonne réponse ! Ton score est de " + good + "/" + bad + " Veut tu rejouer ? oui(1) non(2)");
                    int choose = gamescan.nextInt();
                    if (choose == 2){
                        wantplay1 = false;
                        break;
                    }
                }else{
                    bad+=1;
                    System.out.println("La réponse était " + diff + " Ton score est de " + good + "/" + bad + " Veut tu rejouer ? oui(1) non(2)");
                    int choose = gamescan.nextInt();
                    if (choose == 2){
                        wantplay1 = false;
                        break;
                    }
                }
            }
        } else {
            boolean wantplay1 = true;
            int min = -100;
            int max = 100;
            while (wantplay1) {
                int multun = (int) (Math.random()*(max-min)) + min;
                int multdeux = (int) (Math.random()*(max-min)) + min;
                int multtrois = (int) (Math.random()*(max-min)) + min;
                int multquatre = (int) (Math.random()*(max-min)) + min;
                System.out.println(multun + " X " + multdeux + " X " + multtrois + " X " + multquatre);
                int mult = multun * multdeux * multtrois * multquatre;
                int reponse = gamescan.nextInt();
                if (mult==reponse){
                    good+=1;
                    System.out.println("Bonne réponse ! Ton score est de " + good + "/" + bad + " Veut tu rejouer ? oui(1) non(2)");
                    int choose = gamescan.nextInt();
                    if (choose == 2){
                        wantplay1 = false;
                        break;
                    }
                }else{
                    bad+=1;
                    System.out.println("La réponse était " + mult + " Ton score est de " + good + "/" + bad + " Veut tu rejouer ? oui(1) non(2)");
                    int choose = gamescan.nextInt();
                    if (choose == 2){
                        wantplay1 = false;
                        break;
                    }
                }
            }
        }
    }
}
