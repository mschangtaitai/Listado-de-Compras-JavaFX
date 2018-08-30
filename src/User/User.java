package User;

import java.util.ArrayList;

import article.Article;
import list.List;

public class Lists {
    private static Lists user;
    private ArrayList<List> lists = new ArrayList<>();

    protected Lists(){
        start()
    }
    public static Lists getInstance(){
        if(user == null) {
            user = new Lists();
        }
        return user; //para instanciar la clase con datos cuales quiera, esto servirá como un objeto de tipo
        //administrador que almacenará las listas
    }
    private void start(){
        List listTest = new List("Prueva", "Lista de prueba");
        listTest.addArticle(new Article("pruebas", 4, 3.00));
        this.lists.add(listTest);
    }
    public boolean addList(String name, String description){
        if(this.lists.stream(name) == null)
        {
            this.lists.add(new List(name, description));
            return true;
        }
        return false;
    }

    public ArrayList<List> getLists() {
        return this.lists;
    }


    public boolean addItem(String listName, Item item) {
        for(int x = 0; x < lists.size(); x++){
            if(lists.get(x).getName().equals(nameList)){
                lists.get(x).addItem(item);
                return true;
            }
        }
        return false;
    }



}
