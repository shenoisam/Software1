
Create Schema CShare;
Use CShare; 


Create Table User(
  FirstName VARCHAR(25) NOT NULL, 
  LastName  VARCHAR(25) NOT NULL,
  Email     VARCHAR(45) NOT NULL, 
  ID        VARCHAR(25) PRIMARY KEY NOT NULL,
  Password VARCHAR(50) NOT NULL
);

Create Table HealthCareProvider(
  ID   VARCHAR(25) PRIMARY KEY NOT NULL, 

  FOREIGN KEY (ID) References User(ID)
);
Create Table Staff(
  ID VARCHAR(25) PRIMARY KEY NOT NULL,
  Job VARCHAR(25), 
  
  FOREIGN KEY (ID) REFERENCES HealthCareProvider(ID) 
);

Create Table Doctor(
  ID VARCHAR(25) PRIMARY KEY NOT NULL, 
  Job VARCHAR(25), 

  FOREIGN KEY (ID) References HealthCareProvider(ID) 
);

Create Table Patient(
  ID VARCHAR(25) Primary Key NOT NULL, 
  DOB Date NOT NULL, 
  Gender VARCHAR(25) NOT NULL,
  Race VARCHAR(25), 
  Ethnicity VARCHAR(25), 
  MaritalStatus bit, 
  Foreign Key (ID) References User(ID)
);
Create Table Diagnosis(
  Name VARCHAR(25) PRIMARY KEY NOT NULL, 
  Description VARCHAR(100) NOT NULL
);
Create Table PatientDiagnosis(
  PatientID VARCHAR(25) NOT NULL, 
  DoctorID VARCHAR(25) NOT NULL, 
  Diagnosis VARCHAR(25) NOT NULL, 
  Date Date NOT NULL, 
  
  FOREIGN KEY (PatientID) REFERENCES Patient(ID), 
  FORIEGN KEY (DoctorID) REFERENCES Doctor(ID), 
  FORIEGN KEY (Diagnosis) REFERENCES Diagnosis(Name), 
  CONSTRAINT PatientDiagnosis_pk PRIMARY KEY (PatientID, DoctorID, Diagnosis) 
);
Create Table Appointment(
  Date Date NOT NULL, 
  DoctorID VARCHAR(25) NOT NULL, 
  PatientID VARCHAR(25) NOT NULL, 

  CONSTRAINT Appointment_pk PRIMARY KEY (Date, DoctorID, PatientID) 
);
Create Table Test(
  Name VARCHAR(25) PRIMARY KEY NOT NULL, 
  Type VARCHAR(25) NOT NULL, 
  InsuranceCode VARCHAR(25) NOT NULL,

);
Create Table TestOrder(
   DoctorID VARCHAR(25) NOT NULL, 
   Test VARCHAR(25) NOT NULL, 
   Date Date Not NULL, 
   PatientID VARCHAR(25) NOT NULL, 
  
  FOREIGN KEY (PatientID) REFERENCES Patient(ID), 
  FORIEGN KEY (DoctorID) REFERENCES Doctor(ID), 
  FOREIGN KEY (Test) REFERENCES Test(Name),  
  CONSTRAINT TestOrder_pk PRIMARY KEY (DoctorID, PatientID, Test, Date) 
);
Create Table TestResult(
   Result VARCHAR(100) NOT NULL, 
   Test VARCHAR(25) NOT NULL, 
   Date Date Not NULL, 
   PatientID VARCHAR(25) NOT NULL, 
  
  FOREIGN KEY (PatientID) REFERENCES Patient(ID), 
  FOREIGN KEY (Test) REFERENCES Test(Name),  
  CONSTRAINT TestOrder_pk PRIMARY KEY ( PatientID, Test, Date) 
);
Create Table Prescription (
  Name VARCHAR(25) NOT NULL, 
  Dosage FLOAT(2) NOT NULL, 
  NumRefills int NOT NULL, 
  Date Date NOT NULL, 
  DoctorID VARCHAR(25) NOT NULL, 
  PatientID VARCHAR(25) NOT NULL, 
  
  FOREIGN KEY (PatientID) REFERENCES Patient(ID), 
  FORIEGN KEY (DoctorID) REFERENCES Doctor(ID), 
  CONSTRAINT Prescription_pk PRIMARY KEY (Name, Date, DoctorID, PatientID) 
);

Create Table Notes(
  DoctorID VARCHAR(25) NOT NULL, 
  PatientID VARCHAR(25) NOT NULL, 
  Date Date NOT NULL, 
  Note Varchar(200) NOT NULL,

  FOREIGN KEY (Date, DoctorID, PatientID) REFERENCES Appointment(Date, DoctorID, PatientID)  
);





