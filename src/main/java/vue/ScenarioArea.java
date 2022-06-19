package vue;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ScenarioArea extends VBox
{
    private static TextArea areaScenario;

    public ScenarioArea()
    {

        areaScenario = new TextArea();
        areaScenario.setMaxSize(300, 300);
        areaScenario.setEditable(false);
        areaScenario.setWrapText(true);
        getChildren().add(areaScenario);
    }

    public static TextArea getAreaScenario()
    {
        return areaScenario;
    }
}
