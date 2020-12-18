import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
	
	private HashMap<String, Scene> sceneMap;
	
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
    public void start(Stage primaryStage) throws Exception{
		sceneMap = new HashMap<String, Scene>();
		WelcomeUI welcomeUI = new WelcomeUI(sceneMap, primaryStage);
		sceneMap.put("welcome", welcomeUI.createWelcomScene());
		primaryStage.setTitle("Wait-Less Application");
        primaryStage.setScene(sceneMap.get("welcome"));
        primaryStage.show();
	}
}
