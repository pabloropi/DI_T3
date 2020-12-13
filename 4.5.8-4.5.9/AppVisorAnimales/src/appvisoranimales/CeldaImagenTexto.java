/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvisoranimales;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Pablo Rodriguez Pino 2ºDAM
 */
public class CeldaImagenTexto extends ListCell<Animal>{
    
    private VBox vbox = new VBox();
    private ImageView imagen = new ImageView();
    private Label label = new Label();
    
    public CeldaImagenTexto(){
        
        imagen.setFitHeight(100);
        imagen.setFitWidth(100);
        
        vbox.getChildren().addAll(imagen,label);
        vbox.setAlignment(Pos.CENTER);
        
        
    }
    
    @Override
    protected void updateItem(Animal animal, boolean vacia) {
        super.updateItem(animal, vacia);
        if(animal!=null){
            label.setText(animal.getNombre());
            imagen.setImage(new Image(animal.getImagenMiniatura()));
            setGraphic(vbox);
        }
    }
    
    
}
