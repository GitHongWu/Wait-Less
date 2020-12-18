import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WelcomeUI {
	
	private Button host,manager,server;
	private HashMap<String, Scene> sceneMap;
	private Stage primaryStage;
	public static String type;
	public WelcomeUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
		this.sceneMap = sceneMap;
		this.primaryStage = primaryStage;
	}
	
	public Scene createWelcomScene() {
		//create buttons
        server = new Button("server");
        server.setPrefWidth(90);
        host = new Button("host");
        host.setPrefWidth(90);
        manager = new Button("manager");
        manager.setPrefWidth(90);
        
        LoginUI loginUI = new LoginUI(sceneMap, primaryStage);
    	sceneMap.put("login", loginUI.createLoginScene());
        
        server.setOnAction(e->{
        	type = "server";
        	primaryStage.setScene(sceneMap.get("login"));
        });
        host.setOnAction(e->{
        	type = "host";
        	primaryStage.setScene(sceneMap.get("login"));
        });
        manager.setOnAction(e->{
        	type = "manager";
        	primaryStage.setScene(sceneMap.get("login"));
        });
        
        //image
        Image pic = new Image("welcome.png");
        ImageView b = new ImageView(pic);
        b.setFitHeight(500);
        b.setFitWidth(500);
        b.setPreserveRatio(true);
        b.setImage(pic);
        
        //hboox
        HBox postionBox = new HBox(10,host,server,manager);
        postionBox.setLayoutX(110);
        postionBox.setLayoutY(170);

        //create pane
        Group startpage = new Group();
        startpage.getChildren().addAll(b, postionBox);
        Scene StartScene = new Scene(startpage);
		return StartScene;
	}
}
