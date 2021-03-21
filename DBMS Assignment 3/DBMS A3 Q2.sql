#Display the list of products (Id, Title, Count of Categories) which
#fall in more than one Categories
SELECT P.Product_Id, P.Product_Name, COUNT(PC.Category_Id) as Category_Count
FROM Product P
INNER JOIN Product_Category PC
ON P.Product_Id = PC.Product_Id
GROUP BY P.Product_Id
HAVING COUNT(PC.Category_Id) > 1;

#Display Count of products 
SELECT Count(Product_Id) AS '0-10000' 
FROM Product 
WHERE Product_Price BETWEEN 0 AND 10000;

SELECT Count(Product_Id) AS '10000-50000' 
FROM Product 
WHERE Product_Price BETWEEN 10000 AND 50000;

SELECT Count(Product_Id) AS 'Above 50000' 
FROM Product WHERE Product_Price > 50000;


#Display the Categories along with number of products under each category
SELECT PC.Category_Id, C.Category_Name, COUNT(PC.Product_Id) as Total_Products
FROM Product_Category PC
LEFT JOIN Category C 
ON C.Category_Id = PC.Category_Id 
GROUP BY PC.Category_Id;
