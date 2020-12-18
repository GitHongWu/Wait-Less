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

public class DeleteWaitlistUI {
	private HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private Button add_btn,delete_btn,sortbyNumGuest,sortbyTime;
    private HBox postionBox;
    private Customer target;


    public DeleteWaitlistUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
        this.sceneMap = sceneMap;
        this.primaryStage = primaryStage;
    }
    
    public Scene createDeleteWaitlistScene(Host host) {
    	GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		

		Label name = new Label("First Name:");
		grid.add(name, 0, 0);
		TextField Name= new TextField();
		grid.add(Name, 1, 0);
		
		Label pn = new Label("Phone #:");
		grid.add(pn, 0, 1);
		TextField phoneNum= new TextField();
		grid.add(phoneNum, 1, 1);
		
		Button btn = new Button("Find");
		Button delete = new Button("Delete");
		delete.setDisable(true);
		Button back = new Button("Back to the Waitlist");
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(btn);
		hbBtn.getChildren().add(back);
		hbBtn.getChildren().add(delete);
		grid.add(hbBtn, 1, 3);
		
		Text actiontarget = new Text();
		actiontarget.setFont(Font.font ("times", 14));
        grid.add(actiontarget, 1, 5);
        
        grid.setStyle("-fx-background-image: url('background3.jpg')");
        //Customer target;
        
        btn.setOnAction(e->{
        	//Customer target = null;
        	actiontarget.setFill(Color.FIREBRICK);
        	if(checkEmpty(Name, phoneNum,actiontarget) == true) {
        		String sName = Name.getText();
                String phone = phoneNum.getText();
                host.printWaitlist();
                
	            if(sName != null && ! sName.trim().isEmpty()) {
	            	if(host.findCustomerByName(sName) != null) {
	        			target = host.findCustomerByName(sName);
	        			actiontarget.setText("Customer found!\n" + "Customer Name: " + target.getName()+ "\n"
	        					+"Number of Guest: " +target.getPartysize()+ "\n"
	        					+ "Phone Number: " + target.getPhone()+ "\n"
	        					+"Arrival Time: " + target.getTime());
	        			delete.setDisable(false);
	            	}
	        		else 
	       				actiontarget.setText("Customer not found!");	
	            }else {
	                if(host.findCustomerByPhone(phone) != null) {
	                	target = host.findCustomerByPhone(phone);
	                	actiontarget.setText("Customer found!\n" + "Customer Name: " + target.getName()+ "\n"
	        					+"Number of Guest: " +target.getPartysize()+ "\n"
	        					+ "Phone Number: " + target.getPhone()+ "\n"
	        					+"Arrival Time: " + target.getTime());
	                	delete.setDisable(false);
	                }
	        		else 
	        			actiontarget.setText("Customer not found!");
	            }
        	}
        	//primaryStage.setScene(sceneMap.get("Waitlist"));
        });
       
        delete.setOnAction(e->{ 
        	if(target != null) {
        		host.deleteWaitlist(target);
        		Name.clear();
                phoneNum.clear();
                actiontarget.setText("");
                delete.setDisable(true);
        		primaryStage.setScene(sceneMap.get("Waitlist"));
        	}
        	else
        		actiontarget.setText("Unsuccess");
        	//primaryStage.setScene(sceneMap.get("Waitlist"));
            
        });
        back.setOnAction(e->{ 
        	Name.clear();
            phoneNum.clear();
            actiontarget.setText("");
            delete.setDisable(true);
        	primaryStage.setScene(sceneMap.get("Waitlist"));
            
        });
		
		Scene scene = new Scene(grid, 400, 275);
		scene.getStylesheets().add
   	 		(LoginUI.class.getResource("LoginUI.css").toExternalForm());
		return scene;
	}
    
    public boolean checkEmpty(TextField Name, TextField phoneNum,Text actiontarget) {
    	
    	if(Name.getText() == null || Name.getText().trim().isEmpty()) {
    			if(phoneNum.getText() == null || phoneNum.getText().trim().isEmpty()) {
    				actiontarget.setText("At least one field must be entered");
    				return false;
    			} 
    	}
    	return true;
    	
    }
}
