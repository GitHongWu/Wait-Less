import java.sql.Timestamp;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddReservationUI {
	private HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private Button add_btn,delete_btn,sortbyNumGuest,sortbyTime;
    private HBox postionBox;


    public AddReservationUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
        this.sceneMap = sceneMap;
        this.primaryStage = primaryStage;
    }
    
    public Scene createAddReservationScene(Host host) {
    	GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setStyle("-fx-background-image: url('background3.jpg')");

		Label name = new Label("Name:");
		grid.add(name, 0, 0);
		TextField Name= new TextField();
		grid.add(Name, 1, 0);

		
		Label ng = new Label("# of Guest:");
		grid.add(ng, 0, 1);
		TextField numGuest= new TextField();
		grid.add(numGuest, 1, 1);
		
		Label pn = new Label("Phone #:");
		grid.add(pn, 0, 2);
		TextField phoneNum= new TextField();
		grid.add(phoneNum, 1, 2);
		
		Label t = new Label("Time:");
		grid.add(t, 0, 3);
		TextField time= new TextField();
		grid.add(time, 1, 3);
		
		Button btn = new Button("Add");
		Button back = new Button("Back to the Reservation");
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(btn);
		hbBtn.getChildren().add(back);
		grid.add(hbBtn, 1, 5);
		
		Text actiontarget = new Text();
		actiontarget.setFont(Font.font ("times", 14));
        grid.add(actiontarget, 1, 7);
        
        btn.setOnAction(e->{
        	actiontarget.setFill(Color.FIREBRICK);
        	if(checkEmpty(Name, phoneNum,numGuest,actiontarget,time) == true) {
        		String sName = Name.getText();
                String s = numGuest.getText();
                String phone = phoneNum.getText();
                int size = Integer.parseInt(s);
                
                String tmp = time.getText();
                Timestamp ReserveTime = Timestamp.valueOf(tmp+":00.000000000");
                Customer c = new Customer(sName,phone,size,ReserveTime);
                host.addReservation(c); 
                Name.clear();
                numGuest.clear();
                phoneNum.clear();
                time.clear();
                actiontarget.setText("");
                primaryStage.setScene(sceneMap.get("Reservation")); 
        	}
            
        });
        back.setOnAction(e->{ 
        	Name.clear();
            numGuest.clear();
            phoneNum.clear();
            time.clear();
            actiontarget.setText("");
        	primaryStage.setScene(sceneMap.get("Reservation"));
            
        });
		
		Scene scene = new Scene(grid, 400, 275);
		scene.getStylesheets().add
   	 		(LoginUI.class.getResource("LoginUI.css").toExternalForm());
		return scene;
	}
    
    public boolean checkEmpty(TextField Name, TextField phoneNum, TextField numGuest,Text actiontarget,TextField time) {
    	
    	if(Name.getText() == null || Name.getText().trim().isEmpty()) {
    		actiontarget.setText("Name can't be empty");
    		return false;
    	}
    	
    	if(phoneNum.getText() == null || phoneNum.getText().trim().isEmpty()) {
    		actiontarget.setText("Phone number can't be empty");
    		return false;
    	}
    	
    	if(numGuest.getText() == null || numGuest.getText().trim().isEmpty()) {
    		actiontarget.setText("Number of guest can't be empty");	
    		return false;
    	}
    	
    	if(time.getText() == null || time.getText().trim().isEmpty()) {
    		actiontarget.setText("Time can't be empty");
    	}
    	try {
    		Integer.parseInt(phoneNum.getText());
    	}
    	catch(NumberFormatException e){
    		actiontarget.setText("Phone number invalid");
    		return false;
    	}
    	
    	try {
    		Integer.parseInt(numGuest.getText());
    	}
    	catch(NumberFormatException e){
    		actiontarget.setText("Number of guest invalid");
    		return false;
    	}
    	
    	try {
    		
    		Timestamp.valueOf(time.getText()+":00.000000000");
    	}
    	catch(Exception e){
    		actiontarget.setText("Time invalid");
    		return false;
    	}
    	
    	Timestamp currentTime = new Timestamp(System.currentTimeMillis());
    	if(Timestamp.valueOf(time.getText()+":00.000000000").before(currentTime)) {
    		actiontarget.setText("Time can't be before current time");
    		return false;
    	}
    	
    	return true;
    	
    }
}
