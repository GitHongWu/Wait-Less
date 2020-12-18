import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScheduleUI_Test extends Application {
	
	private HashMap<String, Scene> sceneMap;
	
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
    public void start(Stage primaryStage) throws Exception{
		Schedule schedule = new Schedule();
		
		sceneMap = new HashMap<String, Scene>();
		ScheduleUI scheduleUI = new ScheduleUI(sceneMap, primaryStage);
		sceneMap.put("scedule", scheduleUI.createScheduleScene());
		primaryStage.setTitle("Schedule UI Test");
        primaryStage.setScene(sceneMap.get("schedule"));
        primaryStage.show();
        
	}
}