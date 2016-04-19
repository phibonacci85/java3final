
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
	create user
******************************************************************************/

/*CREATE USER siteloginuser IDENTIFIED BY 'siteloginpassword';


/******************************************************************************
	TABLE: Accident
******************************************************************************/

CREATE TABLE Accident(

AccidentType VARCHAR(40) null,
AccidentDate DATE null,
AtFault		 BOOLEAN null 



);

/******************************************************************************
	TABLE: Coverage
******************************************************************************/

CREATE TABLE Coverage (

CoverageType	VARCHAR(60) null,
biStateMinimum	VARCHAR(20) null,
pdStateMinimum	INT DEFAULT 25 ,
MedPayOptions	INT null,
DeductibleOptions VARCHAR(20)

); 


/******************************************************************************
	TABLE: Driver
******************************************************************************/

CREATE TABLE Driver (

Fname			VARCHAR(40) null,
Lname			VARCHAR(40) null,
LicenseNumber	VARCHAR(40) null,
Violations		VARCHAR(40) null,
Usages			VARCHAR(40) null,
Accidents 		VARCHAR(40) null

);

/******************************************************************************
	TABLE: Policy
******************************************************************************/

CREATE TABLE Policy(

UserName		VARCHAR(20) null,
Name			VARCHAR(20) null,
Number			INT DEFAULT 0,
Rate			DOUBLE DEFAULT 0.0,
Vehicle			VARCHAR(20) null,
Drivers			VARCHAR(20) null


);

/******************************************************************************
	TABLE: Suspension
******************************************************************************/

CREATE TABLE Suspension(

SuspensionType		VARCHAR(20) null,
DateStart			DATE null,
DateEnd				DATE null

);

/******************************************************************************
	TABLE: User
******************************************************************************/

CREATE TABLE Users(
	UserName VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    PRIMARY KEY (UserName,Password)
    
    );

/******************************************************************************
	TABLE: Vehicle
******************************************************************************/

CREATE TABLE Vehicle(

Year			INT DEFAULT 0,
Make			VARCHAR(20) null,
Model			VARCHAR(20) null,
Vin				VARCHAR(40) null,
TotalMileage 	INT DEFAULT 0,
AnnualMilega	INT DEFAULT 0

);


/******************************************************************************
	TABLE: Violation
******************************************************************************/

CREATE TABLE Violation(

ViolationType		VARCHAR(20) null,
DateOccured			DATE null,
ConvictionDate		DATE null


);
CREATE TABLE Customer (
	UserName VARCHAR(20) NULL,
    Fname	 VARCHAR(20) NULL,
    Lname	 VARCHAR(20) NULL,
    Dob		 DATE NULL,
    Address  VARCHAR(100) NULL,
    Phone    INT NULL,
    Email	 VARCHAR(250) NULL,
    Ss		 VARCHAR(9) NULL,
    PRIMARY KEY (Fname, Lname)
    
);

CREATE TABLE Agent(
	UserName VARCHAR(20) NULL,
    Fname	 VARCHAR(20) NULL,
    Lname	 VARCHAR(20) NULL,
    Dob		 DATE,
    Address  VARCHAR(100) NULL,
    Phone    INT NULL,
    PayGrade VARCHAR(2)  NULL,
    PRIMARY KEY (Fname, Lname)


);









