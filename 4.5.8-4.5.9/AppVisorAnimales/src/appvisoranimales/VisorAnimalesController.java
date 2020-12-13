/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvisoranimales;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Pablo Rodriguez Pino 2ºDAM
 */
public class VisorAnimalesController implements Initializable {

    
    
    private ObservableList<Animal> animales = FXCollections.observableArrayList();
            
    @FXML
    private ListView<Animal> list;
    
    @FXML
    private ImageView img;
      
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Animal gato = new Animal("Gato", "media/gatochico.jpg", "media/gato.jpg");
        Animal perro = new Animal("Perro", "media/perrochico.jpg", "media/perro.jpg");
        Animal pajaro = new Animal("Pajaro", "media/pajarochico.jpg", "media/pajaro.jpg");
        
        animales.addAll(gato,perro,pajaro);
        
        list.setItems(animales);
        
        list.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Animal> ov, Animal old_val, 
                Animal new_val) -> {
                    Image imagen = new Image(new_val.getImagenGrande());
                    img.setImage(imagen);             
        });
        
        list.setCellFactory(new Callback<ListView<Animal>, ListCell<Animal>>() {
            @Override
            public ListCell<Animal> call(ListView<Animal> param) {
                return new CeldaImagenTexto();
            }
        });
        
        
    }    
    
}
