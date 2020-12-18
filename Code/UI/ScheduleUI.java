import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ScheduleUI {
	
	private HashMap<String, Scene> sceneMap;
	private Stage primaryStage;
	private Schedule schedule;
	private TextField employeeNameTextField;
	private Button enterBtn;
	private Text text;
	
	private final LocalTime firstSlotStart = LocalTime.of(8, 0);
	private final Duration slotLength = Duration.ofMinutes(30);
	private final LocalTime lastSlotStart = LocalTime.of(22, 0);
	
	LocalTime timeIn, timeOut;
	int dayOfWeekInt;
	
	private static final PseudoClass SELECTED_PSEUDO_CLASS = PseudoClass.getPseudoClass("selected");
	
	private final List<TimeSlot> timeSlots = new ArrayList<>();

	public ScheduleUI(HashMap<String, Scene> sceneMap, Stage primaryStage) {
		this.sceneMap = sceneMap;
		this.primaryStage = primaryStage;
	}
	
	public Scene createScheduleScene() {
		
		GridPane calendarView = new GridPane();
		
		ObjectProperty<TimeSlot> mouseAnchor = new SimpleObjectProperty<>();
		
		LocalDate today = LocalDate.now();
		LocalDate startOfWeek = today.minusDays(today.getDayOfWeek().getValue() - 1) ;
		LocalDate endOfWeek = startOfWeek.plusDays(6);
		
		for (LocalDate date = startOfWeek; ! date.isAfter(endOfWeek); date = date.plusDays(1)) {
			int slotIndex = 1 ;
			
			for (LocalDateTime startTime = date.atTime(firstSlotStart);
					! startTime.isAfter(date.atTime(lastSlotStart));
					startTime = startTime.plus(slotLength)) {
				
				
				TimeSlot timeSlot = new TimeSlot(startTime, slotLength);
				timeSlots.add(timeSlot);
				
				registerDragHandlers(timeSlot, mouseAnchor);
				
				calendarView.add(timeSlot.getView(), timeSlot.getDayOfWeek().getValue(), slotIndex);
				slotIndex++ ;
			}
		}
		
		//headers:
		
		DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("E");
		
		for (LocalDate date = startOfWeek; ! date.isAfter(endOfWeek); date = date.plusDays(1)) {
			Label label = new Label(date.format(dayFormatter));
			label.setPadding(new Insets(1));
			label.setTextAlignment(TextAlignment.CENTER);
			GridPane.setHalignment(label, HPos.CENTER);
			calendarView.add(label, date.getDayOfWeek().getValue(), 0);
		}
		
		int slotIndex = 1 ;
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
		for (LocalDateTime startTime = today.atTime(firstSlotStart);
				! startTime.isAfter(today.atTime(lastSlotStart));
				startTime = startTime.plus(slotLength)) {
			Label label = new Label(startTime.format(timeFormatter));
			label.setPadding(new Insets(2));
			GridPane.setHalignment(label, HPos.RIGHT);
			calendarView.add(label, 0, slotIndex);
			slotIndex++ ;
		}
		
		ScrollPane scroller = new ScrollPane(calendarView);
		
		text = new Text("Please enter employee name: ");
		employeeNameTextField = new TextField();
		text.setVisible(false);
		employeeNameTextField.setVisible(false);
		HBox hbox1 = new HBox(10, text, employeeNameTextField);
		hbox1.setAlignment(Pos.CENTER);
		
		enterBtn = new Button("Enter");
		enterBtn.setVisible(false);
		Button backBtn = new Button("Back");
		HBox hbox2= new HBox(10, enterBtn, backBtn);
		hbox2.setAlignment(Pos.CENTER);
		enterBtn.setOnAction(e->{
			int counter = 0;
			for(TimeSlot t : timeSlots) {
				if(t.getTime() == timeIn && t.getDayOfWeek().getValue() == dayOfWeekInt) {
					int columnIndex = dayOfWeekInt;
					int rowIndex = (counter % 29) + 1;
					System.out.println(t.getTime().toString() + t.getDayOfWeek().name());
//					t.getView().setStyle("-fx-background-color:red;");
					calendarView.add(new Label(employeeNameTextField.getText()), columnIndex, rowIndex);
					calendarView.add(new Label("Start From"), columnIndex, rowIndex + 1);
					calendarView.add(new Label(timeIn.toString()), columnIndex, rowIndex + 2);
					calendarView.add(new Label("To"), columnIndex, rowIndex + 3);
					calendarView.add(new Label(timeOut.toString()), columnIndex, rowIndex + 4);
					break;
				}
				counter++;
			}
		});
		backBtn.setOnAction(e->{
			primaryStage.setScene(sceneMap.get("Manager"));
		});
		
		VBox vbox = new VBox(10, scroller, hbox1, hbox2);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10,10,10,10));
		
		Scene scene = new Scene(vbox, 650, 600);
		scene.getStylesheets().add(getClass().getResource("calendar-view.css").toExternalForm());
		return scene;
		
	}
	
	// Registers handlers on the time slot to manage selecting a range of slots in the grid.
	private void registerDragHandlers(TimeSlot timeSlot, ObjectProperty<TimeSlot> mouseAnchor) {
		
		timeSlot.getView().setOnDragDetected(event -> {
			mouseAnchor.set(timeSlot);
			timeSlot.getView().startFullDrag();
			timeSlots.forEach(slot -> 
				slot.setSelected(slot == timeSlot));
		});
		
		timeSlot.getView().setOnMouseDragEntered(event -> {
			TimeSlot startSlot = mouseAnchor.get();
			timeSlots.forEach(slot -> slot.setSelected(isBetween(slot, startSlot, timeSlot)));
			timeSlot.getView().setStyle("-fx-background-color:yellow;");
			timeOut = timeSlot.getTime();
			dayOfWeekInt = timeSlot.getDayOfWeek().getValue();
			
//			String s = timeSlot.getTime().toString();
//			String[] inputs = s.split(":");
//			timeOut = Double.valueOf(inputs[0]) + Double.valueOf("0." + inputs[1]);
			System.out.println("Time Out: " + timeOut);
			System.out.println("DayOfWeek: " + dayOfWeekInt + DayOfWeek.of(dayOfWeekInt));
		});
		
		timeSlot.getView().setOnMouseReleased(event -> {
			mouseAnchor.set(null);
			timeIn = timeSlot.getTime();
			text.setVisible(true);
			employeeNameTextField.setVisible(true);
			enterBtn.setVisible(true);
		});
		
		
	}
	
	// Utility method that checks if testSlot is "between" startSlot and endSlot
	// Here "between" means in the visual sense in the grid: i.e. does the time slot
	// lie in the smallest rectangle in the grid containing startSlot and endSlot
	// 
	// Note that start slot may be "after" end slot (either in terms of day, or time, or both).
	
	// The strategy is to test if the day for testSlot is between that for startSlot and endSlot,
	// and to test if the time for testSlot is between that for startSlot and endSlot, 
	// and return true if and only if both of those hold.
	
	// Finally we note that x <= y <= z or z <= y <= x if and only if (y-x)*(z-y) >= 0.
	
	private boolean isBetween(TimeSlot testSlot, TimeSlot startSlot, TimeSlot endSlot) {

		boolean daysBetween = testSlot.getDayOfWeek().compareTo(startSlot.getDayOfWeek())
				* endSlot.getDayOfWeek().compareTo(testSlot.getDayOfWeek()) >= 0 ;
				
		boolean timesBetween = testSlot.getTime().compareTo(startSlot.getTime())
				* endSlot.getTime().compareTo(testSlot.getTime()) >= 0 ;
				
		return daysBetween && timesBetween ;
	}
	
	// Class representing a time interval, or "Time Slot", along with a view.
	// View is just represented by a region with minimum size, and style class.
	
	// Has a selected property just to represent selection.
	
	public static class TimeSlot {
		
		private final LocalDateTime start ;
		private final Duration duration ;
		private final Region view ;
		
		private final BooleanProperty selected = new SimpleBooleanProperty();
		
		public final BooleanProperty selectedProperty() {
			return selected ;
		}
		
		public final boolean isSelected() {
			return selectedProperty().get();
		}
		
		public final void setSelected(boolean selected) {
			selectedProperty().set(selected);
		}
		
		public TimeSlot(LocalDateTime start, Duration duration) {
			this.start = start;
			this.duration = duration ;
			view = new Region();
			view.setMinSize(80, 20);
			view.getStyleClass().add("time-slot");
			
			selectedProperty().addListener((obs, wasSelected, isSelected) -> 
				view.pseudoClassStateChanged(SELECTED_PSEUDO_CLASS, isSelected));

		}
		
		public LocalDateTime getStart() {
			return start ;
		}
		
		public LocalTime getTime() {
			return start.toLocalTime() ;
		}
		
		public DayOfWeek getDayOfWeek() {
			return start.getDayOfWeek() ;
		}
		
		public Duration getDuration() {
			return duration ;
		}
		
		public Node getView() {
			return view;
		}
		
	}
}
