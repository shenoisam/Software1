/* this file contains a really stupid way to create the CSHARE database. 
*  It creates a database if the CShare database does not exists and then drops it. If you are 
*  running this in a production setting. Please do not use this script. It will delete all of your data
*  from the CShare database. 
*
*  Author: Sam Shenoi 
*  Version: 1.4
*  Date Last Modified: 4/29/2020 
*/

CREATE DATABASE IF NOT EXISTS `CShare`;
DROP DATABASE `CShare`;
Create DATABASE CSHARE; 
Use CShare; 

/* Create a user for access to the database */
Create User if not exists 'CShareAdmin'@'localhost' IDENTIFIED BY  'password';
GRANT ALL PRIVILEGES ON CShare.* TO 'CShareAdmin'@'localhost';

Create Table User(
  FirstName VARCHAR(25) NOT NULL, 
  LastName  VARCHAR(25) NOT NULL,
  Email     VARCHAR(45) NOT NULL, 
  ID        VARCHAR(25) PRIMARY KEY NOT NULL,
  Password VARCHAR(50) NOT NULL
);

Create Table Staff(
  ID VARCHAR(25) PRIMARY KEY NOT NULL,
  Title VARCHAR(25), 
  
  FOREIGN KEY (ID) REFERENCES User(ID) 
);


Create Table Doctor(
  ID VARCHAR(25) PRIMARY KEY NOT NULL, 
  Title VARCHAR(25), 

  FOREIGN KEY (ID) References User(ID) 
);

Create Table Patient(
  ID VARCHAR(25) Primary Key NOT NULL, 
  DOB Date , 
  Gender VARCHAR(25) ,
  Race VARCHAR(25), 
  Ethnicity VARCHAR(25), 
  MaritalStatus bit, 
  Foreign Key (ID) References User(ID)
);
Create Table Diagnosis(
  Name VARCHAR(25) PRIMARY KEY NOT NULL, 
  Description VARCHAR(500) NOT NULL
);
Create Table PatientDiagnosis(
  PatientID VARCHAR(25) NOT NULL, 
  DoctorID VARCHAR(25) NOT NULL, 
  Diagnosis VARCHAR(25) NOT NULL, 
  DateVal Date NOT NULL, 

  FOREIGN KEY (PatientID) REFERENCES Patient(ID),
  FOREIGN KEY (DoctorID) REFERENCES Doctor(ID),
  FOREIGN KEY (Diagnosis) REFERENCES Diagnosis(Name), 
  CONSTRAINT PatientDiagnosis_pk PRIMARY KEY (PatientID, DoctorID, Diagnosis) 
);
Create Table Appointment(
  DateVal DateTime NOT NULL, 
  DoctorID VARCHAR(25) NOT NULL, 
  PatientID VARCHAR(25) NOT NULL, 

  FOREIGN KEY (DoctorID) REFERENCES Doctor(ID),
  FOREIGN KEY (PatientID) REFERENCES Patient(ID),
  CONSTRAINT Appointment_pk PRIMARY KEY (DateVal, DoctorID, PatientID) 
);
Create Table Test(
  Name VARCHAR(25) PRIMARY KEY NOT NULL, 
  Type VARCHAR(25) NOT NULL, 
  InsuranceCode VARCHAR(25) NOT NULL

);
Create Table TestOrder(
   DoctorID VARCHAR(25) NOT NULL, 
   Test VARCHAR(25) NOT NULL, 
   DateVal Date Not NULL, 
   PatientID VARCHAR(25) NOT NULL, 
  
  FOREIGN KEY (PatientID) REFERENCES Patient(ID), 
  FOREIGN KEY (DoctorID) REFERENCES Doctor(ID), 
  FOREIGN KEY (Test) REFERENCES Test(Name),  
  CONSTRAINT TestOrder_pk PRIMARY KEY (DoctorID, PatientID, Test, DateVal) 
);
Create Table TestResult(
   Result VARCHAR(100) NOT NULL, 
   Test VARCHAR(25) NOT NULL, 
   DateVal Date Not NULL, 
   PatientID VARCHAR(25) NOT NULL, 
  
  FOREIGN KEY (PatientID) REFERENCES Patient(ID), 
  FOREIGN KEY (Test) REFERENCES Test(Name),  
  CONSTRAINT TestOrder_pk PRIMARY KEY ( PatientID, Test, DateVal) 
);
Create Table Prescription (
  Name VARCHAR(25) NOT NULL, 
  Dosage FLOAT(2) NOT NULL, 
  NumRefills int NOT NULL, 
  DateVal Date NOT NULL, 
  DoctorID VARCHAR(25) NOT NULL, 
  PatientID VARCHAR(25) NOT NULL, 
  
  FOREIGN KEY (PatientID) REFERENCES Patient(ID), 
  FOREIGN KEY (DoctorID) REFERENCES Doctor(ID), 
  CONSTRAINT Prescription_pk PRIMARY KEY (Name, Date, DoctorID, PatientID) 
);

Create Table Notes(
  DoctorID VARCHAR(25) NOT NULL, 
  PatientID VARCHAR(25) NOT NULL, 
  DateVal DateTime NOT NULL, 
  Note Varchar(500) NOT NULL,

  FOREIGN KEY (DateVal, DoctorID, PatientID) REFERENCES Appointment(DateVal, DoctorID, PatientID)  
);



/* Adding in a sample user to help with the process of viewing data and stuff. Really should do this via the GUI*/
INSERT INTO USER VALUES ("Test", "User", "testuser@test.com", "adbacubasdibcuasdc", MD5('Test'));
INSERT INTO USER VALUES ("Test1", "User1", "testuser1@test.com", "aeqwoqwoqwoqwpqpqwo", MD5('Test'));
INSERT INTO USER VALUES ("Test2", "User2", "testuser2@test.com", "pooiqwiewqiqwiqpoqwoq", MD5('Test'));

INSERT INTO Doctor VALUES("adbacubasdibcuasdc","ER Doctor"); 
INSERT INTO Staff VALUES ("aeqwoqwoqwoqwpqpqwo","Billing");
INSERT INTO PATIENT (ID) VALUES ("pooiqwiewqiqwiqpoqwoq");
INSERT INTO APPOINTMENT (DateVal, DoctorID, PatientID) VALUES (CURDATE(), "adbacubasdibcuasdc","pooiqwiewqiqwiqpoqwoq");
INSERT INTO Diagnosis (Name, Description) VALUES ("Breast Cancer", "This is a cancer affecting breast tissue");
INSERT INTO PatientDiagnosis (PatientID, DoctorID, Diagnosis,DateVal) VALUES ("pooiqwiewqiqwiqpoqwoq","adbacubasdibcuasdc", "Breast Cancer",CURDATE());




