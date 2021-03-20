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
    private ListView<String> list;

    @FXML
    private TextField urlgir;

    @FXML
    private ProgressBar progress;

    @FXML
    private TableView<modelList> table;

    @FXML
    private TableColumn<modelList, String> sira;

    @FXML
    private TableColumn<modelList, String> uadi;

    @FXML
    private TableColumn<modelList, String> ilkfiyat;

    @FXML
    private TableColumn<modelList, String> sonfiyat;

    @FXML
    private TableColumn<modelList, ?> url;

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
