module com.example.sae_algo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.sae_algo to javafx.fxml;
    exports controleur;
    exports modele;
    exports vue;
    exports outils;
}