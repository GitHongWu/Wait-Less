import java.util.HashMap;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WaitlistUI {

	 private HashMap<String, Scene> sceneMap;
	    private Stage primaryStage;
	    private Button add_btn,delete_btn,sortbyNumGuest,sortbyTime, showWaitlist,back;
	    private VBox postionBox;
	    private Text text;


	    public WaitlistUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
	        this.sceneMap = sceneMap;
	        this.primaryStage = primaryStage;
	    }
	    
	    public Scene createWaitlistScene(Host host) {
	        add_btn = new Button("Add Waitlist");
	        add_btn.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
	        delete_btn = new Button("Delete Waitlist");
	        delete_btn.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
	        sortbyNumGuest = new Button("Sort by # of Guest");
	        sortbyNumGuest.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
	        sortbyTime = new Button("Sort by Arrival Time");
	        sortbyTime.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
	        showWaitlist = new Button("Show All Waitlist");
	        showWaitlist.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
	        back = new Button("Go back");
	        back.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
	       //#d4ba94
	        
	        postionBox = new VBox(10,add_btn,delete_btn,sortbyNumGuest,sortbyTime,showWaitlist,back);
	        postionBox.setLayoutX(750);
	        postionBox.setLayoutY(300);
	        
	        
	        text =  new Text();
	        text.setX(50); 
	        text.setY(150);
	        text.setFont(Font.font ("times", 18));
	        
	        System.out.println(host.getAllWaitlist());
	        
	        AddWaitlistUI addWaitlistUI = new AddWaitlistUI(sceneMap, primaryStage);
	        sceneMap.put("addWaitlist", addWaitlistUI.createAddWaitlistScene(host));
	        
	        add_btn.setOnAction(e->{
	        	text.setText("");
	        	primaryStage.setScene(sceneMap.get("addWaitlist"));
	        });
	        
	        DeleteWaitlistUI deleteWaitlistUI = new DeleteWaitlistUI(sceneMap, primaryStage);
	        sceneMap.put("deleteWaitlist", deleteWaitlistUI.createDeleteWaitlistScene(host));
	        
	        delete_btn.setOnAction(e->{
	        	text.setText("");
	        	primaryStage.setScene(sceneMap.get("deleteWaitlist"));
	        });
	        
	        sortbyNumGuest.setOnAction(e->{
	        	text.setText(host.sortBySize());
	        });
	        
	        sortbyTime.setOnAction(e->{
	        	text.setText(host.getAllWaitlist());
	        });
	        
	        showWaitlist.setOnAction(e->{
	        	text.setText(host.getAllWaitlist());
	        });

	        back.setOnAction(e->{
	        	text.setText("");
	        	primaryStage.setScene(sceneMap.get("Host"));
	        });
	        
	        
	      //image
	        Image background_image = new Image("notebook.png");
	        ImageView background_imageView = new ImageView(background_image);
	        background_imageView.setFitHeight(900);
	        background_imageView.setFitWidth(1100);
	        background_imageView.setPreserveRatio(true);
	        background_imageView.setImage(background_image);
	        
	        Group Waitlistpage = new Group();
	        Waitlistpage.getChildren().add(background_imageView);
	        Waitlistpage.getChildren().addAll(postionBox);
	        Waitlistpage.getChildren().add(text);
	        
	        Scene HostScene = new Scene(Waitlistpage,1000,900,Color.BLANCHEDALMOND);
	        return HostScene;
	    }
	    
	        
	      
}
