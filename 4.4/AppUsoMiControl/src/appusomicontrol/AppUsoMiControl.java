/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusomicontrol;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import proyectomicontrol.MiControl;

/**
 *
 * @author Pablo Rodriguez Pino 2ºDAM
 */
public class AppUsoMiControl extends Application {
    
    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        
        MiControl miControl = new MiControl();
        
        introspeccion(miControl);
        
        miControl.setOnAction(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Estás pulsando en la zona roja");
            }
        });
        
        Pane root = new Pane();
        root.getChildren().add(miControl);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("AppUsoMiControl");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void introspeccion(MiControl miControl) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException
    {
        // Get Name
        System.out.println("Clase: " + miControl.getClass().getName());
        
        // Mostrar por consola los constructores
        System.out.println("Constructor:" + miControl.getClass().getConstructor());
        
        // Field
        Field sField = miControl.getClass().getField("string1");
        System.out.println("Field: " + sField.toString());
        
        // Mostrar por consola los metodos
        Method[] metodos;
        metodos = miControl.getClass().getDeclaredMethods();
        
        System.out.println("Métodos: ");
        for(int i = 0; i < metodos.length; i++) {
            System.out.println("Metodo "+i+ " : "+metodos[i]);
         }
   
        // Mostrar por consola getName
        System.out.println("GetName:" + miControl.getClass().getName());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
