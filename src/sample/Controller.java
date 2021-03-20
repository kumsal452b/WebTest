package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button basla;

    @FXML
    private Button dur;

    @FXML
    private ListView<?> list;

    @FXML
    private TextField urlgir;

    @FXML
    private ProgressBar progress;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> sira;

    @FXML
    private TableColumn<?, ?> uadi;

    @FXML
    private TableColumn<?, ?> ilkfiyat;

    @FXML
    private TableColumn<?, ?> sonfiyat;

    @FXML
    private TableColumn<?, ?> url;

    @FXML
    void basla(ActionEvent event) {

    }

    @FXML
    void dur(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
