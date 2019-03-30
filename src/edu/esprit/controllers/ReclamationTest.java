package edu.esprit.controllers;

import edu.esprit.entities.Reclamation;
import edu.esprit.iservices.IReclamationService;
import edu.esprit.services.ReclamationService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;


public class ReclamationTest extends Application {


    @Override
    public void start(final Stage primaryStage) {
        try {
            // Localisation du fichier FXML.
            final URL url = getClass().getResource("/edu/esprit/gui/reclamation.fxml");
            // Création du loader.
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            // Chargement du FXML.
            final AnchorPane root = (AnchorPane) fxmlLoader.load();
            // Création de la scène.
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
        primaryStage.setTitle("Test FXML");
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);

        System.out.println("***************");

    }


}
