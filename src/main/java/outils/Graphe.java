/**
package outils;

import java.util.*;

public class Graphe {
    private List<List<String>> chListAdj;

    public Graphe(){
        chListAdj = new ArrayList<List<String>>();
    }

    public Object[] parcoursEnLargeur(List<List<Integer>> parListAdj, int parSomDep){
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
    }
}
 **/
