									CSE 360: Class Project Phase III
                                                                    Pizza Delivery App

Welcome to the READme page for our pizza delivery app project. This is our submission for the phase 3 class project of CSE 360.

How to run:
In order to run this project, you must import it into Eclipse as a project alongside the JavaFX dependencies. 
Exact instructions on how to set it up are in the "TA-Help" folder on Canvas.

Project Functionality:

Our projects functionality surrounds the world of digitizing certain kinds of businesses completely which makes it a sustainable application.

The coding language that will be used when creating this software is Java/JavaFx. We will not be using anything else when making this software.

We will not be using a database, but instead will be using data structures. All the information will be stored in text documents. 

The text documents will store the ASURITE id, the name of the customer, the pizza type (pepperoni, vegetable, and cheese),
and the toppings (mushroom, onions, olives, and extra cheese)

Since this software will be meant for ASU students, we will have a system that will be checking the ASURITE IDs that the customers use when they place their orders.
However, since we don’t have access to the database where all the ASURITE IDs are stored, the system will use a common trend that is seen in the IDs. 
The trend is that the IDs have six letters and/or two numbers. In an ideal world, we would send this ID to ASU to confirm that this ID exists in their database.
However, since we do not have access to the system, we will assume that all IDs that follow this trend are legitimate.
If an order is placed and the ID doesn’t follow this trend, the system will inform them by saying, “Please put in a valid ID.”

The customer, pizza processing person, and, the pizza chef can view the status of the order. 
However, the pizza processing person and the pizza chef are the only who have access tochange the status of the order.

****************************************************************************************************************************************************************************

When the application is opened, you will be given the option to log in as a customer, pizza processing person, or pizza chef using your ASU ID.

Steps to consider while using the application as a customer:-

1. The Customers interact directly with the software. They will be using this software to view different types of pizzas and toppings that they can put on their pizza.
   
2. After deciding what type of pizza they want, they can then place an order which will be then sent to the Pizza Processing Person. 
   
3. Customers will be uniquely identified by their ASURITE ID which will also be used to validate that they are ASU students.
    
4. ASU ID will also be used for the payment process (it will be added to the food charge tab in the finance section of the MyASU page).
 

Steps to consider while using the application as a pizza processing person:-

1. The pizza processing person will receive orders from the customer with the status of “ACCEPTED” after the the ASU ID has been verified.
 
2. After the order is processed, the pizza processing person will forward the order to the pizza chef by changing the order status to “READY to COOK.” 


Steps to consider while using the application as a pizza chef:-

1. The pizza chef will receive orders from the pizza processing person once they are marked as “READY to COOK.” 

2. Once the chef has received the orders, they will begin to cook the pizza.

3. As the pizza is cooking, they will set the status to “COOKING.” 

4. Once the order is cooked, they will prepare it for pickup and mark the status as “READY.” 

5. This will also trigger an email to be sent to the customer so that they know that the order has been completed.

****************************************************************************************************************************************************************************
