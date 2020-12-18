import java.util.HashMap;

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

public class ReservationUI {

	private HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private Button add_btn,delete_btn,sortbyNumGuest,sortbyTime, showReservation,back;
    private VBox postionBox;
    private Text text;


    public ReservationUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
        this.sceneMap = sceneMap;
        this.primaryStage = primaryStage;
    }
    
    public Scene createReservationScene(Host host) {
        add_btn = new Button("Add Reservation");
        add_btn.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
        delete_btn = new Button("Delete Reservation");
        delete_btn.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
        sortbyNumGuest = new Button("Sort by # of Guest");
        sortbyNumGuest.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
        sortbyTime = new Button("Sort by Arrival Time");
        sortbyTime.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
        showReservation = new Button("Show All Reservation");
        showReservation.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
        back = new Button("Go back");
        back.setStyle("-fx-font: 16 times; -fx-base: #805e36;");
        
        postionBox = new VBox(10,add_btn,delete_btn,sortbyNumGuest,sortbyTime,showReservation,back);
        postionBox.setLayoutX(750);
        postionBox.setLayoutY(300);
        
        text =  new Text();
        text.setX(50); 
        text.setY(150);
        text.setFont(Font.font ("times", 14));
        //text.setFill(Color.WHITE);
        
        
        AddReservationUI addReservationUI = new AddReservationUI(sceneMap, primaryStage);
        sceneMap.put("addReservation", addReservationUI.createAddReservationScene(host));
        
        add_btn.setOnAction(e->{
        	text.setText("");
        	primaryStage.setScene(sceneMap.get("addReservation"));
        });
        
        DeleteReservationUI deleteReservationUI = new DeleteReservationUI(sceneMap, primaryStage);
        sceneMap.put("deleteReservation", deleteReservationUI.createDeleteReservationScene(host));
        
        delete_btn.setOnAction(e->{
        	text.setText("");
        	primaryStage.setScene(sceneMap.get("deleteReservation"));
        });
        
        sortbyNumGuest.setOnAction(e->{
        	text.setText(host.sortBySizeR());
        });
        
        sortbyTime.setOnAction(e->{
        	text.setText(host.sortByTimeR());
        });
        
        showReservation.setOnAction(e->{
        	text.setText(host.getReservation());
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
        
        Group Reservationpage = new Group();
        Reservationpage.getChildren().add(background_imageView);
        Reservationpage.getChildren().addAll(postionBox);
        Reservationpage.getChildren().add(text);
        
        Scene HostScene = new Scene(Reservationpage,1000,900,Color.BLANCHEDALMOND);
        return HostScene;
    }
}
