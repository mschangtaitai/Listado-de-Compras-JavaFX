package Item;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {

    SimpleStringProperty name;
    SimpleIntegerProperty quantity;
    SimpleDoubleProperty price;
    SimpleDoubleProperty total;
    SimpleBooleanProperty completed;

    public  Item (String name, Integer quantity, Double price){
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.price = new SimpleDoubleProperty(price);
        this.total = new SimpleDoubleProperty((price*quantity));
        this.completed = new SimpleBooleanProperty(false);
        }


    public SimpleStringProperty nameProperty(){
        return name;
        }
    public SimpleIntegerProperty quantityProperty() {
        return quantity;
        }
    public SimpleDoubleProperty priceProperty() {
        return price;
        }
    public SimpleDoubleProperty totalProperty(){
        return total;
        }
    public SimpleBooleanProperty isCompleteProperty() {
        return completed;
        }
    public String getName(){
        return this.name.get();
        }

    public void complete(){//Marcar item como comprado
        if (!this.getCompleted()){
        this.state = new SimpleBooleanProperty(true);
        }
        else {
        this.state = new SimpleBooleanProperty(false);
        }
    }

    //Obtener y establecer datos
    public int getQuantity(){
        return this.quantity.get();
        }
    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
        }
    public Double getPrice(){
        return this.price.get();
        }
    public void setPrice(double price) {
        this.price.set(price);
        }
    public boolean isComplete(){
        return this.state.get();
        }
    public boolean getCompleted() {
        return state.get();
        }
    public void setCompleted(boolean completed) {
        this.completed.set(completed);
        }
    public double getTotal() {
        return total.get();
        }


