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

    private ComboBox membreSelection = new ComboBox<String>();
    File filefeu = new File("C:/SAE_algo/badge_feu.png");
    File fileau = new File("C:/SAE_algo/badge_eau.png");
    File filemetal = new File("C:/SAE_algo/badge_metal.png");

    String localUrl = filefeu.toURI().toURL().toString();
    String localUrl2 = fileau.toURI().toURL().toString();
    String localUrl3 = filemetal.toURI().toURL().toString();

    Image badgefeu = new Image(localUrl);
    Image badgeeau = new Image(localUrl2);
    Image badgemetal = new Image(localUrl3);
    private MembresApli membresApli;
    private Label ville;
    private List<String> listVille;
    private Label num;

    public CarteMembrePane() throws IOException {
        File membreAp= new File("scenarios" + File.separator + "membres_APLI.txt");
        MembresApli membresApli = LectureEcriture.lectureVille(membreAp);
        listVille = MembresApli.getListVilles();

        for (String member : MembresApli.getListMembres()){
            membreSelection.getItems().add(member);
        }

        membreSelection.getSelectionModel().select(0);
        this.add(membreSelection,0,0,4,1);
        ville = new Label("Ville du membre : "+listVille.get(0));
        this.add(ville,0,1,4,1);

        num = new Label("numéro de membre : "+(membreSelection.getSelectionModel().getSelectedIndex()+1));
        this.add(num,0,2,4,1);

        ImageView imageView = new ImageView(badgeeau);
        this.add(imageView,0,3,1,1);

        membreSelection.setOnAction(new EventHandler<ActionEvent>() {
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
