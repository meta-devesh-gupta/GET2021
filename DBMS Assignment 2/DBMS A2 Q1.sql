#Creating all the tables of storefront databse

#SHOW databases;
DROP DATABASE storefront;

CREATE DATABASE StoreFront;
use storefront;

CREATE TABLE Product (
    Product_Id INT NOT NULL ,
    Product_Name VARCHAR(50), 
    Product_Description VARCHAR(200),
    Product_Quantity INT,
    Product_Price INT,
    isActive TINYINT(1),
    Product_Date DATETIME,
    PRIMARY KEY(Product_Id)
);

CREATE TABLE Category (
    Category_Id INT NOT NULL ,
    Parent_Category_Id INT,
    Category_Name VARCHAR(35), 
    PRIMARY KEY(Category_Id),
    FOREIGN KEY (Parent_Category_Id) REFERENCES Category(Category_Id)
);

CREATE TABLE Product_Category (
    Product_Id INT NOT NULL ,
    Category_Id INT NOT NULL,
    PRIMARY KEY(Product_Id, Category_Id),
    FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id),
    FOREIGN KEY (Category_Id) REFERENCES Category(Category_Id)
);

CREATE TABLE Image (
    Image_Id INT NOT NULL ,
    Product_Id INT NOT NULL,
    Image_Name VARCHAR(100),
    Image_URL VARCHAR(500),
    PRIMARY KEY(Image_Id),
    FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id)
);

CREATE TABLE User (
    User_Id INT NOT NULL ,
    User_Role VARCHAR(15),
    First_Name VARCHAR(25),
    Last_Name VARCHAR(25),
    Contact_Number VARCHAR(10),
    Email VARCHAR(75),
    Date_Of_Birth DATE,
    PRIMARY KEY(User_Id)
);

CREATE TABLE Address (
    Address_Id INT NOT NULL ,
    User_Id INT NOT NULL,
    Plot_Number INT,
    Street VARCHAR(200),
    City VARCHAR(50),
    State VARCHAR(25),
    Country VARCHAR(25),
    PRIMARY KEY(Address_Id),
    FOREIGN KEY (User_Id) REFERENCES User(User_Id)
);

/*CREATE TABLE STATUS (
    Status_Id INT NOT NULL ,
    Status VARCHAR(15),
    PRIMARY KEY (Status_Id)
);*/

CREATE TABLE Orders (
    Order_Id INT NOT NULL ,
    User_Id INT NOT NULL,
    Order_Amount INT,
    Order_Date DATETIME,
    Status VARCHAR(15),
    PRIMARY KEY(Order_Id),
    FOREIGN KEY (User_Id) REFERENCES User(User_Id)
    
);

CREATE TABLE Ordered_Product (
    Order_Id INT NOT NULL ,
    Product_Id INT NOT NULL,
    Ordered_Product_Quantity INT,
    Status VARCHAR(15),
    PRIMARY KEY(Order_Id, Product_Id),
    FOREIGN KEY (Order_Id) REFERENCES Orders(Order_Id),
    FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id)
   
);


#Displaying all the tables in StoreFront database
SHOW TABLES;

#Removing product table from storefront databse
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE Product;
SET FOREIGN_KEY_CHECKS=1;

#Create Product table again
CREATE TABLE Product (
    Product_Id INT NOT NULL ,
    Product_Name VARCHAR(50), 
    Product_Description VARCHAR(200),
    Product_Quantity INT,
    Product_Price INT,
    isActive TINYINT(1),
    Product_Date DATETIME,
    PRIMARY KEY(Product_Id)
);