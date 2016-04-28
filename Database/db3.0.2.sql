
/*88888888888888

CLAYTON KNIGHT

		DO NOT EDIT COPY AND PASTE 
        
        
this file will create the data base use for our insuance application.
it already adds the need stored procedures for insert and Fselect.





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
    LicenseNumber VARCHAR(40) NOT NULL,
    Fname VARCHAR(40) NOT NULL,
    Lname VARCHAR(40) NOT NULL,
    Useages VARCHAR(40) NOT NULL,
    DOB DATE,
    PRIMARY KEY (LicenseNumber)
);

INSERT INTO Driver(LicenseNumber,Fname,Lname,Useages,DOB)
VALUES
('444aa8888','firstname1','lastname1','SCHOOL','1999-01-01'),
('333bb8888','firstname2','lastname2','WORK','1999-02-02');


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
INSERT INTO Users (userName,Password) 
VALUES 
('cknight','password1'),
('snake19','password2'),
('Phibonacci85','password3'),
('t_determann','password4'),
('cust001','password5'),
('cust002','password6');


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
    AnnualMileage INT DEFAULT 0,
    PRIMARY KEY (Vin),
    FOREIGN KEY (LicenseNumber) 
		REFERENCES Driver(LicenseNumber)
);

INSERT INTO Vehicle(Vin,LicenseNumber,Year,Make,Model,TotalMileage,AnnualMileage)
VALUES('ljcpcblcx11000237','444aa8888','2010','Ford','Escape','980000','5000'),
('fakevinexample','333bb8888','2015','Honda','civic','25000','5000');


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
INSERT INTO Customer(userName,Fname,Lname,Dob,Address,phone,email,Ss) 
VALUES 
('cust001','firstname','lastname','1999-01-01','01  fake street IA','1118885555','fakeeamil1@yahoo.com','333224444'),
('cust002','firstname2','lastname2','1999-02-02','02 fake street IA','1113334444','fakeeamil2@yahoo.com','111223333');

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
INSERT INTO agent (userName,Fname,Lname,DOB,Address,phone,paygrade) 
VALUES 
('cknight','clay','knight','1999-09-09','2000 Fake Address Lane, IA 52240 ','1112223333','a1'),
('snake19','sara','n','1999-09-09','2000 Fake Address Lane, IA 52240 ','1112223333','a1'),
('Phibonacci85','john','baker','1999-09-09','2000 Fake Address Lane, IA 52240 ','1112223333','a1'),
('t_determann','teresa','determann','1999-09-09','2000 Fake Address Lane, IA 52240 ','1112223333','a1');



/******************************************************************************
	TABLE: Coverage
******************************************************************************/

CREATE TABLE Coverage (
	Coverage_id int NOT NULL AUTO_INCREMENT,
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
	Policy_id int NOT NULL AUTO_INCREMENT,
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
INSERT INTO Policy(UserName,Vin,Name,Rate)
VALUES ('cust001','fakevinexample','','0.0'),
('cust002','ljcpcblcx11000237','','0.0');


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
IN LicenseNumber VARCHAR(40),
IN Fname VARCHAR(40),
IN Lname VARCHAR(40),
IN Usages VARCHAR(40),
IN DOB DATE)
BEGIN
INSERT INTO Driver(LicenseNumber,Fname,Lname,Usages,DOB)
VALUES (LicenseNumber,Fname,Lname,Usages,DOB);
END$$
DELIMITER 

DELIMITER $$
Create Procedure sp_insertDriverBasic(
IN LicenseNumber VARCHAR(40),
IN Fname VARCHAR(40),
IN Lname VARCHAR(40),
IN Age	INT,
IN Usages VARCHAR(40))
BEGIN
INSERT INTO Driver(Fname,Lname,LicenseNumber,Age,Usages)
VALUES (Fname,Lname,LicenseNumber,Age,Usages);
END$$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: Policy
******************************************************************************/
DELIMITER $$
Create Procedure sp_insertPolicy(
IN UserName VARCHAR(20), 
IN Vin VARCHAR(40), 
IN Name VARCHAR(20), 
IN Rate DOUBLE )
BEGIN
INSERT INTO policy (UserName,Vin,Name,Rate) 
VALUES (UserName,Vin,Name,Rate);
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
IN AnnualMileage INT   )
BEGIN
INSERT INTO Vehicle (LicenseNumber,Vin,Year,Make,Model,TotalMileage,AnnualMileage) 
VALUES (LicenseNumber,Vin,Year,Make,Model,TotalMileage,AnnualMileage) ;
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

DELIMITER $$
CREATE PROCEDURE sp_selectAccidentByAccidentId
( in accidentIdP int)

BEGIN
  SELECT * FROM Accidents
  WHERE AccidentId = accidentIdP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectAccidentsByLicenseNumber
( in licenseNumberP int)

BEGIN
  SELECT * FROM Accidents
  WHERE LicenseNumber = licenseNumberP;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: agent
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectAgents
()
BEGIN
  SELECT * FROM Agent;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectAgentByUserName
(IN userNameP VARCHAR(20))
BEGIN
  SELECT * FROM Agent
  WHERE UserName = userNameP;
END $$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: coverage
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectCoverageByCoverageId
(IN coverageIdP int)
BEGIN
  SELECT * FROM coverage
  WHERE CoverageId = coverageIdP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectCoverageByUserName
(IN UserNameP VARCHAR(20))
BEGIN
  SELECT * FROM coverage
  WHERE UserName = UserNameP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectCoverages
()
BEGIN
  SELECT * FROM coverage;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: customer
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectCustomers
()
BEGIN
  SELECT * FROM Customer;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectCustomerByUserName
(IN userNameP VARCHAR(20))
BEGIN
  SELECT * FROM Customer
  WHERE UserName = userNameP;
END $$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: driver
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectDriverByLicenseNumber
(IN licenseNumberP VARCHAR(40))
BEGIN
  SELECT * FROM driver
  WHERE LicenseNumber = licenseNumberP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectDrivers
()
BEGIN
  SELECT * FROM driver;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectDriversByVin
(IN vinP VARCHAR(40))
BEGIN
  SELECT * FROM driver
  WHERE vin = vinP;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: Polices
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectPolicies
()
BEGIN
  SELECT * FROM policy;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectPoliciesByPolicyId
(IN PolicyIdP int)
BEGIN
  SELECT * FROM policy
  WHERE PolicyId = PolicyIdP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectPoliciesByUserName
(IN UserNameP VARCHAR(20))
BEGIN
  SELECT * FROM policy
  WHERE UserName = UserNameP;
END $$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: suspensions
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectSuspensionBySuspensionId
(IN suspensionIdP int)
BEGIN
  SELECT * FROM violation
  WHERE suspensionId = suspensionIdP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectSuspensionsByUsername
(IN usernameP int)
BEGIN
  SELECT * FROM violation
  WHERE username = usernameP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectSuspensions
()
BEGIN
  SELECT * FROM violation;
END $$
DELIMITER 


/******************************************************************************
	STORED PROCEDURE: Users
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectUsers
()
BEGIN
  SELECT * FROM Users;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectUserByUserName
(IN userNameP VARCHAR(20))
BEGIN
  SELECT * FROM Users
  WHERE UserName = userNameP;
END $$
DELIMITER 
/******************************************************************************
	STORED PROCEDURE: vehicle
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectVehicles
()
BEGIN
  SELECT * FROM vehicle;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectVehicleByUserName
(IN UserNameP VARCHAR(20))
BEGIN
  SELECT * FROM vehicle
  WHERE UserName = UserNameP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectVehicleByVin
(IN VinP int)
BEGIN
  SELECT * FROM vehicle
  WHERE vin = VinP;
END $$
DELIMITER 

/******************************************************************************
	STORED PROCEDURE: violations
******************************************************************************/
DELIMITER $$
CREATE PROCEDURE sp_selectViolationsByLiscenseNumber
(IN liscenseNumberP VARCHAR(40))
BEGIN
  SELECT * FROM violation
  WHERE LicenseNumber = licenseNumberP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectViolationByViolationID
(IN violationIdP int)
BEGIN
  SELECT * FROM violation
  WHERE violationId = violationIdP;
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE sp_selectViolations
()
BEGIN
  SELECT * FROM violation;
END $$










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