
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
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;

public class SampleController {
	
	@FXML
	private Label pizzaType = new Label();
	@FXML
	private Label topping1 = new Label();
	@FXML
	private Label topping2 = new Label();
	@FXML
	private Label topping3 = new Label();
	@FXML
	private Label topping4 = new Label();
	@FXML
    private Label pickupTime = new Label();
	@FXML
	private Button viewOrder = new Button();
	@FXML
	private Button refresh = new Button();
	@FXML
	private Label orderNum = new Label();
	@FXML
	private Button cooking = new Button();
	@FXML
	private Button sendEmail = new Button();
	@FXML
	private Button ready = new Button();
	
	private String orderNumber;
   
	
    
	
	
	@FXML
	public void changeScene() throws IOException
	{
		Main m = new Main();
	   	m.changeScene("ChefStatus.fxml");
	}
	
    @FXML
	public void displayOrderForChef() throws IOException
    {
	     
		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		
	
		String line = reader.readLine();
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
		    		pizzaType.setText("cheese");
		    	}
		    	else if(data[7].equals("2"))
		    	{
		    		pizzaType.setText("pepporoni");
		    	}
		    	else if(data[7].equals("3"))
		    	{
		    		pizzaType.setText("veggie");
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
		    	
		    	pickupTime.setText(data[8]);
		    	
		    	orderNum.setText(data[0]);
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
				data = line.split(",");
			}
		}
    	reader.close(); 
		
	}
    
    @FXML
    public void ReadyToCook() throws IOException
    {
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
    	String[] data = line1.split(",");
    	
		while(line1 != null)
		{
			if(data[0].equals(orderNumber))
			{
				String oldLine = data[0] + "," + data[1] + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];;
				String newLine = data[0] + "," + "2 " + "," +  data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8];
				newContent = oldContent.replaceAll(oldLine, newLine);
				
				break;
			}
			else
			{
				line1 = reader1.readLine();
				data = line1.split(",");
			}
		}
	    writer = new FileWriter("data.txt");
	    writer.write(newContent);
		reader.close();
		writer.close();
		
    }
   
    @FXML
    public void Cooking() throws IOException
    {
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
				data = line1.split(",");
			}
		}
	    writer = new FileWriter("data.txt");
	    writer.write(newContent);
		reader.close();
		writer.close();
		
    }
    
    public void Ready() throws IOException
    {
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
				data = line1.split(",");
			}
		}
	    writer = new FileWriter("data.txt");
	    writer.write(newContent);
		reader.close();
		writer.close();	    	
    }
  
 
   @FXML
   public void changeToFinalScene() throws IOException
   {
	   Main m = new Main();
	   m.changeScene("emailSent.fxml");
   }   
}	

