#Display Shopper’s information along with number of orders 
#he/she placed during last 30 days
SELECT U.User_Id, COUNT(O.Order_Id) AS Order_Count, U.First_Name, U.Last_Name
FROM User U
LEFT JOIN Orders O
ON U.User_Id = O.User_Id
WHERE U.User_Role = 'Shopper' AND DATEDIFF(NOW(), O.Order_Date) < 30
GROUP BY U.User_Id;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days
SELECT O.User_Id, U.First_Name, U.Last_Name, SUM(O.Order_Amount) AS Total_Amount
FROM Orders O
INNER JOIN User U
ON O.User_Id = U.User_Id
WHERE U.User_Role = 'Shopper'AND DATEDIFF(NOW(), O.Order_Date) < 30
GROUP BY O.User_Id
ORDER BY Total_Amount DESC
LIMIT 10;


#Display top 20 Products which are ordered most in last 60 days along with numbers
SELECT P.Product_Id, P.Product_Name, COUNT(OP.Product_Id) as Product_Count
FROM Product P
INNER JOIN Ordered_Product OP
ON P.Product_Id = OP.Product_Id
INNER JOIN Orders O
ON O.Order_Id = OP.Order_Id
WHERE DATEDIFF(NOW(),O.Order_Date) < 60
GROUP BY OP.Product_Id
ORDER BY Product_Count DESC
LIMIT 20;


#Display Monthly sales revenue of the StoreFront for last 6 months. 
#It should display each month’s sale
SELECT SUM(O.Order_Amount) AS Total_Revenue, 
PERIOD_DIFF(DATE_FORMAT(NOW(), '%Y%m'), DATE_FORMAT(O.Order_Date, '%Y%m')) AS MONTH
from Orders O
WHERE  PERIOD_DIFF(DATE_FORMAT(NOW(), '%Y%m'), DATE_FORMAT(O.Order_Date, '%Y%m')) < 6
GROUP BY MONTH;


#Mark the products as Inactive which are not ordered in last 90 days
SET SQL_SAFE_UPDATES=0;

UPDATE Product
SET isActive = 0
WHERE Product_Id NOT IN (
    SELECT OP.Product_Id
    FROM Orders O
    INNER JOIN Ordered_Product OP
    ON OP.Order_Id = O.Order_Id
    WHERE DATEDIFF(NOW(), O.Order_Date) < 90
    GROUP BY OP.Product_Id
);

SET SQL_SAFE_UPDATES=1;


#Given a category search keyword, display all the Products present in this category/categories
SELECT P.Product_Id, P.Product_Name
FROM Product P
INNER JOIN Product_Category PC
ON PC.Product_Id = P.Product_Id
WHERE PC.Category_Id IN (
    SELECT Category_Id
    FROM Category
    WHERE Category_Name LIKE 'lap%'
);

#Display top 10 Items which were cancelled most
SELECT P.Product_Id, P.Product_Name, OP.Status
FROM Product P
INNER JOIN Ordered_Product OP
ON OP.Product_Id = P.Product_Id
WHERE OP.Status ='Cancelled'
LIMIT 10;

