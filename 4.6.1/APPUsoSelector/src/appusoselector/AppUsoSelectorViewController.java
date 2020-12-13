/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusoselector;

import componentes_rodriguezpablo.SelectorDeslizamiento;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Pablo Rodriguez Pino 2ºDAM
 */
public class AppUsoSelectorViewController implements Initializable {

    @FXML
    private SelectorDeslizamiento selector1;
    @FXML
    private Label labelAbajo;
    @FXML
    private SelectorDeslizamiento selector2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        selector1.setOnAction((ActionEvent event) -> {
            labelAbajo.setText("Pulsado el selector de arriba");
        });
        
        selector2.setOnAction((ActionEvent event) -> {
            labelAbajo.setText("Pulsado el selector de abajo");
        });

    }    
    
}
