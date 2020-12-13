package componentes_rodriguezpablo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author
 */
public class SelectorDeslizamiento extends AnchorPane {

    @FXML
    private Button previousButton;
    @FXML
    private Label label;
    @FXML
    private Button nextButton;
    ArrayList<String> items;
    int selectedIndex;
    private boolean repetitive;

    public SelectorDeslizamiento() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("selector_deslizamiento.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        List<String> namesList = Arrays.asList( "1", "2", "3", "4", "5", "6", "7", "8");
        items = new ArrayList<>();
        items.addAll(namesList);
        selectedIndex = 0;
        previousButton.setOnAction((ActionEvent event) -> {
            setPrevious();
            ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
                @Override
                protected void invalidated() {
                    setEventHandler(ActionEvent.ACTION, get());
                }

                @Override
                public Object getBean() {
                    return SelectorDeslizamiento.this;
                }

                @Override
                public String getName() {
                    return "onAction";
                }
            };
        });
        nextButton.setOnAction((ActionEvent event) -> {
            setNext();
            ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
                @Override
                protected void invalidated() {
                    setEventHandler(ActionEvent.ACTION, get());
                }

                @Override
                public Object getBean() {
                    return SelectorDeslizamiento.this;
                }

                @Override
                public String getName() {
                    return "onAction";
                }
            };
        });

    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
        selectFirst();
    }

    public void setPrevious() {
        updateItem(selectedIndex - 1);
    }

    public void setNext() {
        updateItem(selectedIndex + 1);
    }

    public void selectFirst() {
        updateItem(0);
    }

    private void selectLast() {
        updateItem(items.size() - 1);
    }

    private void updateItem() {
        if (items.isEmpty()) {
            label.setText("Vacio");
        } else {
            if (selectedIndex < 0) {
                if (repetitive) {
                    selectedIndex = items.size() - 1;
                } else {
                    selectedIndex = 0;
                }
            }
            if (selectedIndex >= items.size()) {
                if (repetitive) {
                    selectedIndex = 0;
                } else {
                    selectedIndex = items.size() - 1;
                }
            }
            label.setText(items.get(selectedIndex));
        }
    }

    private void updateItem(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        updateItem();
    }

    public void setRepetitive(boolean cyclesThrough) {
        this.repetitive = cyclesThrough;
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
            return SelectorDeslizamiento.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
}
