package outils;

import java.util.*;

public class Graphe {
    private ArrayList<String> chLchemin;
    private  ArrayList<ArrayList<Integer>> chladj;

    public static ArrayList<String> unChemin(Scenario parscenario){

        ArrayList<String> listVendeur = (ArrayList<String>) parscenario.getListVendeurs();
        ArrayList<String> listAcheteur = (ArrayList<String>) parscenario.getListAcheteurs();
        ArrayList<String> listChemin = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listAdj = new ArrayList<>();

        for (int i = 0; i < listAcheteur.size(); i++){

            if(!listChemin.contains(listVendeur.get(i))){
                listChemin.add(listVendeur.get(i));
            }
            if (!listChemin.contains(listAcheteur.get(i))) {
                listChemin.add(listAcheteur.get(i));
            }
        }
        for (int i = 0; i < listChemin.size(); i++) {
            listAdj.add(new ArrayList<>());

        }

        //Donne les voisins sortant
        for (int i = 0; i < listVendeur.size(); i++) {
            listAdj.get(listChemin.indexOf(listVendeur.get(i))).add(listChemin.indexOf(listAcheteur.get(i)));
        }

        return listChemin;
    }

    public ArrayList<String> getNodes(){

        return chLchemin;

    }
    public  ArrayList<ArrayList<Integer>> getlistAdj(){

        return chladj;
    }


}



    /**public Object[] parcoursEnLargeur(List<List<Integer>> parListAdj, int parSomDep){
        Object [] precedence = new Object[parListAdj.size()];
        Arrays.fill(precedence,"None");
        precedence[parSomDep] = -1;
        Deque attente = new ArrayDeque();
        attente.add(parSomDep);

        while (!attente.isEmpty()){
            Object courant = attente.removeFirst();
            for(Integer voisin : parListAdj.get((Integer) courant) ){
                if (precedence[voisin]){
                    precedence[voisin] = courant;
                    attente.add(voisin);
                }
            }
            return precedence;
        }



        return null;
    }**/

