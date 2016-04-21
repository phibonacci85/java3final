DELIMITER $$
Create Procedure Sp_insertUserName(
IN UserName VARCHAR(20), 
IN PASSWORD VARCHAR(20))
BEGIN
INSERT INTO Users(UserName,Password)
VALUES (UserName,Password);
END$$
DELIMITER 
 