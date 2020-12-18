import java.util.HashMap;

import java.sql.Timestamp;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddWaitlistUI {

	private HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private Button add_btn,delete_btn,sortbyNumGuest,sortbyTime;
    private HBox postionBox;


    public AddWaitlistUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
        this.sceneMap = sceneMap;
        this.primaryStage = primaryStage;
    }
    
    public Scene createAddWaitlistScene(Host host) {
    	GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		

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
		
		Button btn = new Button("Add");
		Button back = new Button("Back to the Waitlist");
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(btn);
		hbBtn.getChildren().add(back);
		grid.add(hbBtn, 1, 4);
		
		Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        grid.setStyle("-fx-background-image: url('background3.jpg')");
        
        btn.setOnAction(e->{
        	actiontarget.setFill(Color.FIREBRICK);
        	
        	if(checkEmpty(Name, phoneNum,numGuest,actiontarget) == true) {
        		String sName = Name.getText();
                String s = numGuest.getText();
                String phone = phoneNum.getText();
                int size = Integer.parseInt(s);
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                
                Customer c = new Customer(sName,phone,size,currentTime);
                host.addWaitlist(c); 
                Name.clear();
                numGuest.clear();
                phoneNum.clear();
                actiontarget.setText("");
                primaryStage.setScene(sceneMap.get("Waitlist")); 
        	}
            
        });
        back.setOnAction(e->{ 
        	Name.clear();
            numGuest.clear();
            phoneNum.clear();
            actiontarget.setText("");
        	primaryStage.setScene(sceneMap.get("Waitlist"));
            
        });
		
		Scene scene = new Scene(grid, 450, 300);
		scene.getStylesheets().add
   	 		(LoginUI.class.getResource("LoginUI.css").toExternalForm());
		return scene;
	}
    
    public boolean checkEmpty(TextField Name, TextField phoneNum, TextField numGuest,Text actiontarget) {
    	
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
    	return true;
    	
    }
}
