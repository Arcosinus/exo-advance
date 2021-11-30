package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class Main5 {
    public static void main(String[] args) {
        int nbuser = 0;
        int activeuser;
        boolean wantplay = true;
        List<String> user = new ArrayList<String>();
        List<Game> ActualScore = new ArrayList<Game>();
        List<List<Game>> Scoreuser = new ArrayList<>();
        System.out.println("Chargement en cours ...");
        try (FileReader reader = new FileReader("/Users/arxcoz/Downloads/Gladiator/exo-advance/score.txt")) {
            Properties properties = new Properties();
            properties.load(reader);
            int getnbperso = Integer.parseInt(properties.getProperty("Nombreutilisateur"));
            for (int i = 0; i < getnbperso; i++) {
                boolean inJ = true;
                int j = 0;
                List<Game> Score = new ArrayList<Game>();
                while (inJ){
                    String getnameChar = properties.getProperty("" + j + i + "Utilisateur");
                    if (getnameChar == null){
                        j = 0;
                        inJ = false;
                        break;
                    }
                    if (j==0) {
                        user.add(getnameChar);
                        nbuser++;
                    }
                    int good = Integer.parseInt(properties.getProperty("Good_"+ j +getnameChar));
                    int bad = Integer.parseInt(properties.getProperty("Bad_"+ j + getnameChar));
                    int dif = Integer.parseInt(properties.getProperty("Difficulty_"+ j + getnameChar));
                    Game save = new Game(getnameChar,i,j);
                    save.Score(good,bad,dif);
                    Score.add(save);
                    j++;
                    System.out.println("Fichier de " + getnameChar + " chargé.");
                }
                Scoreuser.add(Score);
            }
            System.out.println("Fichier de sauvegarde chargé.");
        } catch (Exception e) {
            System.out.println("Le fichier de sauvegarde est vide.");
            System.out.println("----------");
        }
        Scanner scan = new Scanner(System.in);
        if (nbuser==0) {
            System.out.println("Entrez votre nom :");
            user.add(scan.next());
            activeuser = 0;
            nbuser++;
            List<Game> Score = new ArrayList<Game>();
            Scoreuser.add(Score);
            ActualScore = Score;
        } else {
            System.out.println(user);
            System.out.println("Entrez l'index de votre nom:");
            activeuser = scan.nextInt()-1;
            ActualScore = Scoreuser.get(activeuser);
        }
        while(wantplay){
            if (nbuser==0) {
                System.out.println("Entrez votre nom :");
                user.add(scan.next());
                activeuser = 0;
                nbuser++;
                List<Game> Score = new ArrayList<Game>();
                Scoreuser.add(Score);
                ActualScore = Score;
            }
            int choose = 0;
            while (choose != 1 && choose != 2 && choose != 3 && choose != 4){
                System.out.println("----------\nBienvenue " + user.get(activeuser) + " dans Calculatron" + "\nJouez-1\nScore-2\nUtilisateur-3\nQuitter-4");
                choose = scan.nextInt();
            }
            if (choose==3){
                System.out.println(user);
                System.out.println("----------\nEntrez l'index de votre nom, entrez 0 pour créer un profil ou -1 pour en supprimer un.");
                int choose2 = scan.nextInt();
                if (choose2 == 0){
                    System.out.println("----------\nEntrez votre nom :");
                    user.add(scan.next());
                    nbuser++;
                    activeuser = nbuser-1;
                    List<Game> Score = new ArrayList<Game>();
                    Scoreuser.add(Score);
                    ActualScore = Score;
                } else if (choose2 == -1) {
                    System.out.println("----------\nQuel profil souhaitez vous supprimez ?");
                    int suppresion = scan.nextInt();
                    user.remove(suppresion-1);
                    Scoreuser.remove(suppresion-1);
                    /*for (int i = 0; i < nbuser-suppresion; i++) {

                    }*/
                    nbuser--;
                } else {
                    activeuser = choose2-1;
                    ActualScore=Scoreuser.get(activeuser);
                }
            }
            if (choose==2){
                System.out.println(Scoreuser);
            }
            if (choose==4){
                wantplay = false;
                break;
            }
            if (choose==1) {
                int choosedif = 0;
                while (choosedif < 1 || choosedif > 3) {
                    System.out.println("----------\nQuels difficultés choississez vous ? 1-addition facile 2-soustraction moyenne 3-multiplication difficile");
                    choosedif = scan.nextInt();
                }
                Game play = new Game(user.get(activeuser),activeuser,ActualScore.size());
                play.play(choosedif);
                ActualScore.add(play);
            }
            Path chemin = Paths.get("/Users/arxcoz/Downloads/Gladiator/exo-advance/score.txt");
            String save = "Nombreutilisateur=" + nbuser + "\n";
            for (int i = 0; i < user.size(); i++) {
                List<Game> Listsave = Scoreuser.get(i);
                for (int j = 0; j < Listsave.size(); j++) {
                    save += j + "" +Listsave.get(j);
                }
            }

            byte[] data = save.getBytes();

            OutputStream output = null;
            try {
                output = new BufferedOutputStream(Files.newOutputStream(chemin, CREATE, TRUNCATE_EXISTING));
                output.write(data);
                output.flush();
                output.close();
                System.out.println("Sauvegarde de la partie effectué.");
            } catch (Exception e) {
                System.out.println("Message " + e);
            }
        }
    }
}
