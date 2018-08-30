package list;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import article.Article;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.text.SimpleDateFormat;


public class List {
    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    SimpleStringProperty name;
    SimpleStringProperty description;
    SimpleObjectProperty<String> date;
    SimpleIntegerProperty total;
    SimpleDoubleProperty estimated;
    private ArrayList<Item> items;
    public List (String name, String description){
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleObjectProperty<>(dateFormat.format(new Date()));
        this.estimated = new SimpleDoubleProperty();
        this.items = new ArrayList<>();
    }
    public String getName() {
        return this.name.get();
    }
    public SimpleStringProperty nameProperty() {
        return name;
    }
    public String getDescription() {
        return description.get();
    }
    public SimpleObjectProperty dateProperty() {
        return date;
    }

    public java.util.List<Item> getItems(){
        return this.items;
    }
    public double getTotal(){
        return this.items.stream()             // convert list to stream
                .filter(item -> !item.getCompleted()).mapToDouble(article -> article.getTotal()).sum();
    }
    public void addItem(Article article) {
        this.items.add(Item);
}



