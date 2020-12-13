/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes_rodriguezpablo;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Pablo Rodriguez Pino 2ºDAM
 */
public class TemporizadorController extends VBox{

    @FXML
    private Label labelTemporizador;
    
    private static final Integer tiempo = 8;
    private Timeline timeline;
    private Integer tiempoSegundos = tiempo;
    @FXML
    private Button boton;
    @FXML
    private VBox Temporizador;

    
    public TemporizadorController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        
        
        boton.setOnAction(new EventHandler() {  //Button event handler
 
        @Override
        public void handle(Event event) {
            if (timeline != null) {
                timeline.stop();
            }
            tiempoSegundos = tiempo;

            // update timerLabel
            labelTemporizador.setText(tiempoSegundos.toString());
            timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
                      new EventHandler() {
                        // KeyFrame event handler
                        @Override
                        public void handle(Event event) {
                            tiempoSegundos--;
                            // update timerLabel
                            labelTemporizador.setText(tiempoSegundos.toString());
                            if (tiempoSegundos <= 0) {
                                timeline.stop();
                            }
                          }
                    }));
            timeline.playFromStart();
            }
        });
        
        
    
    }
    
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return onAction;
    }

    public final void setOnAction(EventHandler<ActionEvent> value) {
        onActionProperty().set(value);
    }

    public final EventHandler<ActionEvent> getOnAction() {
        return onActionProperty().get();
    }
    
    private ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
        @Override
        protected void invalidated() {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return TemporizadorController.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
