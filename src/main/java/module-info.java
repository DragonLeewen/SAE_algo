module com.example.sae_algo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.sae_algo to javafx.fxml;
    exports modele;
    exports vue;
    exports controleur;
    opens vue to javafx.fxml;
    opens controleur to javafx.fxml;
}