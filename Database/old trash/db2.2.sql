
/*88888888888888
alter

		DO NOT EDIT COPY AND PASTE 

FLUSH PRIVILEGES;

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
    LicenseNumber VARCHAR(40) NOT NULL,
    Year INT DEFAULT 0,
    Make VARCHAR(20) NULL,
    Model VARCHAR(20) NULL,
    TotalMileage INT DEFAULT 0,
    AnnualMilega INT DEFAULT 0,
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
    Vin				VARCHAR(40) NOT NULL,
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
	TABLE: Join tables \/\/\/
******************************************************************************/
/******************************************************************************
	TABLE: Accident/Driver 
******************************************************************************/

CREATE TABLE AccidentDriver (
    Accident_id VARCHAR(20) NOT NULL,
    Coverage_id VARCHAR(20) NOT NULL,
    LicenseNumber VARCHAR(40) NOT NULL,
    Policy_id VARCHAR(40) NOT NULL,
    Vin VARCHAR(40) NOT NULL,
    FOREIGN KEY (Accident_id)
        REFERENCES Accident (Accident_id),
    FOREIGN KEY (Coverage_id)
        REFERENCES Coverage (Coverage_id),
    FOREIGN KEY (LicenseNumber)
    REFERENCES Driver(LicenseNumber),
    FOREIGN KEY (Policy_id)
        REFERENCES Policy (Policy_id),
    FOREIGN KEY (Vin)
        REFERENCES Vehicle (Vin)
    
);

DELIMITER $$
CREATE PROCEDURE sp_insertUsername(
	IN UserName VARCHAR(20), 
	IN PASSWORD VARCHAR(20))
BEGIN
	INSERT INTO Users(UserName,Password)
	VALUES (UserName,Password);
END $$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE sp_selectUserByUsername(
	IN UserNameP VARCHAR(20))
BEGIN
	SELECT *
    FROM Users
    WHERE UserName = UserNameP;
END $$