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
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import static outils.LectureEcriture.lectureVille;

public class CarteMembrePane extends GridPane {

    private ComboBox membreSelection = new ComboBox<String>();
    //private Image badgeFeu = new Image("badge_feu.png");
    //private Image badgeEau = new Image("badge_eau.png");
    //private Image badgeMetal = new Image("badge_metal.png");
    private MembresApli membresApli = new MembresApli();
    private TreeMap<String,String> mapMemVil = new TreeMap<>();
    private Label ville = new Label();

    public CarteMembrePane() throws IOException {
        File membreAp= new File("scenarios" + File.separator + "membres_APLI.txt");
        MembresApli membresApli = LectureEcriture.lectureVille(membreAp);

        for (String member : LectureEcriture.lectureVille(membreAp).getListMembres()){
            membreSelection.getItems().add(member);
        }

        //Image badge = badgeFeu;
        //if (compt%3==1){
        //    badge = badgeEau;
        //}
        //if (compt%3==2){
        //    badge = badgeMetal;
        //}

        membreSelection.getSelectionModel().select(0);
        this.add(membreSelection,0,0,4,1);
        mapMemVil = membresApli.getMapMembresVilles();
        ville = new Label(mapMemVil.get(membreSelection.getSelectionModel().getSelectedItem()));
        this.add(ville,0,1,4,1);

        HBox vboxTemps = new HBox();
        //vboxTemps.getChildren(badgeFeu);
        this.add(vboxTemps,2,2,3,3);
    }

}
