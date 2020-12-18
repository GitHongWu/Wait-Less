

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;

public class TableUI {
	private double totalcost;
	private String namelist = "ordered: ";

    private HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private Button item1,item2,item3,item4;
    private VBox ItemList,List;
    private Table table;


    public TableUI(Table tb,HashMap<String, Scene> sceneMap, Stage primaryStage) {
    	this.table = tb;
        this.sceneMap = sceneMap;
        this.primaryStage = primaryStage;
        
    }
    
    public Scene createTableScene() {
        Button item1 = new Button(table.getMeunlist().getItem(0).returnItemName());
        Button item2 = new Button(table.getMeunlist().getItem(1).returnItemName());
        Button item3 = new Button(table.getMeunlist().getItem(2).returnItemName());
        Button item4 = new Button(table.getMeunlist().getItem(3).returnItemName());
        Button item5 = new Button(table.getMeunlist().getItem(4).returnItemName());
        Button item6 = new Button(table.getMeunlist().getItem(5).returnItemName());
        Button item7 = new Button(table.getMeunlist().getItem(6).returnItemName());
        Button item8 = new Button(table.getMeunlist().getItem(7).returnItemName());
        Button item9 = new Button(table.getMeunlist().getItem(8).returnItemName());
        Button back = new Button("back");
        back.setLayoutX(900);
        back.setLayoutY(400);
        
        
        Image tablepic = new Image("newtableBG.jpg");
        ImageView b = new ImageView(tablepic);
        b.setFitHeight(500);
        b.setFitWidth(1000);
        //b.setPreserveRatio(true);
        b.setImage(tablepic);
        
        Text entree = new Text("Entree:");
        entree.setFill(Color.WHITESMOKE);
        entree.setFont(Font.font(20));
        
        Text sides = new Text("Sides:");
        sides.setFill(Color.WHITESMOKE);
        sides.setFont(Font.font(20));
        
        Text drink = new Text("Drink:");
        drink.setFill(Color.WHITESMOKE);
        drink.setFont(Font.font(20));
        
        HBox enterrlist = new HBox(20,entree,item1,item2,item3);
        HBox sideslist = new HBox(20,sides,item4,item5,item6);
        HBox drinklist = new HBox(20,drink,item7,item8,item9);
        
        //VBox ItemList = new VBox(20,entree,item1,item2,item3,item4);
        VBox ItemList = new VBox(20,enterrlist,sideslist,drinklist);
        ItemList.setLayoutX(400);
        ItemList.setLayoutY(150);
        
        
        
        Text Cost = new Text("cost:");
        Cost.setFill(Color.WHITESMOKE);
        Cost.setFont(Font.font(20));
        Text orderlist = new Text("list");
        orderlist.setFill(Color.WHITESMOKE);
        orderlist.setFont(Font.font(20));
        VBox List = new VBox(orderlist,Cost);
        List.setLayoutX(50);
        List.setLayoutY(100);
        
        item1.setOnAction(e->{
        	//totalcost+=7.99;
        	//namelist = namelist+"cheeseburger ";
        	table.OrderItem(0);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item2.setOnAction(e->{
        	table.OrderItem(1);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item3.setOnAction(e->{
        	table.OrderItem(2);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item4.setOnAction(e->{
        	table.OrderItem(3);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item5.setOnAction(e->{
        	table.OrderItem(4);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item6.setOnAction(e->{
        	table.OrderItem(5);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item7.setOnAction(e->{
        	table.OrderItem(6);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item8.setOnAction(e->{
        	table.OrderItem(7);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        item9.setOnAction(e->{
        	table.OrderItem(8);
        	orderlist.setText("Ordered: "+table.getOrderName());
        	Cost.setText("cost: "+ table.getOrdercost());
        });
        
        back.setOnAction(e->{
        	primaryStage.setScene(sceneMap.get("Server"));
        });
        
        



        Group Hostpage = new Group();
        Hostpage.getChildren().addAll(b,back,ItemList,List);
        Scene HostScene = new Scene(Hostpage,1000,500);
        return HostScene;
    }
}
