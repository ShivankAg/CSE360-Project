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

public class SampleController {
	
	@FXML
    private Button login;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
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
    private int count = 0;
    
    @FXML
    public void initialize() {
        pizzaType.getItems().removeAll(pizzaType.getItems());
        pizzaType.getItems().addAll("Pepperoni", "Vegetable", "Cheese");
        pizzaType.getSelectionModel().select("Pepperoni");
    }
    
	public void loginButtonClicked() throws IOException{
		Main m = new Main();
		m.changeScene("order.fxml");
	}
	
	public void placeOrderClicked() throws IOException{
		Main m = new Main();
		m.changeScene("orderPlaced.fxml");
	}
	
	public void refreshStatusClicked() throws IOException{
		if(count == 0) {
			status.setText("COOKING");
			count++;
		} else if(count == 1) {
			status.setText("READY");
			email.setText("Email sent");
			count++;
		}
	}
	
}
