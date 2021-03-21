#Create a view displaying the order information
#(Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
#with latest ordered items should be displayed first for last 60 days

CREATE VIEW OrderInformation
AS
    SELECT O.Order_Id, P.Product_Name, P.Product_Price, U.First_Name, U.Last_Name,
            U.Email, O.Order_Date, OP.Status
    FROM Orders O
    LEFT JOIN Ordered_Product OP
    ON OP.Order_Id = O.Order_Id
    INNER JOIN Product P
    ON P.Product_Id  = OP.Product_Id
    INNER JOIN User U
    ON U.User_Id = O.User_Id
    WHERE DATEDIFF(NOW(), O.Order_Date) < 60
    ORDER BY O.Order_Date DESC;
    
SELECT * FROM OrderInformation;

#Use the above view to display the Products(Items) which are in ‘shipped’ state
SELECT Order_Id, Product_Name, Product_Price, Status
FROM OrderInformation
WHERE Status = 'Shipped';

#Use the above view to display the top 5 most selling products
SELECT Product_Name, COUNT(Product_Name) 
FROM OrderInformation
GROUP BY Product_Name
ORDER BY COUNT(Product_Name) DESC
LIMIT 5;