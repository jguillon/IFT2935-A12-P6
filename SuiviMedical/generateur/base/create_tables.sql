
/*
  TODO:
  Corriger disparites entre le code genere et le diag ER (Diagramme_E-R_v2.0.pdf) p/r aux attributs:
  - le diag connect ACTION a PERSON, le code reference un docteur
  - le diag contient les attrs {ActionNo, Date, Type, Role, EventNo} vs le code qui donne plus bas
*/
CREATE TABLE Action (
       ActionNo   INTEGER     NOT NULL,
       EventNo    INTEGER     NOT NULL,
       DoctorNo   INTEGER     NOT NULL,
       ActionDate DATE        NOT NULL,
       Descr      VARCHAR(50) NOT NULL,
       PRIMARY KEY (ActionNo),
       FOREIGN KEY (EventNo) REFERENCES Event(EventNo),
       FOREIGN KEY (DoctorNo) REFERENCES Doctor(DoctorNo)
);


/*
  TODO:
  Question: le diag ER contient une entite Pharmacy mais on n'a pas de table correspondant, que fait-on?
*/
CREATE TABLE Command (
       PrescriptionNo INTEGER NOT NULL,
       PharmacyNo     INTEGER NOT NULL,
       commandDate    TEXT,
       PRIMARY KEY (PrescriptionNo, PharmacyNo)
);

CREATE TABLE Dependance (
       DependantNo VARCHAR(12) NOT NULL,
       PatientNo   VARCHAR(12) NOT NULL,
       Relation    VARCHAR(15) NOT NULL,
       PRIMARY KEY (DependantNo),
       FOREIGN KEY (PatientNo) REFERENCES Patient(PatientNo)
);

CREATE TABLE Dependant (
       DependantNo INTEGER     NOT NULL,
       PatientNo   VARCHAR(12) NOT NULL,
       PRIMARY KEY (DependantNo),
       FOREIGN KEY (PatientNo) REFERENCES Patient(PatientNo)
);


CREATE TABLE Diagnosis (
       DiagnosisNo INTEGER     NOT NULL,
       EventNo     INTEGER     NOT NULL,
       DoctorNo    INTEGER     NOT NULL,
       DiagDate    DATE        NOT NULL,
       Descr       VARCHAR(50) NOT NULL,
       PRIMARY KEY (DiagnosisNo),
       FOREIGN KEY (EventNo)  REFERENCES Event(EventNo),
       FOREIGN KEY (DoctorNo) REFERENCES Doctor(DoctorNo)
);

CREATE TABLE Doctor (
       DoctorNo   INTEGER     NOT NULL,
       NoAss      VARCHAR(12) NOT NULL,
       Speciality VARCHAR(30) NOT NULL,
       PRIMARY KEY (DoctorNo),
       FOREIGN KEY (NoAss) REFERENCES Person(NoAss)
);

CREATE TABLE Dossier (
       DossierNo INTEGER     NOT NULL,
       NoAss     VARCHAR(12) NOT NULL,
       PRIMARY KEY (DossierNo),
       FOREIGN KEY (NoAss) REFERENCES Patient(NoAss)
);

CREATE TABLE Event(
       EventNo   INTEGER NOT NULL,
       DossierNo INTEGER NOT NULL,
       OpenDate  DATE    NOT NULL,
       CloseDate DATE,
       Descr     VARCHAR(50) NOT NULL,
       PRIMARY KEY (EventNo),
       FOREIGN KEY (DossierNo) REFERENCES Dossier(DossierNo)
);

CREATE TABLE Nurse (
       NurseNo   INTEGER     NOT NULL,
       NoAss     VARCHAR(12) NOT NULL,
       PRIMARY KEY (NurseNo),
       FOREIGN KEY (NoAss) REFERENCES Person(NoAss)
);

CREATE TABLE Patient (
       PatientNo   INTEGER NOT NULL,
       NoAss       VARCHAR(12) NOT NULL,
       PatientType TEXT NOT NULL,
       PRIMARY KEY (PatientNo),
       FOREIGN KEY (NoAss) REFERENCES Person(NoAss)
);

/*
  TODO:
  Le diag ER ne contient pas Person.NoAss et Person.telno; corriger un ou l'autre
*/
CREATE TABLE Person (
       NoAss    VARCHAR(12) NOT NULL,
       fName    VARCHAR(20) NOT NULL,
       mName    VARCHAR(20),
       lName    VARCHAR(50) NOT NULL,
       bDate    DATE        NOT NULL,
       sex      CHAR        NOT NULL,
       streetNo INTEGER     NOT NULL,
       street   VARCHAR(30) NOT NULL,
       appt     INTEGER,
       city     VARCHAR(20) NOT NULL,
       province VARCHAR(20) NOT NULL,
       pc       VARCHAR(6)  NOT NULL,
       country  VARCHAR(50) NOT NULL,
       telno    VARCHAR(10),
       email    TEXT,
       PRIMARY KEY (NoAss)
);

CREATE TABLE Prescription (
       PrescriptionNo INTEGER NOT NULL,
       EventNo        INTEGER NOT NULL,
       DoctorNo       INTEGER NOT NULL,
       PrescDate      TEXT,
       DrugName       VARCHAR(25) NOT NULL,
       Qty            VARCHAR(10) NOT NULL,
       Frequency      VARCHAR(25) NOT NULL,
       Timebase       VARCHAR(25) NOT NULL,
       PRIMARY KEY (PrescriptionNo),
       FOREIGN KEY (EventNo) REFERENCES Event(EventNo),
       FOREIGN KEY (DoctorNo) REFERENCES Doctor(DoctorNo)
);

CREATE TABLE Report (
       ReportNo   INTEGER NOT NULL,
       EventNo    INTEGER NOT NULL,
       ReportSrc  TEXT    NOT NULL,
       ReportDate DATE    NOT NULL,
       Descr      TEXT,
       url        TEXT,
       PRIMARY KEY (ReportNo)
);

CREATE TABLE Role (
       NoAss      VARCHAR(12) NOT NULL,
       PersonRole VARCHAR(12) NOT NULL,
       PRIMARY KEY (NoAss)
);

CREATE TABLE Statut (
       StatusNo   INTEGER     NOT NULL,
       EventNo    INTEGER     NOT NULL,
       Timestmp   DATE        NOT NULL,
       StatusType VARCHAR(25) NOT NULL,
       Val        INTEGER     NOT NULL,
       PRIMARY KEY (StatusNo),
       FOREIGN KEY (EventNo) REFERENCES Event(EventNo)       
);
