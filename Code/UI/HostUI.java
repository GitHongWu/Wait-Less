

import javafx.application.Application;
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

import javax.swing.*;
import java.util.HashMap;

public class HostUI {

    private HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private Button Waitlist_btn,Reservation_btn,Checktable_btn,back;
    private HBox postionBox, exitBox;


    public HostUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
        this.sceneMap = sceneMap;
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
    }
    
    public Scene createHostScene() {
        Waitlist_btn = new Button("Waitlist");
        Waitlist_btn.setStyle("-fx-font: 22 times; -fx-base: #d4ba94;");
        Reservation_btn = new Button("Reservation");
        Reservation_btn.setStyle("-fx-font: 22 times; -fx-base: #d4ba94;");
        Checktable_btn = new Button("Check Table");
        Checktable_btn.setStyle("-fx-font: 22 times; -fx-base: #d4ba94;");
        back = new Button("Exit");
        back.setStyle("-fx-font: 22 times; -fx-base: #d4ba94;");
        postionBox = new HBox(10,Waitlist_btn,Reservation_btn,Checktable_btn);
        postionBox.setLayoutX(30);
        postionBox.setLayoutY(260);
        exitBox = new HBox(10,back);
        exitBox.setLayoutX(370);
        exitBox.setLayoutY(10);
        
        Host host =  new Host("Host");
        
 
        WaitlistUI WaitlistUI = new WaitlistUI(sceneMap, primaryStage);
        sceneMap.put("Waitlist", WaitlistUI.createWaitlistScene(host));
        
        Waitlist_btn.setOnAction(e->{
        	primaryStage.setScene(sceneMap.get("Waitlist"));
        });
        
        ReservationUI ReservationUI = new ReservationUI(sceneMap, primaryStage);
        sceneMap.put("Reservation", ReservationUI.createReservationScene(host));
        
        Reservation_btn.setOnAction(e->{
        	primaryStage.setScene(sceneMap.get("Reservation"));
        });
        
        Checktable_btn.setOnAction(e->{
        	primaryStage.setScene(sceneMap.get("Server"));
        });
        back.setOnAction(e->{
        	primaryStage.setScene(sceneMap.get("welcome"));
        });
        
        //image
        Image background_image = new Image("background.jpg");
        ImageView background_imageView = new ImageView(background_image);
        background_imageView.setFitHeight(300);
        background_imageView.setFitWidth(450);
        background_imageView.setPreserveRatio(true);
        background_imageView.setImage(background_image);
        
        Group Hostpage = new Group();
        Hostpage.getChildren().addAll(background_imageView);
        Hostpage.getChildren().addAll(postionBox);
        Hostpage.getChildren().addAll(exitBox);
        Scene HostScene = new Scene(Hostpage,450,350);
        return HostScene;
        
        
    }
}
