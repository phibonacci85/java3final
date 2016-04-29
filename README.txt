This directory holds the files needed to run the KlutsInsurance 
WebApplication. KlutsInsurance allows a person create a user, log on 
to the site, then submit a policy with a vehicle and drivers, and view 
insurance policies. Before running this script, you must deploy the
Database, and add the necessary jar files to the netbeans project.

Product Utilized:
	- Java 1.8
	- Netbeans 8.0
	- Apache Tomcat
	- MySQL 
	- Bitbucket
	
KlutsInsurance Content:

	The Web Pages folder contains the jsp pages as well as all the
	styling that that is used for the front end Web Application. 
	
	The source code includes three packages: data, logic, and model.
	Data contains the data transfer objects. Logic code contains the 
	RequestHandler to direct the jsp with the correct objects. Model
	code contains the objects mirroring the tables in the database as
	well as the any enums relevant for fields constraints.
	
	Libraries has the Java JDK 1.8, the Apache Tomcat server, and the
	two extra jars that must be added for the program to run. These jar
	files are located outside of the netbeans project in the folder named
	jars.
	
	The Configuration Files folder holds the application xmls required
	for the project to run on the server. 

Database:	

	Outside of the netbeans project you will find the Database folder.
	This folder contains the MySQL necessary to run the application. 
	This script must be run on localhost, and can be deployed via MySQL 
	Workbench. The script, 'db3.0.3.sql', contains table creation as well 
	as stored procedures. 
	
Jar Files:

	There are two jar files that must be added to this project in the
	Netbeans Libraries folder along with the JDK and Apache Tomcat. 
	Located in the jars folder, these files are: 
		- jstl-1.2.jar
		- mysql-connector-java-5.1.38-bin.jar
		
Documentation:

	The documentation folder has our design documents for this project.

	
	


	