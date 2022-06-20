package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import outils.LectureEcriture;
import outils.MembresApli;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarteMembrePane extends GridPane {
    private MembresApli membresApli;
    private Label ville;
    private List<String> listVille;
    private Label num;
    private ComboBox membreSelection = new ComboBox<String>();

    public CarteMembrePane() throws IOException {

        File filefeu = new File("C:/SAE_algo/badge_feu.png"); // Fichier contenant le grade du membre de l'APLI
        File fileau = new File("C:/SAE_algo/badge_eau.png");
        File filemetal = new File("C:/SAE_algo/badge_metal.png");

        String localUrl = filefeu.toURI().toURL().toString(); // URl de l'image contenant le grade du membre de l'APLI
        String localUrl2 = fileau.toURI().toURL().toString();
        String localUrl3 = filemetal.toURI().toURL().toString();

        Image badgefeu = new Image(localUrl); // Image contenant le grade du membre de l'APLI
        Image badgeeau = new Image(localUrl2);
        Image badgemetal = new Image(localUrl3);

        MembresApli membresApli = LectureEcriture.lectureVille(new File("membres" + File.separator + "membres_APLI.txt"));
        // Création d'un objet MembresApli contenant une liste de membres et une liste de Ville
        listVille = MembresApli.getListVilles();

        for (String member : MembresApli.getListMembres()){ // Création de la liste déroulante contenant le nom des membres
            membreSelection.getItems().add(member);
        }

        membreSelection.getSelectionModel().select(0); // Mets par défaut la valeur de la liste déroulante au premier membre de lAPLI
        ville = new Label("Ville du membre : "+listVille.get(0)); // Mets par défaut la ville du premier membre de l'APLI
        num = new Label("numéro de membre : "+(membreSelection.getSelectionModel().getSelectedIndex()+1)); // Mets par défaut le numéro de membre à 1
        ImageView imageView = new ImageView(badgeeau); // Mets par défaut le badge du membre à eau

        this.add(membreSelection,0,0,4,1); // ajout de la liste déroulante à l'interface grahique ( a carteMembrePane)
        this.add(ville,0,1,4,1);
        this.add(num,0,2,4,1);
        this.add(imageView,0,3,1,1);

        membreSelection.setOnAction(new EventHandler<ActionEvent>() { /** Modification du Prénom, du numéro de membre et du badge
            // en fonction du Membre selectionné **/
            @Override
            public void handle(ActionEvent actionEvent) {
                ville.setText("Ville du membre : "+listVille.get(membreSelection.getSelectionModel().getSelectedIndex()));
                num.setText("numéro de membre : "+(membreSelection.getSelectionModel().getSelectedIndex()+1));

                if (membreSelection.getSelectionModel().getSelectedIndex()%3==0){
                    imageView.setImage(badgeeau);
                }
                if (membreSelection.getSelectionModel().getSelectedIndex()%3==1){
                    imageView.setImage(badgefeu);
                }
                if (membreSelection.getSelectionModel().getSelectedIndex()%3==2){
                    imageView.setImage(badgemetal);
                }
            }
        });
    }

}
