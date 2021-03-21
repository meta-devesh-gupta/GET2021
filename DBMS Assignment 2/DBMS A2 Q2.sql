#Insert into tables
INSERT INTO Product (Product_Id, Product_Name, Product_Price, Product_Quantity, isActive, Product_Date, Product_Description)
VALUES 
(101, 'Dell Laptop', 45000, 10, 1, '2020-05-12 05:30:24', 'Dell Latitude 3410 Laptop'),
(102, 'Mouse', 500, 5, 1, '2020-04-22 12:30:21', 'It is a normal Mouse'),
(103, 'Jeans', 1000, 65, 1, '2020-06-13 00:12:26', 'It is a simple jeans'),
(104, 'Shirts', 1000, 70, 1, '2021-02-02 11:46:45', 'It is a formal shirt'),
(105, 'Couch', 25000, 10, 1, '2021-03-12 06:31:11', 'It is soft fiber couch'),
(106, 'Tables', 1000, 12, 0, '2019-12-12 05:55:43', 'It is foladable table'),
(107, 'Bed', 30000, 10, 1, '2020-12-25 14:10:12', 'It is a big size double bed'),
(108, 'Mi Mobile', 15000, 30, 1, '2018-01-02 02:44:37', 'MI A3 Smartphone'),
(109, 'Samsung Mobile', 75000, 10, 1, '2019-04-23 23:00:27', 'Samsung Galaxy A20 Plus Android Smartphone'),
(110, 'Nokia Mobile', 25000, 150, 0, '2019-11-03 05:26:36', 'Nokia Lumia 360 Windows Phone'),
(111, 'HP Laptop', 55000, 70, 1, '2021-03-18 02:33:24', 'HP Pavillion Gaming Laptop');

INSERT INTO Category (Category_Id, Parent_Category_Id, Category_Name)
VALUES
(301, null, 'Electonics'),
(302, 301, 'Laptops'),
(303, 301, 'Mobiles'),
(304, null, 'Accessories'),
(305, null, 'Cloths'), 
(306, null, 'Furnitures'),
(307, 303, 'Mobiles Below 50000'),
(308, 303, 'Mobiles Above 50000'),
(309, 305, 'Mens Cloths'),
(310, 305, 'Womens Cloths'),
(311, 304, 'Laptop Accessories');

INSERT INTO Product_Category (Product_Id, Category_Id)
VALUES
(101,302),
(102,311),
(103,309),
(103,310),
(104,309),
(104,310),
(105,306),
(106,306),
(107,306),
(108,307),
(109,308),
(110,307),
(111,302);

INSERT INTO Image (Image_Id, Product_Id, Image_Name, Image_URL)
VALUES
(501, 101, "Dell Laptop Image 1", "DLI URL 1"),
(502, 101, "Dell Laptop Image 2", "DLI URL 2"),
(503, 101, "Dell Laptop Image 3", "DLI URL 3"),
(504, 102, "Mouse Image 1", "Mouse URL 1"),
(505, 103, "Jeans Image 1", "Jeans URL 1"),
(506, 103, "Jeans Image 2", "Jeans URL 2"),
(507, 105, "Couch Image 1", "Couch URL 1"),
(508, 105, "Couch Image 2", "Couch URL 2"),
(509, 105, "Couch Image 3", "Couch URL 3"),
(510, 107, "Bed Image 1", "Bed URL 1"),
(511, 107, "Bed Image 2", "Bed URL 2"),
(512, 108, "MI Mobile Image 1", "Mi Mobile URL 1"),
(513, 108, "MI Mobile Image 2", "Mi Mobile URL 2"),
(514, 108, "MI Mobile Image 3", "Mi Mobile URL 3");

INSERT INTO User(User_Id, User_Role, First_Name, Last_Name, Contact_Number, Email, Date_Of_Birth)
VALUES
(1001, 'Administrator', 'Devesh', 'Gupta', '9373847294', 'dg@gmail.com', '2000-05-12'),
(1002, 'Shopper', 'Harshit', 'Saini', '8736492476', 'hs@gmail.com', '1999-12-23'),
(1003, 'Shopper', 'Ankit', 'Saini', '6843739264', 'as@gmail.com', '1998-03-05'),
(1004, 'Shopper', 'Gaurav', 'Tayal', '7483628462', 'gt@gmail.com', '2002-01-05'),
(1005, 'Shopper', 'Ekansh', 'Khandelwal', '7392748274', 'ek@gmail.com', '2004-09-28'),
(1006, 'Shopper', 'Bhavya', 'Modi', '9365738295', 'bm@gmail.com', '1994-06-11'),
(1007, 'Shopper', 'Naman', 'Matur', '8563956384', 'nm@gmail.com', '2000-12-01'),
(1008, 'Shopper', 'Manish', 'Gupta', '7492057203', 'mg@gmail.com', '1999-04-12'),
(1009, 'Shopper', 'Aniket', 'Jain', '6937484058', 'ak@gmail.com', '2000-10-21'),
(1010, 'Shopper', 'Nishant', 'Jain', '9374838593', 'nj@gmail.com', '1998-03-31');

INSERT INTO Address(Address_Id, User_Id, Plot_Number, Street, City, State, Country)
VALUES
(701, 1001, 123, 'Arya Nagar', 'Alwar', 'Rajasthan', 'India'),
(702, 1002, 73, 'Gandhi Nagar', 'Jaipur', 'Rajasthan', 'India'),
(703, 1002, 83, 'Suraj Nagar', 'Alwar', 'Rajasthan', 'India'),
(704, 1003, 23, 'Sector 18', 'Jaipur', 'Rajasthan', 'India'),
(705, 1004, 110, 'Ram Nagar', 'Jodhpur', 'Rajasthan', 'India'),
(706, 1005, 256, 'Sector 15', 'Udaipur', 'Rajasthan', 'India'),
(707, 1005, 543, 'Panchvati colony', 'Alwar', 'Rajasthan', 'India'),
(708, 1006, 12, 'Malakhera', 'Udaipur', 'Rajasthan', 'India'),
(709, 1007, 4, 'Street 45', 'Jodhpur', 'Rajasthan', 'India'),
(710, 1008, 87, 'Ashoka Talkies', 'Alwar', 'Rajasthan', 'India'),
(711, 1009, 12, 'Nangli Circle', 'Alwar', 'Rajasthan', 'India'),
(712, 1010, 90, 'NEB', 'Alwar', 'Rajasthan', 'India');

INSERT INTO Orders(Order_Id, User_Id, Order_Amount, Order_Date, Status)
VALUES
(2000, 1002, 1000, '2021-02-27 12:34:12', 'Delivered'),
(2001, 1002, 40000, '2021-02-28 10:24:11', 'Returned'),
(2002, 1003, 2000, '2020-04-17 01:15:12', 'Shipped'),
(2003, 1004, 30000, '2019-05-18 05:27:12', 'Shipped'),
(2004, 1004, 15000, '2021-01-01 09:45:12', 'Cancelled'),
(2005, 1007, 25000, '2021-03-16 11:02:12', 'Cancelled'),
(2006, 1002, 45500, '2021-02-13 02:30:12', 'Delivered'),
(2007, 1005, 75000, '2021-03-02 02:30:12', 'Delivered'),
(2008, 1005, 170000, '2021-02-02 22:03:21', 'Cancelled'),
(2009, 1008, 15000, '2021-03-10 20:30:21', 'Not Shipped'),
(2010, 1010, 30000, '2021-03-05 13:10:22', 'Not Shipped');

INSERT INTO Ordered_Product(Order_Id, Product_Id, Ordered_Product_Quantity, Status)
VALUES
(2000, 103, 1, 'Delivered'),
(2001, 108, 1, 'Returned'),
(2001, 110, 1, 'Returned'),
(2002, 104, 2, 'Shipped'),
(2003, 107, 1, 'Shipped'),
(2004, 108, 1, 'Cancelled'),
(2005, 105, 1, 'Cancelled'),
(2006, 101, 1, 'Not Shipped'),
(2006, 102, 1, 'Delivered'),
(2007, 110, 1, 'Delivered'),
(2008, 105, 1, 'Not Shipped'),
(2008, 108, 1, 'Shipped'),
(2008, 109, 1, 'Cancelled'),
(2008, 111, 1, 'Shipped'),
(2009, 108, 1, 'Not Shipped'),
(2010, 107, 1, 'Not Shipped');

#Display Id, Title, Category Title,Price of the products 
#which are Active and recently added products should be at top
SELECT P.Product_Id, P.Product_Name, P.Product_Price, C.Category_Name
from Product P
LEFT JOIN Product_Category PC
ON P.Product_Id=PC.Product_Id
LEFT JOIN Category C
ON PC.Category_Id=C.Category_Id WHERE P.isActive=1 Order By P.Product_Date Desc;


#Display the list of products which don't have any images.
SELECT Product_Id, Product_Name
FROM Product 
WHERE Product_Id NOT IN (SELECT Product_Id from Image);


#Display all Id, Title and Parent Category Title for all the Categories listed, 
#sorted by Parent Category Title and then Category Title
SELECT C.Category_Id, C.Category_Name, IFNULL (P.Category_Name, 'Top Category') AS Parent_Category
FROM Category C
LEFT JOIN Category P 
ON C.Parent_Category_Id = P.Category_Id 
ORDER BY P.Category_Name, C.Category_Name;

#Display Id, Title, Parent Category Title of all the leaf Categories
SELECT C.Category_Id, C.Category_Name, P.Category_Name
FROM Category C
Left Join Category P on C.Category_Id = P.Category_Id
WHERE C.Category_Id NOT IN (Select Parent_Category_Id FROM Category);

#Display Product Title, Price & Description which falls into particular category Title
SELECT P.Product_Id, P.Product_Name, P.Product_Description, P.Product_Price
FROM Product P
WHERE P.Product_Id IN 
(SELECT Product_Id FROM Product_Category WHERE Category_Id IN 
    (SELECT Category_Id 
    FROM Category
    WHERE Category_Name = 'Laptops')
);

#Display the list of Products whose Quantity on hand (Inventory) is under 50
SELECT Product_Id, Product_Name, Product_Price, Product_Quantity
FROM Product
WHERE Product_Quantity < 50;