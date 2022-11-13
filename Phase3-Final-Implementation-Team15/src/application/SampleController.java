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
import javafx.event.ActionEvent;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SampleController {

	//Brandon
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
	@FXML
	private Button backOrder;
	
	//Karthik
	@FXML
	private Label pizzaType2 = new Label();
	@FXML
	private Label topping1 = new Label();
	@FXML
	private Label topping2 = new Label();
	@FXML
	private Label topping3 = new Label();
	@FXML
	private Label topping4 = new Label();
	@FXML
    private Label pickupTime2 = new Label();
	@FXML
	private Button viewOrder = new Button();
	@FXML
	private Button refresh = new Button();
	@FXML
	private Label orderNum2 = new Label();
	@FXML
	private Button cooking = new Button();
	@FXML
	private Button sendEmail = new Button();
	@FXML
	private Button ready = new Button();
	@FXML
	private Label orderStatusChanged = new Label();
	@FXML
	private Button chefBack = new Button();
	
	private String orderNumber;
	
	//Dipanshu
	@FXML
	private Label pizzaType3 = new Label();
	@FXML
	private Label topping13 = new Label();
	@FXML
	private Label topping23 = new Label();
	@FXML
	private Label topping33 = new Label();
	@FXML
	private Label topping43 = new Label();
	@FXML
    private Label pickupTime3 = new Label();
	@FXML
	private Button viewOrder3 = new Button();
	@FXML
	private Button refresh3 = new Button();
	@FXML
	private Label orderNum3 = new Label();
	@FXML
	private Button cooking3 = new Button();
	@FXML
	private Button sendEmail3 = new Button();
	@FXML
	private Button ready3 = new Button();
	@FXML
	private Button back = new Button();
	@FXML
	private Label messagesProcess = new Label();
	
	private String orderNumber3;

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
		
		//insert asuriteID verification here; also need to check if stuff is null
		if(pickupTime.length() != 5)
		{
			yourOrderNum.setText("Invalid Pickup Time!");
			return;
		}
		if(user.length() != 16)
		{
			yourOrderNum.setText("Invalid ASURITE ID!");
			return;
		}
		else if(!user.substring(8).equals("@asu.edu"))
		{
			yourOrderNum.setText("Invalid ASURITE ID!");
			return;
		}
		boolean flag;
		for(int i = 0; i < 6; i++)
		{
			flag = Character.isDigit(user.charAt(i));
			if(flag)
			{
				yourOrderNum.setText("Invalid ASURITE ID!");
				return;
			}
		}
		
			

		// get the order number
		// traverse data.txt to find the highest order number
		File file = new File("data.txt");
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
		File file = new File("data.txt");
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
		m.changeScene("ProcessNewOrder.fxml");
	}

	public void chefButtonClicked() throws IOException {
		Main m = new Main();
		m.changeScene("AcceptNewOrder.fxml");
	}
	
	public void changeScene() throws IOException
	{
		Main m = new Main();
	   	m.changeScene("ChefStatus.fxml");
	}
	
	public void changeScene2() throws IOException
	{
		Main m = new Main();
	   	m.changeScene("ProcessPerson.fxml");
	}
	
	@FXML
	public void displayOrderForChef() throws IOException
    {
	     
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		
	
		String line = reader.readLine();
		if (line == null)
		{
			orderStatusChanged.setText("No more pending orders!");
			return;
		}
		String[] data = line.split(",");
		
		/*
		String orderNumber = null;
		String statusOfPizza = null;
		String asuRITE = null;
		String topping11 = null;
		String topping21 = null;
		String topping31 = null;
		String topping41 = null;
		String pizza = null;
		String orderTime = null;
		*/
		while(line != null)
		{
			if(data[1].equals("2"))
			{
				if(data[7].equals("1"))
		    	{
		    		pizzaType2.setText("cheese");
		    	}
		    	else if(data[7].equals("2"))
		    	{
		    		pizzaType2.setText("pepporoni");
		    	}
		    	else if(data[7].equals("3"))
		    	{
		    		pizzaType2.setText("veggie");
		    	}
		    	
		    	
		    	if(data[3].equals("1"))
		    	{
		    		topping1.setText("mushrooms");
		    	}
		    	else
		    	{
		    		topping1.setText("no mushrooms");
		    	}
		    	if(data[4].equals("1"))
		    	{
		    		topping2.setText("onions");
		    	}
		    	else
		    	{
		    		topping2.setText("no onions");
		    	}
		    	if(data[5].equals("1"))
		    	{
		    		topping3.setText("olives");
		    	}
		    	else
		    	{
		    		topping3.setText("no olives");
		    	}
		    	if(data[6].equals("1"))
		    	{
		    		topping4.setText("extra cheese");
		    	}
		    	else
		    	{
		    		topping4.setText("no extra cheese");
		    	}
		    	
		    	pickupTime2.setText(data[8]);
		    	
		    	orderNum2.setText(data[0]);
		    	orderNumber = data[0];
				
				/*
				orderNumber = data[0];
				statusOfPizza = data[1];
				asuRITE = data[2];
				topping11 = data[3];
				topping21 = data[4];
				topping31 =data[5];
				topping41 = data[6];
				pizza = data[7];
				orderTime = data[8];
				*/
		    	
		    	
		    	break;
			}
			else
			{
				line = reader.readLine();
				//data = line.split(",");
				try
				{
					data = line.split(",");
				}
				catch (Exception e)
				{
					orderStatusChanged.setText("No more pending orders!");
					break;
				}
				
			}
		}
    	reader.close(); 
		
	}
	
	@FXML
	public void displayOrderForProcess() throws IOException
    {
	     
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		
	
		String line = reader.readLine();
		if (line == null)
		{
			messagesProcess.setText("No more pending orders!");
			return;
		}
		String[] data = line.split(",");
		
		/*
		String orderNumber = null;
		String statusOfPizza = null;
		String asuRITE = null;
		String topping11 = null;
		String topping21 = null;
		String topping31 = null;
		String topping41 = null;
		String pizza = null;
		String orderTime = null;
		*/
		while(line != null)
		{
			if(data[1].equals("1"))
			{
				if(data[7].equals("1"))
		    	{
		    		pizzaType3.setText("cheese");
		    	}
		    	else if(data[7].equals("2"))
		    	{
		    		pizzaType3.setText("pepporoni");
		    	}
		    	else if(data[7].equals("3"))
		    	{
		    		pizzaType3.setText("veggie");
		    	}
		    	
		    	
		    	if(data[3].equals("1"))
		    	{
		    		topping13.setText("mushrooms");
		    	}
		    	else
		    	{
		    		topping13.setText("no mushrooms");
		    	}
		    	if(data[4].equals("1"))
		    	{
		    		topping23.setText("onions");
		    	}
		    	else
		    	{
		    		topping23.setText("no onions");
		    	}
		    	if(data[5].equals("1"))
		    	{
		    		topping33.setText("olives");
		    	}
		    	else
		    	{
		    		topping33.setText("no olives");
		    	}
		    	if(data[6].equals("1"))
		    	{
		    		topping43.setText("extra cheese");
		    	}
		    	else
		    	{
		    		topping43.setText("no extra cheese");
		    	}
		    	
		    	pickupTime3.setText(data[8]);
		    	
		    	orderNum3.setText(data[0]);
		    	orderNumber = data[0];
				
				/*
				orderNumber = data[0];
				statusOfPizza = data[1];
				asuRITE = data[2];
				topping11 = data[3];
				topping21 = data[4];
				topping31 =data[5];
				topping41 = data[6];
				pizza = data[7];
				orderTime = data[8];
				*/
		    	
		    	
		    	break;
			}
			else
			{
				line = reader.readLine();
				//data = line.split(",");
				try
				{
					data = line.split(",");
				}
				catch (Exception e)
				{
					messagesProcess.setText("No more pending orders!");
					break;
				}
				
			}
		}
    	reader.close(); 
		
	}
   
	@FXML
    public void ReadyToCook() throws IOException
    {
		boolean flag = true;
    	BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
    	FileWriter writer = null;
    	String oldContent = "";
    	String newContent = "";
		String line = reader.readLine();
		
		
		while(line != null)
		{
			oldContent = oldContent + line + System.lineSeparator();  
            line = reader.readLine();
		}
		
    	BufferedReader reader1 = new BufferedReader(new FileReader("data.txt"));
    	String line1 = reader1.readLine();
    	if(line1 == null)
    	{
    		messagesProcess.setText("No order loaded!");
    		return;
    	}
    	String[] data = line1.split(",");
    	
		while(line1 != null)
		{
			if(data[0].equals(orderNumber))
			{
				String oldLine = data[0] + "," + data[1] + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];;
				String newLine = data[0] + "," + "2" + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];
				newContent = oldContent.replaceAll(oldLine, newLine);
				
				break;
			}
			else
			{
				line1 = reader1.readLine();
				try
				{
					data = line1.split(",");
				}
				catch (Exception e)
				{
					messagesProcess.setText("No order to change status for!");
					flag = false;
					break;
				}
			}
		}
	    writer = new FileWriter("data.txt");
	    writer.write(newContent);
		reader.close();
		writer.close();
		if (flag)
			messagesProcess.setText("Status changed to READY TO COOK!");
		
    }
	
    @FXML
    public void Cooking() throws IOException
    {
    	boolean flag = true;
    	BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
    	FileWriter writer = null;
    	String oldContent = "";
    	String newContent = "";
		String line = reader.readLine();
		
		
		while(line != null)
		{
			oldContent = oldContent + line + System.lineSeparator();  
            line = reader.readLine();
		}
		
    	BufferedReader reader1 = new BufferedReader(new FileReader("data.txt"));
    	String line1 = reader1.readLine();
    	if (line1 == null)
    	{
    		orderStatusChanged.setText("No order loaded!");
    		return;
    	}
    	String[] data = line1.split(",");
    	
		while(line1 != null)
		{
			if(data[0].equals(orderNumber))
			{
				String oldLine = data[0] + "," + data[1] + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];;
				String newLine = data[0] + "," + "3" + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];
				newContent = oldContent.replaceAll(oldLine, newLine);
				
				break;
			}
			else
			{
				line1 = reader1.readLine();
				try
				{
					data = line1.split(",");
				}
				catch (Exception e)
				{
					orderStatusChanged.setText("No order to change status for!");
					flag = false;
					break;
				}
			}
		}
	    writer = new FileWriter("data.txt");
	    writer.write(newContent);
		reader.close();
		writer.close();
		if(flag)
			orderStatusChanged.setText("Status set to Cooking!");
		
    }
    
    public void Ready() throws IOException
    {
    	boolean flag = true;
    	BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
    	FileWriter writer = null;
    	String oldContent = "";
    	String newContent = "";
		String line = reader.readLine();
		
		
		while(line != null)
		{
			oldContent = oldContent + line + System.lineSeparator();  
            line = reader.readLine();
		}
		
    	BufferedReader reader1 = new BufferedReader(new FileReader("data.txt"));
    	String line1 = reader1.readLine();
    	if (line1 == null)
    	{
    		orderStatusChanged.setText("No order loaded!");
    		return;
    	}
    	String[] data = line1.split(",");
    	
		while(line1 != null)
		{
			if(data[0].equals(orderNumber))
			{
				String oldLine = data[0] + "," + data[1] + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];;
				String newLine = data[0] + "," + "4" + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];
				newContent = oldContent.replaceAll(oldLine, newLine);
				
				break;
			}
			else
			{
				line1 = reader1.readLine();
				//data = line1.split(",");
				try
				{
					data = line1.split(",");
				}
				catch (Exception e)
				{
					orderStatusChanged.setText("No order to change status for!");
					flag = false;
					break;
				}
			}
		}
	    writer = new FileWriter("data.txt");
	    writer.write(newContent);
		reader.close();
		writer.close();
		if(flag)
			orderStatusChanged.setText("Status set to Ready!");
    }
    
    
  
 
   @FXML
   public void changeToFinalScene() throws IOException
   {
	   Main m = new Main();
	   m.changeScene("emailSent.fxml");
   }   
	

}
