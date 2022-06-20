package outils;
import java.io.*;
import java.util.StringTokenizer;


public class LectureEcriture {

    public static Scenario lectureScenario (File fichier) throws IOException{

        Scenario scenario = new Scenario(); // Déclaration et Instanciation d'un objet Scenario
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier)); // Création du tampon qui va lire le fichier

        String ligne;
        StringTokenizer tokenizer; // Déclaration du tokenizer qui est ici un groupe de lettre

        do { // Parcours d'une ligne du fichier
            ligne = bufferEntree.readLine();
            if (ligne != null) { // Vérifie si une ligne est vide
                tokenizer = new StringTokenizer(ligne, " ->"); /** Définie ce qu'est un tokenizer, ici un groupe de lettre séparé
                 par un espace une flèche **/
                scenario.ajoutVendeurAcheteur(tokenizer.nextToken(), tokenizer.nextToken()); /** Ajout des deux tokens Vendeurs et Acheteur
                 à l'objet de la classe Scenario **/
            }
        }

        while (ligne != null); // Parcours toutes les lignes du fichier
        bufferEntree.close();
        return scenario;
    }

    public static MembresApli lectureVille (File fichier) throws IOException{

        MembresApli membresApli = new MembresApli();
        BufferedReader bufferEntree = new BufferedReader(new FileReader(fichier));
        String ligne;
        StringTokenizer tokenizer;

        do {
            ligne = bufferEntree.readLine();
            if (ligne != null) {
                tokenizer = new StringTokenizer(ligne, " ");
                membresApli.ajoutMembresVilles(tokenizer.nextToken(), tokenizer.nextToken()); /** Ajout des deux tokens Membre et Ville
                 à l'objet de la classe MembreApli **/
            }
        }

        while (ligne != null);
        bufferEntree.close();
        return membresApli;
    }

    public static void ecritureScenario (String nomFichier, Scenario scenario) throws IOException{

        PrintWriter sortie = new PrintWriter(new BufferedWriter((new FileWriter(nomFichier)))); // Création de l'objet qui va permettre de modifier le fichier
        int i = 0;
        for (String vendeur : scenario.getListVendeurs()) { // Parcours la liste des vendeurs et ajoute l'acheteur correspondant
            sortie.println(vendeur + " ->" + scenario.getListAcheteurs().get(i));
        }

        sortie.close();
    }
}
