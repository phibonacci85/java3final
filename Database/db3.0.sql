
/*88888888888888

CLAYTON KNIGHT

		DO NOT EDIT COPY AND PASTE 
        
        
this file will create the data base use for our insuance application.
it already adds the need stored procedures for insert and select.





/******************************************************************************
	Remove the database, if it exists
******************************************************************************/
DROP DATABASE IF EXISTS J3Project2;

/******************************************************************************
	Create the database
******************************************************************************/
CREATE DATABASE  J3Project2;


/******************************************************************************
	Specify the database to use
******************************************************************************/
USE J3Project2;


/******************************************************************************
	TABLE: Driver
******************************************************************************/

CREATE TABLE Driver (
    Fname VARCHAR(40) NOT NULL,
    Lname VARCHAR(40) NOT NULL,
    Age	INT ,
    LicenseNumber VARCHAR(40) NOT NULL,
    Violations VARCHAR(40) NULL,
    Usages VARCHAR(40) NULL,
    Accidents VARCHAR(40) NULL,
    PRIMARY KEY (LicenseNumber)
);


/******************************************************************************
	TABLE: Suspension
******************************************************************************/

CREATE TABLE Suspension (
	Suspension_id INT NOT NULL,
    LicenseNumber VARCHAR(40) NOT NULL,
    SuspensionType VARCHAR(20) NULL,
    DateStart DATE NULL,
    DateEnd DATE NULL,
    PRIMARY KEY(Suspension_id),
    FOREIGN KEY (LicenseNumber) 
		REFERENCES Driver(LicenseNumber)
    
);

/******************************************************************************
	TABLE: User
******************************************************************************/

CREATE TABLE Users (
    UserName VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    PRIMARY KEY (UserName )
);

/******************************************************************************
	TABLE: Vehicle
******************************************************************************/

CREATE TABLE Vehicle (
	Vin VARCHAR(40) NOT NULL,
    LicenseNumber VARCHAR(40)NULL,
    Year INT DEFAULT 0,
    Make VARCHAR(20) NULL,
    Model VARCHAR(20) NULL,
    TotalMileage INT DEFAULT 0,
    AnnualMilege INT DEFAULT 0,
    PRIMARY KEY (Vin),
    FOREIGN KEY (LicenseNumber) 
		REFERENCES Driver(LicenseNumber)
);


/******************************************************************************
	TABLE: Violation
******************************************************************************/

CREATE TABLE Violation (
	Violation_id VARCHAR(40) NOT NULL,
    LicenseNumber VARCHAR(40) NOT NULL,
    ViolationType VARCHAR(20) NULL,
    DateOccured DATE NULL,
    ConvictionDate DATE NULL,
    PRIMARY KEY (Violation_id),
    FOREIGN KEY (LicenseNumber) 
		REFERENCES Driver(LicenseNumber)
    
);
/******************************************************************************
	TABLE: Customer
******************************************************************************/

CREATE TABLE Customer (
    UserName VARCHAR(20) NOT NULL,
    Fname VARCHAR(20) NULL,
    Lname VARCHAR(20) NULL,
    Dob DATE NULL,
    Address VARCHAR(100) NULL,
    Phone INT NULL,
    Email VARCHAR(250) NULL,
    Ss VARCHAR(9) NULL,
    FOREIGN KEY (UserName)
        REFERENCES Users (UserName)
);
/******************************************************************************
	TABLE: Agent
******************************************************************************/

CREATE TABLE Agent (
    UserName VARCHAR(20) NOT NULL,
    Fname VARCHAR(20) NOT NULL,
    Lname VARCHAR(20) NOT NULL,
    Dob DATE,
    Address VARCHAR(100) NULL,
    Phone INT NULL,
    PayGrade VARCHAR(2) NULL,
    PRIMARY KEY (UserName),
    FOREIGN KEY (UserName)
        REFERENCES Users (UserName)
);


/******************************************************************************
	TABLE: Coverage
******************************************************************************/

CREATE TABLE Coverage (
	Coverage_id VARCHAR(20) NOT NULL,
    UserName VARCHAR(20) NOT NULL,
    CoverageType VARCHAR(60) NULL,
    biStateMinimum VARCHAR(20) NULL,
    pdStateMinimum INT DEFAULT 25,
    MedPayOptions INT NULL,
    DeductibleOptions VARCHAR(20),
    PRIMARY KEY(Coverage_id),
    FOREIGN KEY(UserName) REFERENCES Users (UserName)
    
);


/******************************************************************************
	Table : Accident
******************************************************************************/

CREATE TABLE Accident (
	Accident_id VARCHAR(20) NOT NULL,
    LicenseNumber VARCHAR(40) NOT NULL,
    Vin				VARCHAR(40) NULL,
    AccidentType VARCHAR(40) NULL,
    AccidentDate DATE NULL,
    AtFault BOOLEAN NULL,
    PRIMARY KEY (Accident_id),
    FOREIGN KEY (LicenseNumber) 
		REFERENCES Driver(LicenseNumber),
	FOREIGN KEY (Vin) 
		REFERENCES Vehicle(Vin)
    
);



/******************************************************************************
	TABLE: Policy
******************************************************************************/

CREATE TABLE Policy (
	Policy_id	VARCHAR(40) NOT NULL,
    UserName VARCHAR(20) NOT NULL,
    Vin VARCHAR(40) NOT NULL,
    Name VARCHAR(20) NULL,
    Rate DOUBLE DEFAULT 0.0,
    PRIMARY KEY (Policy_id),
    FOREIGN KEY (UserName)
        REFERENCES Users (UserName),
	FOREIGN KEY (Vin) 
		REFERENCES Vehicle(Vin)
	
    
    
);

/******************************************************************************
	STORED PROCEDURES <><><>\/\/\/
******************************************************************************/
/******************************************************************************
	STORED PROCEDURES inserts
******************************************************************************/
/******************************************************************************
	STORED PROCEDURE: ACCIDENT
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertAccident(
IN Accident_id VARCHAR(20),
IN LicenseNumber VARCHAR(40),
IN Vin	VARCHAR(40),
IN AccidentType VARCHAR(20),
IN AccidentDate DATE,
IN AtFault Boolean  )
BEGIN
INSERT INTO Accident (Accident_id,Vin,LicenseNumber,AccidentType,AccidentDate,AtFault)
VALUES  (Accident_id,Vin,LicenseNumber,AccidentType,AccidentDate,AtFault);
END$$

/******************************************************************************
	STORED PROCEDURE: AGENT
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertAgent(
IN UserName VARCHAR(20), 
IN Fname VARCHAR(20), 
IN Lname VARCHAR(20), 
IN Dob Date, 
IN Address VARCHAR(250),
IN Phone INT,
IN PayGrade VARCHAR(2) )
BEGIN
INSERT INTO Agent (UserName,Fname,Lname,Dob,Address,Phone,PayGrade) 
VALUES (UserName,Fname,Lname,Dob,Address,Phone,PayGrade);
END$$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: COVERAGE
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertCoverage(
IN Coverage_id VARCHAR(20),
IN UserName VARCHAR(20),
IN CoverageType VARCHAR(60),
IN biStateMinimum VARCHAR(20),
IN pdStateMinimum INT,
IN MedPayOptions INT,
IN DeductibleOptions VARCHAR(20)  )
BEGIN
INSERT INTO Coverage (Coverage_id,UserName,CoverageType,biStateMinimum,pdStateMinimum,MedPayOptions,DeductibleOption) 
VALUES (Coverage_id,UserName,CoverageType,biStateMinimum,pdStateMinimum,MedPayOptions,DeductibleOption) ;
END$$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: CUSTOMER
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertCustomer(
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

/******************************************************************************
	STORED PROCEDURE: DRIVER
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertDriver(
IN Fname VARCHAR(40),
IN Lname VARCHAR(40),
IN Age INT,
IN LicenseNumber VARCHAR(40),
IN Violations VARCHAR(40),
IN Usages VARCHAR(40),
IN Accidents VARCHAR(40))
BEGIN
INSERT INTO Driver(Fname,Lname,Age,LicenseNumber,Violations,Usages,Accidents)
VALUES (Fname,Lname,Age,LicenseNumber,Violations,Usages,Accidents);
END$$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: Policy
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertPolicy(
IN Policy_id VARCHAR(20),
IN UserName VARCHAR(20), 
IN Vin VARCHAR(40), 
IN Name VARCHAR(20), 
IN Rate DOUBLE )
BEGIN
INSERT INTO policy (Policy_id,UserName,Vin,Name,Rate) 
VALUES (Policy_id,UserName,Vin,Name,Rate);
END$$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: Suspension
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertSuspension(
IN Suspension_id INT,
IN LicenseNumber VARCHAR(40),
IN SuspensionType	VARCHAR(20),
IN StartDate DATE,
IN EndDate DATE  )
BEGIN
INSERT INTO Suspension(Suspension_id, LicenseNumber, SuspensionType,StartDate,EndDate)
VALUES (Suspension_id, LicenseNumber, SuspensionType,StartDate,EndDate);
END$$
/******************************************************************************
	STORED PROCEDURE: Users
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertUserName(
IN UserName VARCHAR(20), 
IN PASSWORD VARCHAR(20))
BEGIN
INSERT INTO Users(UserName,Password)
VALUES (UserName,Password);
END$$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: Vehicle
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertVehicle(
IN licenseNumber VARCHAR(40),
IN Vin VARCHAR(40), 
IN Year INT,
IN Make VARCHAR(20), 
IN Model VARCHAR(20),
IN TotalMileage INT,
IN AnnuallMileage INT   )
BEGIN
INSERT INTO Vehicle (LicenseNumber,Vin,Year,Make,Model,TotalMileage,AnnualMilege) 
VALUES (LicenseNumber,Vin,Year,Make,Model,TotalMileage,AnnualMilege) ;
END$$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: Violation
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertViolation(
IN Violation_id VARCHAR(40),
IN LicenseNumber VARCHAR(40),
IN ViolationType VARCHAR(20),
IN DateOccured DATE,
IN ConvictionDate DATE  )
BEGIN
INSERT INTO violation (Violation_id,LicenseNumber,ViolationType,DateOccured,ConvictionDate)
VALUES (Violation_id,LicenseNumber,ViolationType,DateOccured,ConvictionDate) ;
END$$

/******************************************************************************
	STORED PROCEDURES selects
******************************************************************************/
/******************************************************************************
	STORED PROCEDURE: Accidents
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectAccidents()

BEGIN
  SELECT * FROM Accidents;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: agent
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectAgentByUserName
(IN userName VARCHAR(20))
BEGIN
  SELECT * FROM Agent
  WHERE UserName = userName;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: coverage
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectCoverageByUserName
(IN UserName VARCHAR(20))
BEGIN
  SELECT * FROM coverage
  WHERE UserName = UserName;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: customer
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectCustomerByUserName
(IN userName VARCHAR(20))
BEGIN
  SELECT * FROM Customer
  WHERE UserName = userName;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: driver
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectDriverByLicencseNumber
(IN licenseNumber VARCHAR(40))
BEGIN
  SELECT * FROM driver
  WHERE LicenseNumber = licenseNumber;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: Polices
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectPoliciesByUserName
(IN UserName VARCHAR(20))
BEGIN
  SELECT * FROM policy
  WHERE UserName = UserName;
END $$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: Users
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectUserByUserName
(IN userName VARCHAR(20))
BEGIN
  SELECT * FROM Users
  WHERE UserName = userName;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: vehicle
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectVehicleByUserName
(IN UserName VARCHAR(20))
BEGIN
  SELECT * FROM vehicle
  WHERE UserName = UserName;
END $$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: violations
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectViolationsByLiscenseNumber
(IN liscenseNumber VARCHAR(40))
BEGIN
  SELECT * FROM violation
  WHERE LicenseNumber = licenseNumber;
END $$
DELIMITER 











/******************************************************************************
	TABLE: Join tables \/\/\/
******************************************************************************/
/******************************************************************************
	TABLE: Accident/Driver 
******************************************************************************/

-- CREATE TABLE AccidentDriver (
--     Accident_id VARCHAR(20) NOT NULL,
--     Coverage_id VARCHAR(20) NOT NULL,
--     LicenseNumber VARCHAR(40) NOT NULL,
--     Policy_id VARCHAR(40) NOT NULL,
--     Vin VARCHAR(40) NOT NULL,
--     FOREIGN KEY (Accident_id)
--         REFERENCES Accident (Accident_id),
--     FOREIGN KEY (Coverage_id)
--         REFERENCES Coverage (Coverage_id),
--     FOREIGN KEY (LicenseNumber)
--     REFERENCES Driver(LicenseNumber),
--     FOREIGN KEY (Policy_id)
--         REFERENCES Policy (Policy_id),
--     FOREIGN KEY (Vin)
--         REFERENCES Vehicle (Vin)
--     
-- );
-- 