#Identify the columns require indexing in 
#order, product, category tables and create indexes

CREATE INDEX idx_order_id_order_date
ON Orders(Order_Id, Order_Date);

CREATE INDEX idx_product_id
ON Product(Product_Id);

CREATE INDEX idx_category_id
ON Category(Category_Id);