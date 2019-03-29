package edu.esprit.gui;

import edu.esprit.entities.TypeReclamation;
import edu.esprit.services.TypeReclamationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ReclamationController implements Initializable {
    @FXML
    private Button ferBtn;
    @FXML
    private Button envBtn;


    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup radioGroup = new ToggleGroup();

        TypeReclamationService ps = new TypeReclamationService();
        ArrayList<TypeReclamation> arrayList = ps.getTypeReclmationList();
        for (TypeReclamation tr: arrayList) {
            System.out.println(tr.getDescription());
            RadioButton radioButton = new RadioButton(tr.getDescription());
            radioButton.setToggleGroup(radioGroup);
            vBox.getChildren().add(radioButton);
        }


    }
}
