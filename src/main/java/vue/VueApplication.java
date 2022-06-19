package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class VueApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File css = new File("css" + File.separator + "style.css");
        
        VMainBox root = new VMainBox();

        Scene scene = new Scene(root, 320, 400);
        scene.getStylesheets().add(css.toURI().toString());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        stage.setTitle("Menu Complet");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}