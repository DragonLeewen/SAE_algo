package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.ConstantesMenu;


public class VMainBox extends VBox implements ConstantesMenu {
    private static ScenarioPane scenarioPane;
    private static CreationPane creationPane;
    private static Controleur controleur;
    private static CarteMembrePane carteMembrePane;

    public VMainBox(){
        controleur = new Controleur();
        scenarioPane = new ScenarioPane();
        scenarioPane.setId("scenario");
        carteMembrePane = new CarteMembrePane();
        carteMembrePane.setId("carte");
        creationPane = new CreationPane();
        creationPane.setId("creation");

        Node[] composants = new Node [3];
        composants [0] = scenarioPane;
        composants [1] = carteMembrePane;
        composants [2] = creationPane;

        StackPane stackPane = new StackPane(composants);
        stackPane.getChildren().get(0).toFront();

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu(INTITULE_MENU_SELECTION);
        menuBar.getMenus().add(menu);

        for(int i = 0; i< ITEMS_MENU_SELECTION.length; i++){
            MenuItem menuItem = new MenuItem(ITEMS_MENU_SELECTION[i]);
            menuItem.setUserData(i);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent evt) {
                    int data =(int)((MenuItem)evt.getSource()).getUserData();
                    System.out.println(data);
                    int last = stackPane.getChildren().size()-1;
                    while (stackPane.getChildren().get(last) != composants[data]){
                        stackPane.getChildren().get(0).toFront();

                    }

                }
            });
            menu.getItems().add(menuItem);
        }
        this.getChildren().addAll(menuBar,stackPane);
    }
}
