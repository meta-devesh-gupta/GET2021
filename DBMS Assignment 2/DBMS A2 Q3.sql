#Display Recent 50 Orders placed
SELECT Order_Id, Order_Date, Order_Amount
FROM Orders
ORDER BY Order_DATE DESC
LIMIT 50;

#Display 10 most expensive Orders
SELECT Order_Id, Order_Date, Order_Amount
FROM Orders
ORDER BY Order_Amount DESC
LIMIT 10;

#Display all the Orders which are placed more than 10 days old 
#and one or more items from those orders are still not shipped.
SELECT O.Order_Id, O.Order_Date
FROM Orders O
INNER JOIN Ordered_Product OP
ON OP.Order_Id = O.Order_Id 
WHERE OP.Status='Not Shipped'
AND DATEDIFF(NOW(), O.Order_Date) > 10;


#Display list of shoppers which haven't ordered anything since last month.
SELECT U.User_Id, U.First_Name, U.Last_Name
FROM User U
INNER JOIN Orders O
ON U.User_Id = O.User_Id
AND U.User_Role = 'Shopper'
AND (DATEDIFF(NOW(), O.Order_Date) > 30)
GROUP BY U.User_Id;

#Display list of shopper along with orders placed by them in last 15 days
SELECT U.User_Id, U.First_Name, U.Last_Name, O.Order_Id
FROM User U
INNER JOIN Orders O
ON U.User_Id = O.User_Id
AND U.User_Role = 'Shopper'
AND (DATEDIFF(NOW(), O.Order_Date) BETWEEN 0 AND 15);


#Display list of order items which are in “shipped” state for particular Order Id
SELECT OP.Order_Id,P.Product_Id, P.Product_Name
FROM Ordered_Product OP
INNER JOIN Product P    
ON P.Product_Id = OP.Product_Id 
WHERE  OP.Order_ID = 2008  
AND OP.Status ='Shipped';


#Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price
SELECT O.Order_Id, P.Product_Name, O.Order_Date, O.Order_Amount
FROM Orders O
INNER JOIN Ordered_Product OP
ON O.Order_Id = OP.Order_ID
INNER JOIN Product P
ON P.Product_Id = OP.Product_Id 
AND (O.Order_Amount BETWEEN 20000 AND 50000);
