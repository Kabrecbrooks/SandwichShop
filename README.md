# SandwichShop

# DELI-cious Sandwich Shop - Java Console App

Welcome to **DELI-cious**, a Java-based point-of-sale (POS) system for a sandwich shop. This console application allows users to create customized sandwich orders including drinks, chips, toppings, sauces, and sides. Receipts are saved to local files for order tracking.



----------

## 🧾 Description of Key Files

### `Main.java`

-   Entry point of the application.
    
-   Initializes the scanner and presents a basic home menu for the user:
    
    -   Start new order
        
    -   Exit program
        

### `HomeScreen.java`

-   Alternative home screen interface.
    
-   Currently similar in function to `Main.java`'s menu but more modular.
    
-   Calls `Order` class to start a new order session.
    

### `Order.java`

-   Handles the full order lifecycle:
    
    -   Adding sandwiches, drinks, chips
        
    -   Reviewing and confirming orders
        
    -   Generating and saving receipt files
        
-   Uses `Scanner` to receive user input and interacts with item classes (`Sandwich`, `Drinks`, `Chips`).
    

### `Sandwich.java`

-   Core class for sandwich creation.
    
-   Allows users to:
    
    -   Select bread and size
        
    -   Choose meat, cheese, and regular toppings
        
    -   Add sauces and sides
        
    -   Decide on toasting
        
-   Calculates price based on customizations.
    

----------

## 🍞 Other Supporting Classes

Class

Purpose

`Drinks.java`

Creates and prices drink items

`Chips.java`

Creates and prices chip items

`Bread.java`

Defines bread types and sizes, with pricing

`Toppings.java`

Abstract class or interface for toppings (base type)

`MeatToppings.java`

Handles selection of meat toppings with optional extra charges

`CheeseToppings.java`

Handles cheese options, also with extra charge logic

`RegularToppings.java`

Represents standard, free toppings like lettuce or tomato

`Sauces.java`

Represents sauces that can be added to a sandwich

`Sides.java`

Represents additional side items

----------
## Favorite piece of code
![Screenshot 2025-05-29 183300](https://github.com/user-attachments/assets/9b1ecc87-4f79-4218-a590-89008626fa77)


## 💾 Receipt Saving

When an order is placed:

-   A timestamped `.txt` file is created in the `receipts/` folder.
    
-   Receipt includes all selected items and final price.
    

----------

## 🚀 How to Run

1.  Compile the project using any Java IDE (e.g., IntelliJ) or from the terminal:
    
    bash
    
    CopyEdit
    
    `javac *.java
    java Main` 
    
2.  Follow on-screen prompts to create a new order or exit.
    
3.  Upon checkout confirmation, a receipt is saved in the `receipts` folder.
    

----------

## 📌 Features

-   Console-based interactive menu
    
-   Dynamic sandwich customization
    
-   Simple order validation and error handling
    
-   Local file receipt generation
    

----------

## ✅ Future Enhancements (Ideas)

-   Add GUI with JavaFX or Swing
    
-   Include tax calculation and payment options
    
-   Track order history across sessions
    
-   Improve input validation with enums or menu selectors
