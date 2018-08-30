package sample;

import administrator.Administrator;
import article.Article;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddItemController {
    String nameOfList;
    @FXML
    TextField nameTextField;
    @FXML
    TextField quantityTextField;
    @FXML
    TextField priceTextField;
    @FXML
    Button CreateArticleButton;
    @FXML
    Button backToMyListButton;

    public Boolean noneEmpty(){
        if (this.nameTextField.getText().equals("") || this.nameTextField == null || this.quantityTextField.getText().equals("") || this.quantityTextField == null || this.priceTextField.getText().equals("") || this.priceTextField == null){
            return false;
        }
        return true;
    }

    public void assingList(String name){
        this.nameOfList = name;
    }

    public void onClickAddItem(){
        Integer quantity = Integer.parseInt(itemQuantity.getText());
        Double price = Double.parseDouble(itemPrice.getText());Item myItem = new Item(itemName.getText(), quantity, price);
        Lists.getLists().addItem(this.nameOfList,myItem);
        Parent window;
        try {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("listView.fxml"));
            window = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Lista de compras");
            stage.setScene(new Scene(window));
            listView myListController = loader.getController();
            listView.redirectedFromArticleAdded(this.nameOfList);
            listView.showData();
            stage.show();
            Stage currentStage = (Stage) onClickAddItem().getScene().getWindow();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cancelButton(){
        Parent window;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addView.fxml"));
            window = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Lista de compras");
            stage.setScene(new Scene(root, 661, 510));
            listView listView = loader.getController();
            listView.redirectedFromArticleAdded(this.nameOfCurrentList);
            listView.showData();
            stage.show();
            Stage currentStage = (Stage) cancelButton.getScene().getWindow();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}