/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusotextoboton;

import componentes_rodriguezpablo.CampoTextoBoton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Pablo Rodriguez Pino 2ºDAM
 */
public class AppusotextobotonController implements Initializable {

    @FXML
    private CampoTextoBoton textoBoton1;
    @FXML
    private CampoTextoBoton textoBoton2;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        textoBoton1.setOnAction((ActionEvent event) -> {
            label.setText("Se ha grabado " + textoBoton1.getText());
        });
        
        textoBoton2.setOnAction((ActionEvent event) -> {
            label.setText("Se ha grabado " + textoBoton2.getText());
        });

    }    
    
}
