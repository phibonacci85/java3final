DELIMITER $$
Create Procedure Sp_insertDriver(
IN Fname VARCHAR(40),
IN Lname VARCHAR(40),
IN LicenseNumber VARCHAR(40),
IN Violations VARCHAR(40),
IN Usages VARCHAR(40),
IN Accidents VARCHAR(40))
BEGIN
INSERT INTO Driver(Fname,Lname,LicenseNumber,Violations,Usages,Accidents)
VALUES (Fname,Lname,LicenseNumber,Violations,Usages,Accidents);
END$$
DELIMITER 
