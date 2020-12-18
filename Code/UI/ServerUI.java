import java.util.HashMap;

import com.sun.xml.internal.ws.api.message.Message;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;


public class ServerUI{ 

    private Button exit,table1,table2,table3,table4,table5,table6,table7,table8,table9,table10,
    checkout1,checkout2,checkout3,checkout4,checkout5,checkout6,checkout7,checkout8,checkout9,checkout10;
    private Text Mytest;
    private HBox tableBox;
    private HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private boolean hasTable1,hasTable2,hasTable3,hasTable4,hasTable5,hasTable6,hasTable7,
    hasTable8,hasTable9,hasTable10 = false;
    private Table Table1,Table2,Table3,Table4,Table5,Table6,Table7,Table8,Table9,Table10;
    private TableUI TableUI,TableUI2,TableUI3,TableUI4,TableUI5,TableUI6,TableUI7,TableUI8,TableUI9,TableUI10;
    public double totalRev = 0.0;
    
    public ServerUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
		this.sceneMap = sceneMap;
		this.primaryStage = primaryStage;
	}
    
	public Scene createServerScene() { 
		//table button
        table1 = new Button("table1");
        table1.setPrefWidth(65);
        table1.setPrefHeight(65);
        table1.setStyle("-fx-background-color: Green");
        table2 = new Button("table2");
        table2.setPrefWidth(65);
        table2.setPrefHeight(65);
        table2.setStyle("-fx-background-color: Green");
        table3 = new Button("table3");
        table3.setPrefWidth(65);
        table3.setPrefHeight(65);
        table3.setStyle("-fx-background-color: Green");
        table4 = new Button("table4");
        table4.setPrefWidth(65);
        table4.setPrefHeight(65);
        table4.setStyle("-fx-background-color: Green");
        table5 = new Button("table5");
        table5.setPrefWidth(65);
        table5.setPrefHeight(65);
        table5.setStyle("-fx-background-color: Green");
        table6 = new Button("table6");
        table6.setPrefWidth(65);
        table6.setPrefHeight(65);
        table6.setStyle("-fx-background-color: Green");
        table7 = new Button("table7");
        table7.setPrefWidth(60);
        table7.setPrefHeight(45);
        table7.setStyle("-fx-background-color: Green");
        table8 = new Button("table8");
        table8.setPrefWidth(60);
        table8.setPrefHeight(45);
        table8.setStyle("-fx-background-color: Green");
        table9 = new Button("table9");
        table9.setPrefWidth(60);
        table9.setPrefHeight(45);
        table9.setStyle("-fx-background-color: Green");
        table10 = new Button("table10");
        table10.setPrefWidth(60);
        table10.setPrefHeight(45);
        table10.setStyle("-fx-background-color: Green");
        //checkout button
        checkout1 = new Button("checkout");
        checkout1.setDisable(true);
        checkout2 = new Button("checkout");
        checkout2.setDisable(true);
        checkout3 = new Button("checkout");
        checkout3.setDisable(true);
        checkout4 = new Button("checkout");
        checkout4.setDisable(true);
        checkout5= new Button("checkout");
        checkout5.setDisable(true);
        checkout6 = new Button("checkout");
        checkout6.setDisable(true);
        checkout7= new Button("checkout");
        checkout7.setDisable(true);
        checkout8 = new Button("checkout");
        checkout8.setDisable(true);
        checkout9 = new Button("checkout");
        checkout9.setDisable(true);
        checkout10 = new Button("checkout");
        checkout10.setDisable(true);

        //exit button
        exit = new Button("Exit");
        exit.setLayoutY(550);
        exit.setLayoutX(900);
        
        Button host = new Button("BackToHost");
        host.setLayoutX(50);
        host.setLayoutY(550);
        
        Image BGpic = new Image("serverBG.png");
        ImageView b = new ImageView(BGpic);
        b.setFitHeight(600);
        b.setFitWidth(1000);
        //b.setPreserveRatio(true);
        b.setImage(BGpic);
        
        table1.setOnAction(e->{
        	if(hasTable1 == false) {
        		this.Table1 = new Table(1);
        		hasTable1 = true;
        		table1.setStyle("-fx-background-color: Red");
        		checkout1.setDisable(false);
        		TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table"));
        	}
        	
        	
        });
        
        table2.setOnAction(e->{
        	if(hasTable2 == false) {
        		this.Table2 = new Table(2);
        		hasTable2 = true;
        		checkout2.setDisable(false);
        		table2.setStyle("-fx-background-color: Red");
        		TableUI tableUI2 = new TableUI(Table2,sceneMap, primaryStage);
                sceneMap.put("Table2", tableUI2.createTableScene());
                primaryStage.setScene(sceneMap.get("Table2"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table2"));
        	}
        });
        
        table3.setOnAction(e->{
        	if(hasTable3 == false) {
        		this.Table3 = new Table(3);
        		hasTable3 = true;
        		checkout3.setDisable(false);
        		table3.setStyle("-fx-background-color: Red");
        		TableUI tableUI3 = new TableUI(Table3,sceneMap, primaryStage);
                sceneMap.put("Table3", tableUI3.createTableScene());
                primaryStage.setScene(sceneMap.get("Table3"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table3"));
        	}
        });
        
        table4.setOnAction(e->{
        	if(hasTable4 == false) {
        		this.Table4 = new Table(4);
        		hasTable4 = true;
        		checkout4.setDisable(false);
        		table4.setStyle("-fx-background-color: Red");
        		TableUI tableUI4 = new TableUI(Table4,sceneMap, primaryStage);
                sceneMap.put("Table4", tableUI4.createTableScene());
                primaryStage.setScene(sceneMap.get("Table4"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table4"));
        	}
	
        });
        
        table5.setOnAction(e->{
        	if(hasTable5 == false) {
        		this.Table5 = new Table(5);
        		hasTable5 = true;
        		checkout5.setDisable(false);
        		table5.setStyle("-fx-background-color: Red");
        		TableUI tableUI5 = new TableUI(Table5,sceneMap, primaryStage);
                sceneMap.put("Table5", tableUI5.createTableScene());
                primaryStage.setScene(sceneMap.get("Table5"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table5"));
        	}
        });
        
        table6.setOnAction(e->{
        	if(hasTable6 == false) {
        		this.Table6 = new Table(6);
        		hasTable6 = true;
        		checkout6.setDisable(false);
        		table6.setStyle("-fx-background-color: Red");
        		TableUI tableUI6 = new TableUI(Table6,sceneMap, primaryStage);
                sceneMap.put("Table6", tableUI6.createTableScene());
                primaryStage.setScene(sceneMap.get("Table6"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table6"));
        	}
        });
        
        table7.setOnAction(e->{
        	if(hasTable7 == false) {
        		this.Table7 = new Table(7);
        		hasTable7 = true;
        		checkout7.setDisable(false);
        		table7.setStyle("-fx-background-color: Red");
        		TableUI tableUI7 = new TableUI(Table7,sceneMap, primaryStage);
                sceneMap.put("Table7", tableUI7.createTableScene());
                primaryStage.setScene(sceneMap.get("Table7"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table7"));
        	}
        });
        
        table8.setOnAction(e->{
        	if(hasTable8 == false) {
        		this.Table8 = new Table(8);
        		hasTable8 = true;
        		checkout8.setDisable(false);
        		table8.setStyle("-fx-background-color: Red");
        		TableUI tableUI8 = new TableUI(Table8,sceneMap, primaryStage);
                sceneMap.put("Table8", tableUI8.createTableScene());
                primaryStage.setScene(sceneMap.get("Table8"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table8"));
        	}
        });
        
        table9.setOnAction(e->{
        	if(hasTable9 == false) {
        		this.Table9 = new Table(9);
        		hasTable9 = true;
        		checkout9.setDisable(false);
        		table9.setStyle("-fx-background-color: Red");
        		TableUI tableUI9 = new TableUI(Table9,sceneMap, primaryStage);
                sceneMap.put("Table9", tableUI9.createTableScene());
                primaryStage.setScene(sceneMap.get("Table9"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table9"));
        	}
        });
        
        table10.setOnAction(e->{
        	if(hasTable10 == false) {
        		this.Table10 = new Table(10);
        		hasTable10 = true;
        		checkout10.setDisable(false);
        		table10.setStyle("-fx-background-color: Red");
        		TableUI tableUI10 = new TableUI(Table10,sceneMap, primaryStage);
                sceneMap.put("Table10", tableUI10.createTableScene());
                primaryStage.setScene(sceneMap.get("Table10"));
        		
        	}
        	else {
            	//TableUI tableUI = new TableUI(Table1,sceneMap, primaryStage);
                //sceneMap.put("Table", tableUI.createTableScene());
                primaryStage.setScene(sceneMap.get("Table10"));
        	}
        });
        
        checkout1.setOnAction(e->{
        	totalRev += Double.parseDouble(Table1.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table1.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table1.setStyle("-fx-background-color: Green");
        	hasTable1 = false;
        	checkout1.setDisable(true);
        	
        });
        
        checkout2.setOnAction(e->{
        	totalRev += Double.parseDouble(Table2.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table2.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table2.setStyle("-fx-background-color: Green");
        	hasTable2 = false;
        	checkout2.setDisable(true);
        	
        });
        checkout3.setOnAction(e->{
        	totalRev += Double.parseDouble(Table3.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table3.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table3.setStyle("-fx-background-color: Green");
        	hasTable3 = false;
        	checkout3.setDisable(true);
        	
        });
        
        checkout4.setOnAction(e->{
        	totalRev += Double.parseDouble(Table4.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table4.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table4.setStyle("-fx-background-color: Green");
        	hasTable4 = false;
        	checkout4.setDisable(true);
        	
        });
        
        checkout5.setOnAction(e->{
        	totalRev += Double.parseDouble(Table5.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table5.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table5.setStyle("-fx-background-color: Green");
        	hasTable5 = false;
        	checkout5.setDisable(true);
        	
        });
        
        checkout6.setOnAction(e->{
        	totalRev += Double.parseDouble(Table6.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table6.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table6.setStyle("-fx-background-color: Green");
        	hasTable6 = false;
        	checkout6.setDisable(true);
        	
        });
        
        checkout7.setOnAction(e->{
        	totalRev += Double.parseDouble(Table7.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table7.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table7.setStyle("-fx-background-color: Green");
        	hasTable7 = false;
        	checkout7.setDisable(true);
        	
        });
        
        checkout8.setOnAction(e->{
        	totalRev += Double.parseDouble(Table8.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table8.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table8.setStyle("-fx-background-color: Green");
        	hasTable8 = false;
        	checkout8.setDisable(true);
        	
        });
        
        checkout9.setOnAction(e->{
        	totalRev += Double.parseDouble(Table9.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table9.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table9.setStyle("-fx-background-color: Green");
        	hasTable9 = false;
        	checkout9.setDisable(true);
        	
        });
        
        checkout10.setOnAction(e->{
        	totalRev += Double.parseDouble(Table10.getOrdercost());
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Total is "+Table10.getOrdercost());
        	alert.getDialogPane().setPrefSize(1000, 500);
        	alert.show();
        	table10.setStyle("-fx-background-color: Green");
        	hasTable10 = false;
        	checkout10.setDisable(true);
        	
        });
        
        

        exit.setOnAction(e->{
            primaryStage.setScene(sceneMap.get("welcome"));
        });
        
        host.setOnAction(e->{
        	primaryStage.setScene(sceneMap.get("Host"));
        });

        //for table
        HBox tableBox = new HBox(80,table1,table2,table3);
        tableBox.setLayoutX(360);
        tableBox.setLayoutY(135);

        HBox tableBox2 = new HBox(80,table4,table5,table6);
        tableBox2.setLayoutX(360);
        tableBox2.setLayoutY(220);

        HBox tableBox3 = new HBox(90,table7,table8);
        tableBox3.setLayoutX(350);
        tableBox3.setLayoutY(320);
        
        HBox tableBox4 = new HBox(90,table9,table10);
        tableBox4.setLayoutX(350);
        tableBox4.setLayoutY(400);
       
        //checkout boxes
        HBox checkoutBox = new HBox(80,checkout1,checkout2,checkout3);
        checkoutBox.setLayoutX(360);
        checkoutBox.setLayoutY(110); 
        
        HBox checkoutBox2 = new HBox(80,checkout4,checkout5,checkout6);
        checkoutBox2.setLayoutX(360);
        checkoutBox2.setLayoutY(280);
        
        HBox checkoutBox3 = new HBox(80,checkout7,checkout8);
        checkoutBox3.setLayoutX(350);
        checkoutBox3.setLayoutY(365);
        
        HBox checkoutBox4 = new HBox(80,checkout9,checkout10);
        checkoutBox4.setLayoutX(350);
        checkoutBox4.setLayoutY(440);


        Group Serverpage = new Group();
        Serverpage.getChildren().addAll(b,host,exit,tableBox,tableBox2,tableBox3,tableBox4,checkoutBox,checkoutBox2,checkoutBox3,checkoutBox4);
        Scene StartScene = new Scene(Serverpage,1000,600);
        return StartScene;
    }
}