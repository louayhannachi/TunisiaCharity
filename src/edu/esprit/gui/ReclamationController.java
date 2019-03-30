package edu.esprit.gui;

import edu.esprit.entities.Reclamation;
import edu.esprit.entities.TypeReclamation;
import edu.esprit.services.ReclamationService;
import edu.esprit.services.TypeReclamationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class ReclamationController implements Initializable {
    @FXML
    private Button ferBtn;
    @FXML
    private Button envBtn;


    @FXML
    private VBox vBox;
    ToggleGroup radioGroup = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TypeReclamationService ps = new TypeReclamationService();
        ArrayList<TypeReclamation> arrayList = ps.getTypeReclmationList();
        for (TypeReclamation tr: arrayList) {
            System.out.println(tr.getDescription());
            RadioButton radioButton = new RadioButton(tr.getDescription());
            radioButton.setToggleGroup(radioGroup);
            radioButton.setUserData(tr.getId());
            vBox.getChildren().add(radioButton);
        }


      ferBtn.setOnAction(e -> {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
      });

        envBtn.setOnAction(event -> {
            String value="";
            if (radioGroup.getSelectedToggle()!=null){
                value= radioGroup.getSelectedToggle().getUserData().toString();
                System.out.println(value);
            }
            else
                System.out.println("select");

            Reclamation reclamation = new Reclamation();
            reclamation.setDate(new Date());
            reclamation.setId(15);
            reclamation.setIduser(1);
            reclamation.setIdobjet(15);

            reclamation.setIdtr(Integer.parseInt(value));
            System.out.println(reclamation);
            ReclamationService rs = new ReclamationService();
            rs.addReclamation(reclamation);


        });

        radioGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (radioGroup.getSelectedToggle()!=null){
                System.out.println(radioGroup.getSelectedToggle().getUserData().toString());
            }
        });

    }
}
