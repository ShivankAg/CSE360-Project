package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.io.FileWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SampleController {

	@FXML
	private Button cust;
	@FXML
	private Button proc;
	@FXML
	private Button chef;
	@FXML
	private TextField username;
	@FXML
	private ChoiceBox<String> pizzaType = new ChoiceBox<String>();
	@FXML
	private CheckBox mushrooms;
	@FXML
	private CheckBox onions;
	@FXML
	private CheckBox olives;
	@FXML
	private CheckBox extraCheese;
	@FXML
	private TextField time;
	@FXML
	private Button placeOrder;
	@FXML
	private Label status;
	@FXML
	private Label email;
	@FXML
	private Button refreshStatus;
	@FXML
	private Button viewStatus;
	@FXML
	private TextField orderNum;
	@FXML
	private TextField enterOrderNum;
	@FXML
	private Label yourOrderNum;
	@FXML
	private Button menu;

	// global variables to hold the data from an order
	private String order;
	private String stat;
	private String user;
	private String mushroom;
	private String olive;
	private String onion;
	private String xCheese;
	private String type;
	private String pickupTime;

	@FXML
	public void initialize() {
		pizzaType.getItems().removeAll(pizzaType.getItems());
		pizzaType.getItems().addAll("Pepperoni", "Vegetable", "Cheese");
		pizzaType.getSelectionModel().select("Pepperoni");
	}

	public void placeOrderClicked() throws IOException {
		// check to see which fields are selected
		// add the fields to our global variables according to what is selected

		// set the status to unchecked
		stat = "1";

		// get the username
		user = username.getText();
		// get the pizza type
		if (pizzaType.getSelectionModel().getSelectedItem() == "Cheese") {
			type = "1";
		} else if (pizzaType.getSelectionModel().getSelectedItem() == "Pepperoni") {
			type = "2";
		} else if (pizzaType.getSelectionModel().getSelectedItem() == "Vegetable") {
			type = "3";
		}
		// get the mushrooms
		if (mushrooms.isSelected()) {
			mushroom = "1";
		} else {
			mushroom = "2";
		}
		// get the olives
		if (olives.isSelected()) {
			olive = "1";
		} else {
			olive = "2";
		}
		// get the onions
		if (onions.isSelected()) {
			onion = "1";
		} else {
			onion = "2";
		}
		// get the extra cheese
		if (extraCheese.isSelected()) {
			xCheese = "1";
		} else {
			xCheese = "2";
		}
		// get the pickup time
		pickupTime = time.getText();

		// get the order number
		// traverse data.txt to find the highest order number
		File file = new File("C:\\Users\\mritc\\eclipse-workspace2\\Phase2GUI\\data.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;

		if (br.readLine() == null) { // if the file is empty
			order = "1";
		} else {
			int count = 2;
			while ((st = br.readLine()) != null) { // read each line of the file
				count++;
			}
			order = Integer.toString(count);
		}

		// write the line into the file
		String text = order + "," + stat + "," + user + "," + mushroom + "," + onion + "," + olive + "," + xCheese + ","
				+ type + "," + pickupTime;

		try (FileWriter fw = new FileWriter("data.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(text);
		} catch (IOException e) {
			System.out.println("file not found");
		}

		yourOrderNum.setText("Order placed! Your order number is: " + order);
	}

	public void checkStatusClicked() throws IOException {
		Main m = new Main();
		m.changeScene("orderPlaced.fxml");
	}
	
	public void viewStatusClicked() throws IOException {
		
		//get the order number that the user entered
		String num = enterOrderNum.getText();
		
		//read the data.txt file
		File file = new File("C:\\Users\\mritc\\eclipse-workspace2\\Phase2GUI\\data.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st = "";
		
		int foo;
		try {
		   foo = Integer.parseInt(num);
		}
		catch (NumberFormatException e) {
		   foo = 0;
		}
		
		for(int i = 0; i < foo; i++) {
			st = br.readLine();
		}
		
		if(st == null) {
			status.setText("order not found");
		} else {
			String[] parts = st.split(",");
			if(parts[1].equals("1")) {
				status.setText("ACCEPTED");
			} else if(parts[1].equals("2")) {
				status.setText("READY TO COOK");
			} else if(parts[1].equals("3")) {
				status.setText("COOKING");
			} else if(parts[1].equals("4")) {
				status.setText("READY (confirmation email sent to: " + parts[2] + ")");
			} else {
				status.setText("error: status is out of bounds");
			}
		}
		
	}
	
	public void menuButtonClicked() throws IOException {
		Main m = new Main();
		m.changeScene("first.fxml");
	}

	public void custButtonClicked() throws IOException {
		Main m = new Main();
		m.changeScene("order.fxml");
	}

	public void procButtonClicked() throws IOException {
		Main m = new Main();
		m.changeScene("process.fxml");
	}

	public void chefButtonClicked() throws IOException {
		Main m = new Main();
		m.changeScene("chef.fxml");
	}
	

}
