package vue;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import outils.LectureEcriture;
import outils.MembresApli;
import outils.Scenario;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

import static outils.LectureEcriture.lectureVille;

public class CarteMembrePane extends GridPane {

    private ComboBox membreSelection = new ComboBox<String>();
    private TreeMap<String,Label> membresRole = new TreeMap<>();
    private Label role = new Label();
    private TreeMap<String,Label> membresNum = new TreeMap<>();
    private Label num = new Label();
    private Image badgeFeu = new Image("badge_feu.png");
    private Image badgeEau = new Image("badge_eau.png");
    private Image badgeMetal = new Image("badge_metal.png");
    private MembresApli membresApli = new MembresApli();
    private TreeMap<String,Label> membresVille = new TreeMap<>();
    private Label ville = new Label();
    private Integer compt = 0;

    public CarteMembrePane(){
        File membreAp= new File("scenarios" + File.separator + "membres_APLI.txt");
        MembresApli membresApli = LectureEcriture.lectureVille(membreAp);
        for (String acheteur : Scenario.getListAcheteurs()){
            membreSelection.getItems().add(acheteur);
            Label tempLabelAch = new Label("acheteur");
            membresRole.put(acheteur,tempLabelAch);
            compt += 1;
            Image badge = badgeFeu;
            if (compt%3==1){
                badge = badgeEau;
            }
            if (compt%3==2){
                badge = badgeMetal;
            }
            Label tempComptAch = new Label(compt+"");
            membresNum.put(acheteur,tempComptAch);
            Label tempVillAch = new Label(membresApli.getListVilles()+"");
        }
        for(String vendeur : Scenario.getListVendeurs()){
            membreSelection.getItems().add(vendeur);
            Label tempLabelVen = new Label("vendeur");
            membresRole.put(vendeur,tempLabelVen);
            compt+=1;
            Image badge = badgeFeu;
            if (compt%3==1){
                badge = badgeEau;
            }
            if (compt%3==2){
                badge = badgeMetal;
            }
            Label tempComptVen = new Label(compt+"");
            membresNum.put(vendeur,tempComptVen);
        }
        this.add(membreSelection,0,0,4,1);

        if(membreSelection.getValue()==membresRole.get(membreSelection.getValue())){
            role = membresRole.get(membreSelection.getValue());
            this.add(role,0,1,4,1);
        }

        if(membreSelection.getValue()==membresNum.get(membreSelection.getValue())){
            num = membresNum.get(membreSelection.getValue());
            this.add(num,1,1,2,1);
        }
        HBox vboxTemps = new HBox();
        vboxTemps.getChildren(badgeFeu);
        this.add(vboxTemps,2,2,3,3);

        if(membreSelection.getValue()==membresVille.get(membreSelection.getValue())){
            this.add(ville,0,2,4,1);
        }
    }

}
