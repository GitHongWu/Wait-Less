import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerUI_Test extends Application {
	
	private HashMap<String, Scene> sceneMap;
	
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
    public void start(Stage primaryStage) throws Exception{
		Schedule schedule = new Schedule();
		double totalRev = 0.0;
		
		sceneMap = new HashMap<String, Scene>();
		ManagerUI managerUI = new ManagerUI(sceneMap, primaryStage, totalRev);
		sceneMap.put("manager", managerUI.createManagerScene());
		primaryStage.setTitle("Wait-Less Application");
        primaryStage.setScene(sceneMap.get("manager"));
        primaryStage.show();
        
	}
}
