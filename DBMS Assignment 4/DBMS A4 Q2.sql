#Create a Stored procedure to retrieve average sales of each product in a month.
#Month and year will be input parameter to function
DELIMITER //
CREATE PROCEDURE Avg_Sales(
    IN MONTH INT,
    IN YEAR INT
)
BEGIN
    SELECT P.Product_Id, P.Product_Name, AVG(Ordered_Product_Quantity) as Average_Sale
    FROM Ordered_Product OP
    LEFT JOIN Product P
    ON P.Product_Id = OP.Product_Id
    INNER JOIN Orders O
    ON O.Order_Id = OP.Order_Id
    WHERE MONTH(O.Order_Date) = MONTH AND YEAR(O.Order_Date) = YEAR
    GROUP BY P.Product_Id;

END//

DELIMITER ;

CALL Avg_Sales(3, 2021);


#Create a stored procedure to retrieve table having order detail with status for a given period. 
#Start date and end date will be input parameter. 
#Put validation on input dates like start date is less than end date. 
#If start date is greater than end date take first date of month as start date
DELIMITER //
CREATE PROCEDURE Order_Details(
    IN Start_Date DATE,
    IN End_Date DATE
)
BEGIN
    SET Start_Date = IF (Start_Date > End_Date, DATE_ADD(Start_Date, INTERVAL -DAY(Start_Date)+ 1 DAY), Start_Date);
    
    SELECT O.Order_Id, O.Order_Date, O.Order_Amount, O.Status
    FROM Orders O
    WHERE O.Order_Date
    BETWEEN Start_Date AND End_Date;
    
END//

DELIMITER ;
drop procedure Order_Details;
CALL Order_Details('2021-03-25','2021-03-21');
