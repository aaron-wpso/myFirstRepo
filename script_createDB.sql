Drop database dbAttendance;

CREATE database dbAttendance;

CREATE TABLE dbAttendance.Course
(
	courseID int auto_increment,
	cName varchar(50),

	PRIMARY KEY(courseID)
);

CREATE TABLE dbAttendance.Module
(
	moduleID int auto_increment, 
	modName varchar(50),
	modDesc varchar(8000),
	courseID int,

	PRIMARY KEY(moduleID),
    FOREIGN KEY (courseID) REFERENCES dbAttendance.Course(courseID)
);


CREATE TABLE dbAttendance.Module_Intake
(
	moduleID int,
	intakeID int,
	
	CONSTRAINT PK_Person PRIMARY KEY(moduleID, intakeID)
	/*FOREIGN KEY(moduleID) REFERENCES dbAttendance.Module(moduleID),
	FOREIGN KEY(intakeID) REFERENCES dbAttendance.Intake(intakeID)*/
);

CREATE TABLE dbAttendance.Intake
(
	intakeID int auto_increment,
    intakeDesc varchar(50),
	studentID int,

	PRIMARY KEY(intakeID)
	/*FOREIGN KEY(studentID) REFERENCES Student(studentID)*/
);
 
 ALTER TABLE dbattendance.module_intake
 ADD foreign key(moduleID) references dbattendance.module(moduleID),
 add foreign key(intakeID) references dbattendance.intake(intakeID);
 
CREATE TABLE dbAttendance.Student
(
	studentID int auto_increment,
	fName varchar(100),
	lName varchar(100),
	
	PRIMARY KEY(studentID)
);

 alter table dbattendance.intake
 add foreign key(studentID) references dbattendance.student(studentID);
 
CREATE TABLE dbAttendance.Lecturer
(
	lecturerID int auto_increment,
	fName varchar(100),
	lName varchar(100),
	
	PRIMARY KEY(lecturerID)
);

CREATE TABLE dbAttendance.Module_Lecturer
(
	moduleID int,
	lecturerID int,

	PRIMARY KEY(moduleID, lecturerID)
	/*FOREIGN KEY(moduleID) REFERENCES Module(moduleID),
	FOREIGN KEY(lecturerID) REFERENCES Lecturer(lecturerID)*/
);
alter table dbattendance.module_lecturer
add foreign key(moduleID) references module(moduleID),
add foreign key(lecturerID) references lecturer(lecturerID);


CREATE TABLE dbAttendance.Attendance
(
	attendanceID int auto_increment,
	moduleID int,
	intakeID int,
	startTime time,
	duration varchar(50),
	attDate date,

	PRIMARY KEY(attendanceID)
	/*FOREIGN KEY(moduleID) REFERENCES Module(moduleID),
	FOREIGN KEY(intakeID) REFERENCES Intake(intakeID)*/
);

alter table dbattendance.attendance
add foreign key(moduleID) references module(moduleID),
add foreign key(intakeID) references intake(intakeID);


CREATE TABLE dbAttendance.attStatus
(
	attStatusID int auto_increment,
	attendanceID int,
	studentID int,
	attStatus varchar(50),
	
	PRIMARY KEY(attStatusID)
	/*FOREIGN KEY(attendanceID) REFERENCES Attendance(attendanceID),
	FOREIGN KEY(studentID) REFERENCES Student(studentID)*/
);

alter table dbattendance.attstatus
add foreign key(attendanceID) references attendance(attendanceID),
add foreign key(studentID) references student(studentID);