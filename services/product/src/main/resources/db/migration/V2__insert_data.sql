insert into category (id, name, description)
values (1, 'Electronics', 'Devices and gadgets'),
       (51, 'Books', 'Various genres of books'),
       (101, 'Clothing', 'Men and Women clothing'),
       (151, 'Home Appliances', 'Household electronic appliances'),
       (201, 'Toys', 'Toys and games for children');

insert into product (id, name, description, available_quantity, price, category_id)
values (1, 'iPhone 14', 'Latest Apple smartphone', 120, 999.99, 1),
       (51, 'Samsung TV', '55 inch 4K Smart TV', 80, 599.99, 1),
       (101, 'Atomic Habits', 'Book by James Clear', 200, 11.95, 51),
       (151, 'The Alchemist', 'Book by Paulo Coelho', 150, 9.99, 51),
       (201, 'Men''s T-Shirt', 'Cotton round neck t-shirt', 300, 19.99, 101),
       (251, 'Women''s Jeans', 'High-waist skinny jeans', 180, 39.99, 101),
       (301, 'Microwave Oven', '1000W convection microwave', 50, 129.99, 151),
       (351, 'Washing Machine', '7kg front-load washer', 30, 399.00, 151),
       (401, 'Lego Classic Set', 'Creative building blocks set', 90, 49.99, 201),
       (451, 'RC Car', 'Remote controlled racing car', 75, 59.99, 201);

