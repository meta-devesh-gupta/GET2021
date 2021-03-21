#Create a function to calculate number of orders in a month. 
#Month and year will be input parameter to function
DELIMITER //

CREATE FUNCTION Get_Number_Of_Orders(
    MONTH INT,
    YEAR INT
)

RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE Total_Orders INT;
    
    SET Total_Orders = (
        SELECT COUNT(Order_Id) AS Number_Of_Orders
        FROM Orders
        WHERE YEAR(Order_Date) = YEAR AND MONTH(Order_Date) = MONTH
    );
    
    RETURN (Total_Orders);
END//

DELIMITER ;

SELECT Get_Number_Of_Orders(3, 2021);


#Create a function to return month in a year having maximum orders.
#Year will be input parameter
DELIMITER //

CREATE FUNCTION Maximum_Order_Month(
    YEAR INT
)

RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE max_month INT;
    
    SET max_month = (
        SELECT Month
        FROM(
                SELECT MONTH(Order_Date) AS Month, COUNT(Order_Id) AS Number_Of_Orders
                FROM Orders
                WHERE YEAR(Order_Date) = YEAR
                GROUP BY MONTH(Order_Date)
                ORDER BY Month DESC
                LIMIT 1
            ) AS T
    );
    
    RETURN (max_month);
END//

DELIMITER ;

SELECT Maximum_Order_Month(2021);