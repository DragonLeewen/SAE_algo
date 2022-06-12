package outils;

import java.io.*;
import java.util.StringTokenizer;

public class LectureEcriture {

    public static Scenario lectureScenario (File fichier) throws IOException{
        Scenario scenario = new Scenario();

        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne;

        StringTokenizer tokenizer;
        do {
            ligne = bufferEntree.readLine();
            if (ligne != null) {
                tokenizer = new StringTokenizer(ligne, " ->");
                scenario.ajoutVendeurAcheteur(tokenizer.nextToken(), tokenizer.nextToken());
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return scenario;
    }
    public static Scenario lectureVille (File fichier) throws IOException{
        Scenario scenario = new Scenario();

        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne;

        StringTokenizer tokenizer;
        do {
            ligne = bufferEntree.readLine();
            if (ligne != null) {
                tokenizer = new StringTokenizer(ligne, " ");
                scenario.ajoutVendeurAcheteur(tokenizer.nextToken(), tokenizer.nextToken());
            }
        }
        while (ligne != null);
        bufferEntree.close();
        return scenario;
    }

    public static void ecritureScenario (String nomFichier, Scenario scenario) throws IOException{

        PrintWriter sortie = new PrintWriter(new BufferedWriter((new FileWriter(nomFichier))));
        int i = 0;
        for (String vendeur : scenario.getListVendeurs()) {
            sortie.println(vendeur + " ->" + scenario.getListAcheteurs().get(i));
        }
        sortie.close();
    }
}
