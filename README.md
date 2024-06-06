                                                                               README FILE

NAME: SAI DEEKSHA THAKUR 
ID: 2154075 
FINAL PROJECT

# Online Shopping System
This is an online shopping system implemented in Java, following SOLID principles and design patterns such as Singleton, Factory, and Builder. The system includes features such as user authentication, product catalog management, shopping cart, order processing, and payment processing. Additionally, the system provides a graphical user interface (GUI) for ease of use.

## Features

- User Registration and Authentication
- Product Catalog Management
- Shopping Cart
- Order Placement
- Payment Processing
- Logging

## Project Structure

The project consists of the following main packages and classes:

- `Shopping` package:
  - `Accessories.java`
  - `Appliances.java`
  - `CartBuilder.java`
  - `Catalog.java`
  - `CatalogTest.java`
  - `FileLogger.java`
  - `Groceries.java`
  - `Junit.java`
  - `Kids.java`
  - `Logger.java`
  - `Main.java`
  - `MainClassGUI.java`
  - `Order.java`
  - `PaymentProcessor.java`
  - `PaymentProcessorTest.java`
  - `ProductFactory.java`
  - `ProductLoader.java`
  - `ShoppingCart.java`
  - `ShoppingCartTest.java`
  - `Stationary.java`
  - `User.java`
  - `UserAuthentication.java`

## Prerequisites

-I have java version 21.0.2 (JRE System Library JAVASE-21)
- I used Eclipse IDE 2024-03
- JUnit 5 libraries
-Other needed Junits in my lib folder in the code 

- I  opened my Main java class and clicked Run java application and then appeared Console based output
- For MainGUI, open that java class and run it with java and then u observe the GUI based output for user to interact.
- After running follow the instructions and give required inputs to use your Shopping system



## Setup Instructions (Which were used to create, clone into git and run the code)

### Step 1: Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>

Step 2: Open Eclipse IDE
1.	Open Eclipse IDE.
2.	Go to File > New > Java Project.
3.	Enter the project name and click Finish.
Step 3: Import the Project
1.	Right-click on the project in the Project Explorer and select Import.
2.	Choose General > File System and click Next.
3.	Browse to the directory where you cloned the repository and select it.
4.	Ensure all files are checked and click Finish.
Step 4: Add JUnit 5 Libraries
1.	Right-click on the project and select Build Path > Add Libraries.
2.	Choose JUnit and click Next.
3.	Select JUnit 5 and click Finish.
Step 5: Add JAR Files for Dependencies
1.	Create a lib folder in the root of your project.
2.	Download the following JAR files and place them in the lib folder:
•	junit-platform-console-standalone-1.8.2.jar (or the latest version)
3.	Right-click on the project and select Build Path > Configure Build Path.
4.	Go to the Libraries tab and click Add JARs.
5.	Select all JAR files in the lib folder and click OK.

Step 6: Run the Application
Running the Console Version
1.	Locate the Main.java file in the src/Shopping package.
2.	Right-click on Main.java and select Run As > Java Application.
Running the GUI Version
1.	Locate the MainClassGUI.java file in the src/Shopping package.
2.	Right-click on MainClassGUI.java and select Run As > Java Application.

How to Use
Console Version
1.	Register a new user:
•	Choose the option to create an account.
•	Enter the username, password, and email when prompted.

Enter username: Saideeksha 
Enter password: Saideeksha@1 
Enter email: saideeksha1@example.com   (NOTE: @ here is must)

2.	Log in:
•	Choose the option to log in.
•	Enter your username and password.
3.	Browse products:
•	Choose the option to browse products to see the list of available products.
4.	Add products to the cart:
•	Choose the option to add products to the cart.
•	Enter the product name when prompted.
Enter the product name to add to the cart: example: Refrigerator 
5.	View cart:
•	Choose the option to view the cart to see the items added to your shopping cart.
6.	Place an order:
•	Choose the option to place an order.
•	Select the payment method when prompted.
Select payment method: 1. Credit Card 2. Debit Card 3. Cash 4. Applepay 5. Samsungpay 6. Googlepay 
Example: Please select an option: 1 
7.	Exit the application:
•	Choose the option to exit the application.
GUI Version
1.	Register a new user:
•	Click the Register button.
•	Fill in the username, password, and email in the dialog box that appears.
2.	Log in:
•	Click the Login button.
•	Enter your username and password in the dialog box that appears.
3.	Browse products:
•	Click the Browse Products button to see the list of available products.
4.	Add products to the cart:
•	Click the Add to Cart button.
•	Enter the product name in the dialog box that appears.
Example: Enter the product name to add to the cart: Refrigerator 
5.	View cart:
•	Click the View Cart button to see the items added to your shopping cart.
6.	Place an order:
•	Click the Place Order button.
•	The order will be processed and a message will be displayed confirming the order placement.
7.	Remove products from the cart:
•	Click the Remove from Cart button.
•	Enter the product name in the dialog box that appears.
Example: Enter the product name to remove from the cart: Refrigerator 
8.	Exit the application:
•	Close the application window.

Testing
To run the tests:
1.	Locate the test classes (CatalogTest.java, PaymentProcessorTest.java, ShoppingCartTest.java) in the src/Shopping package.
2.	Right-click on each test class and select Run As > JUnit Test.

In this way one can run this code in ECLIPSE as I did and can run in visual studio depending on the usage.

