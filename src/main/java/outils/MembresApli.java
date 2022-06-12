package outils;

import java.util.ArrayList;
import java.util.List;

public class MembresApli {
    List<String> listMembres;
    List<String> listVilles;

    public MembresApli(){
        listMembres = new ArrayList<>();
        listVilles = new ArrayList<>();
    }

    public void ajoutMembresVilles(String membre, String ville){
        listMembres.add(membre);
        listVilles.add(ville);
    }

    public List<String> getListVilles() {
        return listVilles;
    }

    public List<String> getListMembres() {
        return listMembres;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "La liste des Membres =" + listMembres + "\n"
                + "La liste des Villes =" + listVilles;
    }
}
