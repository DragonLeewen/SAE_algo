package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.ConstantesMenu;
import outils.Graphe;
import outils.LectureEcriture;
import outils.Scenario;

import java.io.File;
import java.io.IOException;


public class VMainBox extends VBox implements ConstantesMenu {
    private static ScenarioPane scenarioPane;
    private static CreationPane creationPane;
    private static Controleur controleur;
    private static CarteMembrePane carteMembrePane;

    public VMainBox() throws IOException {
        /** Conteneur Principale contenant la barre de menu avec les items Scenario,
        Membres,Création ainsi que les conteneurs ScénarioPane,CarteMembrePane et CreationPane **/

        controleur = new Controleur();
        scenarioPane = new ScenarioPane();
        scenarioPane.setId("scenario"); // Association scenarioPane à un id pour le CSS
        carteMembrePane = new CarteMembrePane();
        carteMembrePane.setId("carte");
        creationPane = new CreationPane();
        creationPane.setId("creation");

        Node[] composants = new Node [3]; // Création d'un tableau contenant tous les conteneurs
        composants [0] = scenarioPane;
        composants [1] = carteMembrePane;
        composants [2] = creationPane;

        StackPane stackPane = new StackPane(composants); // Création de la pile des conteneurs
        stackPane.getChildren().get(0).toFront(); // Définie le conteneur par défaut ici la scenarioPane

        MenuBar menuBar = new MenuBar(); // Création d'une barre de menu
        Menu menu = new Menu(INTITULE_MENU_SELECTION); // Création d'un menu avec pour choix : Scenario, Membre et Création
        menuBar.getMenus().add(menu); // Ajout du menu à la barre de menu

        for(int i = 0; i< ITEMS_MENU_SELECTION.length; i++){  // Corrélation entre tableau conteneur et liste item
            MenuItem menuItem = new MenuItem(ITEMS_MENU_SELECTION[i]);
            menuItem.setUserData(i);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent evt) { // Modifie le conteneur en fonction de l'item selectionné
                    int data =(int)((MenuItem)evt.getSource()).getUserData();
                    System.out.println(data);
                    int last = stackPane.getChildren().size()-1;
                    while (stackPane.getChildren().get(last) != composants[data]){
                        stackPane.getChildren().get(0).toFront();

                    }

                }
            });
            menu.getItems().add(menuItem); // Ajout de l'item au menu
        }
        Menu menuFile = new Menu(SCENARIOS); // Création Menu SCENARIO
        menuBar.getMenus().add(menuFile);
        ToggleGroup toggleGroup = new ToggleGroup(); // Bouton groupe permettant de voir quel item a été selectionné
        File [] fichiersScenario = new File("scenarios").listFiles();
        for(File file : fichiersScenario) { // Parcours des fichiers scénarios
            RadioMenuItem menuItem = new RadioMenuItem(file.getName());
            menuItem.setUserData(file);
            menuItem.setToggleGroup(toggleGroup);
            menuFile.getItems().add(menuItem); // Ajout de l'item au menu
            menuFile.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        VMainBox.getAffichageScenario().setText(LectureEcriture.lectureScenario((File) menuItem.getToggleGroup().getSelectedToggle().getUserData()).toString());
                        // Affichage du scénario en fonction de l'item selectionné
                        //VMainBox.getAffichageScenario().setText(Graphe.unChemin(LectureEcriture.lectureScenario((File) menuItem.getToggleGroup().getSelectedToggle().getUserData())).toString());
                    } catch (IOException e) { // Récupère l'erreur si le fichier est corrompue
                        e.printStackTrace();
                    }
                }
            });
        }

        this.getChildren().addAll(menuBar,stackPane); /** Ajout de la barre de menu et de la pile de conteneur
        à l'interface graphique (VMainBox) **/
    }
    public static TextArea getAffichageScenario() {

        return ScenarioArea.getAreaScenario();
    }
}
