DELIMITER $$
Create Procedure Sp_insertCustomer(
IN UserName VARCHAR(20), 
IN Fname VARCHAR(20), 
IN Lname VARCHAR(20), 
IN Dob Date, 
IN Address VARCHAR(250),
IN Phone INT,
IN Email VARCHAR(250), 
IN Ss VARCHAR(9) )
BEGIN
INSERT INTO Customer (UserName,Fname,Lname,Dob,Address,Phone,Email,Ss) 
VALUES (UserName,Fname,Lname,Dob,Address,Phone,Email,Ss);
END$$
DELIMITER 

