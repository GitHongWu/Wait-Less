
import java.util.ArrayList;

public class MenuList{
    private ArrayList<MenuItem> itemList;
    private int numItems= 0;
    

    public MenuList(){
        this.itemList = new ArrayList<MenuItem>();
        generateMenu();
    }

    //access the item list to access menu items
    public MenuItem getItem(int i){
        return itemList.get(i);
    }

    // add some generic menu items, can be changed
    public void generateMenu(){
        MenuItem burger = new MenuItem("Cheeseburger", 7.99);
        this.itemList.add(burger);
        numItems++;
        
        MenuItem bfburger = new MenuItem("Beefburger", 8.99);
        this.itemList.add(bfburger);
        numItems++;
        
        MenuItem ckburger = new MenuItem("Chickenburger", 7.99);
        this.itemList.add(ckburger);
        numItems++;

        MenuItem fries = new MenuItem("Fries", 3.99);
        this.itemList.add(fries);
        numItems++;
        
        MenuItem mashpotota = new MenuItem("Mash potato", 2.99);
        this.itemList.add(mashpotota);
        numItems++;
        
        MenuItem salad = new MenuItem("Salad", 4.99);
        this.itemList.add(salad);
        numItems++;
        

        MenuItem sprite = new MenuItem("Sprite", 1.99);
        this.itemList.add(sprite);
        numItems++;
        
        MenuItem coke = new MenuItem("Coke", 1.99);
        this.itemList.add(coke);
        numItems++;
        
        MenuItem beer = new MenuItem("Beer", 2.99);
        this.itemList.add(beer);
        numItems++;
    }

    public void displayMenu(){
        System.out.println("Total Items: " + numItems);
        for(MenuItem MI : this.itemList){
            MI.displayInfo();
        }
    }
}
