package sample;
import administrator.Administrator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import list.List;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {

    @FXML
    TableView<List> listsTable;

    @FXML
    TableColumn<List, String> nameColumn;

    @FXML
    TableColumn<List, LocalDate> dateColumn;

    @FXML
    TableColumn<List, String> pendingColumn;

    @FXML
    TableColumn<List, String> estimatedColumn;
    @FXML
    Button newListButton;
    @FXML
    Button editListButton;
    private ObservableList<List> data;
    @FXML
    public void initialize() {
        DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.data = FXCollections.observableArrayList(Administrator.getInstance().getListBook());

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );
        pendingColumn.setCellValueFactory(
                new PropertyValueFactory<>("pending")
        );
        estimatedColumn.setCellValueFactory(
                new PropertyValueFactory<>("estimated")
        );
        this.listsTable.setItems(data);
        System.out.println(data);
    }

    public void openNewList(ActionEvent event) {
        Parent window;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("newList.fxml"));
            window = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(window));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onEditListSelected(){
        List editedList = listsTable.getSelectionModel().getSelectedItem();
        Parent window;
        try {
            if (editedList != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("myList.fxml"));
                window = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Lista de compras");
                stage.setScene(new Scene(window));
                listView myListController = loader.getController();
                myListController.setListToEdit(listToEdit.getName());
                myListController.showData();
                stage.show();
                Stage currentStage = (Stage) editListButton.getScene().getWindow();
                currentStage.hide();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Aguas!");
                alert.setHeaderText("No ha seleccionado nada");
                alert.show();
            }
        }
        catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void onDeleteListSelected(){
        List deletedList =  listsTable.getSelectionModel().getSelectedItem();
        if (deletedList != null){
            Lists.getInstance().getLists().remove(deletedList);

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aguas!");
            alert.setHeaderText("No ha seleccionado!");
            alert.show();
        }


    }
}
