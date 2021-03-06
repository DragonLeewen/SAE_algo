package outils;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
//Défini un Scenario sous forme de deux listes Vendeur, Acheteur

    List<String> listVendeurs;
    List<String> listAcheteurs;

    public Scenario(){
        listVendeurs = new ArrayList<>();
        listAcheteurs = new ArrayList<>();
    }

    public void ajoutVendeurAcheteur(String vendeur, String acheteur){
        listVendeurs.add(vendeur);
        listAcheteurs.add(acheteur);
    }

    public List<String> getListAcheteurs() {
        return listAcheteurs;
    }

    public List<String> getListVendeurs() {
        return listVendeurs;
    }

    @Override
    public String toString() {
        return "Scenario" + "\n"+
                "La liste des Vendeurs =" + listVendeurs + "\n" +"\n"
                + "La liste des Acheteurs =" + listAcheteurs;
    }
}
