package outils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

}
