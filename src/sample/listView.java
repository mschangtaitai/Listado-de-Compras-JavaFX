package sample;

import administrator.Administrator;
import article.Article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListView{
    private String listName;
    private String description;
    @FXML
    Label listName;
    @FXML
    Label listDescription;
    @FXML
    Label listTotal;
    @FXML
    Button addItemButton;
    @FXML
    TableView<Article> itemsTable;
    @FXML
    TableColumn<Article, String> itemColumn;
    @FXML
    TableColumn<Article, String> quantityColumn;
    @FXML
    TableColumn<Article, String> priceColumn;
    @FXML
    TableColumn<Article, String> totalColumn;
    @FXML
    TableColumn<Article, String> stateColumn;
    @FXML
    Button stateButton;
    @FXML
    Button returnButton;

    @FXML
    private observableList<Item> data;

    public void showData(){
        listName.setText(this.listName);
        listDescription.setText(this.description);
        Double Total = Lists.getInstance().getLists(this.listName).getTotal();
        listTotal.setText(pending.toString());

        this.data = FXCollections.observableArrayList(Lists.getInstance().getLists(this.listName).getItems());
        articleColumn.setCellValueFactory(
                new  PropertyValueFactory<>("name")
        );
        quantityColumn.setCellValueFactory(
                new PropertyValueFactory<>("quantity")
        );
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );
        totalColumn.setCellValueFactory(
                new PropertyValueFactory<>("total")
        );
        stateColumn.setCellValueFactory(
                new PropertyValueFactory<>("state")
        );
        this.itemsTable.setItems(data);

    }
    public void setProperties(String name, String description){
        this.currentListName = name;
        this.description = description;
        Administrator administrator = Administrator.getInstance();
        administrator.addList(name, description);


    }
    public void redirectedFromArticleAdded(String name){
        this.currentListName = name;
        this.description = Administrator.getInstance().getListByName(this.currentListName).getDescription();
    }

    public void setListToEdit(String nameOfList){
        this.currentListName = nameOfList;
        this.description = Administrator.getInstance().getListByName(this.currentListName).getDescription();
    }




    public void onAddItem(){
        Parent window;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addItem.fxml"));
            window = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Nuevo Artículo");
            stage.setScene(new Scene(root));
            addItemController itemController = loader.getController();
            itemController.setNameOfList(this.listName);
            stage.show();
            Stage currentStage = (Stage) addItemButton.getScene().getWindow();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void returnButton(){
        Parent window;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            window = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Control de listado");
            stage.setScene(new Scene(window));
            stage.show();
            Stage currentStage = (Stage) returnButton.getScene().getWindow();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onClickState(){
        Item item =  itemsTable.getSelectionModel().getSelectedItem();
        Lists.getInstance().getLists(this.currentListName).showData();
    }
}