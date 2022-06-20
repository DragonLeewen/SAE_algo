package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import outils.Graphe;
import outils.LectureEcriture;

import java.io.File;
import java.io.IOException;


public class ScenarioPane extends GridPane {

    public ScenarioPane() throws IOException {
        ScenarioArea vue = new ScenarioArea();
        add(vue,0,4,4,4);
        File scenar = new File("scenarios" + File.separator + "scenario_0.txt");
        System.out.println(Graphe.unChemin(LectureEcriture.lectureScenario(scenar)));
    }

}
