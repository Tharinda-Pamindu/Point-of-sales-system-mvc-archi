# Point of Sale System

A simple Point of Sale (POS) system built with a Model-View-Controller (MVC) architecture. This application provides basic functionalities for managing customers, items, and processing sales orders.

-----

## Features

  * **Customer Management:**
      * Add new customers with details like name, address, email, and postal code.
      * Update existing customer information.
      * Delete customers from the system.
      * View a list of all customers.
  * **Item Management:**
      * Add new items with a description, quantity, and unit price.
      * Update existing item details.
      * Delete items from the system.
      * View a list of all available items.
  * **Order Processing:**
      * Create new orders by selecting a customer and adding items to the bill.
      * The system calculates the total for each item and a subtotal for the entire order.
      * A simple checkout process to finalize the order.

-----

## Technologies Used

  * **Java:** The core programming language used for the application.
  * **Swing:** Used for creating the graphical user interface (GUI).
  * **MySQL:** The database used for storing customer, item, and order data.
  * **NetBeans:** The IDE used for the development of this project.

-----

## Setup and Installation

1.  **Prerequisites:**

      * Java Development Kit (JDK) 17 or higher.
      * MySQL database server.

2.  **Database Configuration:**

      * Create a new database named `newPos`.
      * Execute the following SQL statements to create the necessary tables:

    <!-- end list -->

    ```sql
    CREATE TABLE customer (
        id VARCHAR(255) PRIMARY KEY,
        name VARCHAR(255),
        address VARCHAR(255),
        email VARCHAR(255),
        postalCode VARCHAR(255)
    );

    CREATE TABLE item (
        itemCode VARCHAR(255) PRIMARY KEY,
        description VARCHAR(255),
        quantity INT,
        unit_Price DECIMAL(10, 2)
    );

    CREATE TABLE orders (
        orderID VARCHAR(255) PRIMARY KEY,
        custID VARCHAR(255),
        orderDate DATETIME,
        subTotal DECIMAL(10, 2)
    );

    CREATE TABLE orderDetails (
        orderID VARCHAR(255),
        itemCode VARCHAR(255),
        description VARCHAR(255),
        unitPrice DECIMAL(10, 2),
        quantity INT,
        subTotal DECIMAL(10, 2)
    );
    ```

3.  **Project Setup:**

      * Open the project in NetBeans.
      * The project uses the `mysql-connector-java-8.0.29.jar` which is included in the `src/newpos/mvc/lib` folder. Ensure this is correctly referenced in the project's libraries.
      * Modify the database connection details in `src/newpos/mvc/db/DBConnection.java` if your MySQL username and password are different.

-----

## Usage

1.  Run the `NewposMvc.java` file to start the application.
2.  This will open three windows: "Customer View," "Item Manage," and "Orders."
3.  Use the "Customer View" and "Item Manage" windows to add, update, and delete customer and item information.
4.  Use the "Orders" window to create new sales orders.

-----

## Project Structure

The project follows the MVC design pattern:

  * **Model:** Contains the data and business logic of the application. The classes in the `newpos.mvc.model` package (e.g., `Customer`, `Item`, `Orders`, `OrderDetails`) represent the data structures.
  * **View:** The user interface of the application. The classes in the `newpos.mvc.view` package (e.g., `CustomerView`, `ItemView`, `OrderView`) are responsible for displaying the data to the user and capturing user input.
  * **Controller:** Acts as an intermediary between the Model and the View. The classes in the `newpos.mvc.controller` package (e.g., `CustomerController`, `ItemController`, `OrderController`) handle user requests from the View and update the Model accordingly.
  * **DB:** The `newpos.mvc.db` package contains the `DBConnection` class, which manages the connection to the MySQL database.
