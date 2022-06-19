package outils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MembresApli {
    private static TreeMap<String,String> mapMembresVilles;
    static ArrayList<String> listMembre;
    static ArrayList<String> listVille;

    public MembresApli(){
        mapMembresVilles = new TreeMap<>();
        listMembre = new ArrayList<>();
        listVille =new ArrayList<>();
    }

    public void ajoutMembresVilles(String membre, String ville){
        listMembre.add(membre);
        listVille.add(ville);
    }

    public static TreeMap<String, String> getMapMembresVilles() {
        return mapMembresVilles;
    }

    public static List<String> getListVilles() {
        return listVille;
    }

    public static List<String> getListMembres() {
        return listMembre;
    }

    @Override
    public String toString() {
        return "Membres + Villes{" +
                "La liste des Membres =" + listMembre+ "\n"
                + "La liste des Villes =" + listVille;
    }
}
