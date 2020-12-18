
import java.util.ArrayList;

public class Tab{
    private ArrayList<MenuItem> items;
    private double Total;

    public Tab(){
        items = new ArrayList<MenuItem>();
        Total = 0.0;
    }

    public void addMenuItem(MenuItem _item){
        items.add(_item);
    }

    public double getTotal(){
        Total = 0.0; //reset total in case function is called multiple times
        for(MenuItem MI : items){
            Total += MI.returnItemPrice();
        }
        System.out.println("Total is: " + Total);
        return Total;
    }
}