import java.sql.SQLException;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginUI {
	
	private boolean sqlServer = false;
	private Scene scene;
	private HashMap<String, Scene> sceneMap;
	private Stage primaryStage;
	private double totalRev;
	
	public LoginUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
		this.sceneMap = sceneMap;
		this.primaryStage = primaryStage;
	}
	
	public Scene createLoginScene() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		Button btn = new Button("Sign in");
		Button signUpBtn = new Button("Sign up");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(signUpBtn);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        grid.setStyle("-fx-background-image: url('background3.jpg')");
        
        HostUI hostUI= new HostUI(sceneMap, primaryStage);
    	sceneMap.put("Host", hostUI.createHostScene());
    	
    	ServerUI serverUI= new ServerUI(sceneMap, primaryStage);
    	sceneMap.put("Server", serverUI.createServerScene());
    	
    	ScheduleUI scheduleUI = new ScheduleUI(sceneMap, primaryStage);
        sceneMap.put("Schedule", scheduleUI.createScheduleScene());
    	
        btn.setOnAction(e->{
            
            if(sqlServer) {
	            MyDatabase db = new MyDatabase();
	            if (db.isConnect()) {
	    			//invalid user
	    			try {
						db.loginValidate(userTextField.toString(), pwBox.toString());
						System.out.println("Valid user");
						//TODO: should return position from mysql
					} catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("Invalid user");
					}
	            }
	            else {
	            	System.out.println("Database not connect");
	            }
            }
            else {
//            	actiontarget.setFill(Color.FIREBRICK);
//              actiontarget.setText("Sign in button pressed");
                if(WelcomeUI.type.equals("host")) {
                	primaryStage.setScene(sceneMap.get("Host"));
                	primaryStage.centerOnScreen();
                }
                if(WelcomeUI.type.equals("manager")) {
                	ManagerUI managerUI= new ManagerUI(sceneMap, primaryStage, getTotalRev(serverUI));
                	sceneMap.put("Manager", managerUI.createManagerScene());
                	primaryStage.setScene(sceneMap.get("Manager"));
                	primaryStage.centerOnScreen();
                }
                if(WelcomeUI.type.equals("server")) {
                	primaryStage.setScene(sceneMap.get("Server"));
                	primaryStage.centerOnScreen();
                }
            }
        });
        
        signUpBtn.setOnAction(e->{
        	sceneMap.put("SignUp", createSignUpScene());
        	primaryStage.setScene(sceneMap.get("SignUp"));
        });
		
		Scene scene = new Scene(grid, 400, 275);
		//reference css file: https://docs.oracle.com/javafx/2/get_started/css.htm
		scene.getStylesheets().add
   	 		(LoginUI.class.getResource("LoginUI.css").toExternalForm());
		return scene;
	}
	
	public Scene createSignUpScene() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Sign up");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		Label position = new Label("Position:");
		grid.add(position, 0, 3);
		
		ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "Host",
		        "Server",
		        "Manager"
		    );
		final ComboBox<String> comboBox = new ComboBox<String>(options);
		grid.add(comboBox, 1, 3);
		
		Button completeBtn = new Button("Sign up");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(completeBtn);
		grid.add(hbBtn, 1, 4);
		
		final Text actiontarget = new Text();
		actiontarget.setFill(Color.FIREBRICK);
        grid.add(actiontarget, 1, 6);
		
		completeBtn.setOnAction(e->{
			if(sqlServer) {
				MyDatabase db = new MyDatabase();
				if (db.isConnect()) {
					try {
						db.signUp(userTextField.getText(), pwBox.getText(), comboBox.getSelectionModel().getSelectedItem().toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					actiontarget.setText("Database connect error");
				}
			}
				
		    actiontarget.setText("Sign up button pressed");
			primaryStage.setScene(sceneMap.get("login"));
		});
		
		Scene scene = new Scene(grid, 400, 275);
		scene.getStylesheets().add
	 		(LoginUI.class.getResource("LoginUI.css").toExternalForm());
		return scene;
	}
	
	public static double getTotalRev(ServerUI obj){
    // increments number variable.       
		return obj.totalRev;
    }
}
