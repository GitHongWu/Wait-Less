import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManagerUI {
	
	private HashMap<String, Scene> sceneMap;
	private Stage primaryStage;
	private LocalDateTime t;
	private LocalDate d;
	private double totalRev;

	public ManagerUI(HashMap<String, Scene> sceneMap, Stage primaryStage, double totalRev) {
		this.sceneMap = sceneMap;
		this.primaryStage = primaryStage;
		this.totalRev = totalRev;
	}
	
	public Scene createManagerScene() {
		
        final StackPane root = new StackPane();
        AnchorPane editorRoot = new AnchorPane();
        root.getChildren().add(editorRoot);

        HBox fileRoot = new HBox(50);
        VBox menu = new VBox();
        menu.setStyle("-fx-background-color: #AAFDFF;");
        menu.setFillWidth(true);
        
        Text emptyText = new Text();
        
        Text dateText = new Text("Date: " + d.now());
        Text totalRevText = new Text("Total Revenue: " + totalRev);
    	
    	VBox textVbox = new VBox(10, emptyText, dateText, totalRevText);
        
        Button backBtn = new Button("Sign Out");
        Button tableBtn = new Button("Tables");
        Button scheduleBtn = new Button("Schedule");
        backBtn.setPrefWidth(100);
        tableBtn.setPrefWidth(100);
        scheduleBtn.setPrefWidth(100);
        tableBtn.getStyleClass().add("custom-menu-button");
        backBtn.getStyleClass().add("custom-menu-button");
        scheduleBtn.getStyleClass().add("custom-menu-button");
        
        backBtn.setOnAction(e->{
            primaryStage.setScene(sceneMap.get("login"));
        });
        tableBtn.setOnAction(e->{
			primaryStage.setScene(sceneMap.get("Server"));
		});
        scheduleBtn.setOnAction(e->{
			primaryStage.setScene(sceneMap.get("Schedule"));
		});
        
        menu.getChildren().addAll(backBtn, tableBtn, scheduleBtn);
        VBox.setVgrow(tableBtn, Priority.ALWAYS);
        fileRoot.getChildren().add(menu);
        fileRoot.getChildren().add(textVbox);

        root.getChildren().add(fileRoot);
        Scene scene = new Scene(root, 350, 250);
        scene.getStylesheets().add
	 		(LoginUI.class.getResource("ManagerUI.css").toExternalForm());
		return scene;
	}
	
	public Double getTotalRev() {
		return totalRev;
	}
}
