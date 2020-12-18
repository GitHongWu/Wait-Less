
public class MenuItem{
    private String itemName;
    private double itemPrice;
    private String instructions;

    // constructor
    public MenuItem(String _itemName, double _itemPrice){
        this.itemName = _itemName;
        this.itemPrice = _itemPrice;
        this.instructions ="N/A";
    }

    // setters for MenuItems, in case changes are needed
    public void setItemName(String _itemName){
        this.itemName = _itemName;
    }

    public void setItemPrice(double _itemPrice){
        this.itemPrice = _itemPrice;
    }

    public void setInstructions(String _instructions){
        this.instructions = _instructions;
    }

    public void displayInfo(){
        System.out.println("Item: " + this.itemName);
        System.out.println("Price: " + this.itemPrice);
    }

    // getters for MenuItem values
    String returnItemName(){
        return this.itemName;
    }

    double returnItemPrice(){
        return this.itemPrice;
    }

    String returnInstructions(){
        return this.instructions;
    }
}