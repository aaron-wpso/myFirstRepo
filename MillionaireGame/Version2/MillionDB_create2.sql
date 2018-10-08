DROP database IF EXISTS dbQuestion2;

CREATE database dbQuestion2;

CREATE TABLE dbQuestion2.question
(
	qID int auto_increment,
	qContent varchar(50),
    caID int,
    wa1ID int,
    wa2ID int,
    wa3ID int,

	PRIMARY KEY(qID)
);

CREATE TABLE dbQuestion2.correctAns
(
	caID int auto_increment,
	caContent varchar(50),
	
	PRIMARY KEY(caID)
);

CREATE TABLE dbQuestion2.wrongAns1
(
	wa1ID int auto_increment,
	wa1Content varchar(50),
	
	PRIMARY KEY(wa1ID)
);

CREATE TABLE dbQuestion2.wrongAns2
(
	wa2ID int auto_increment,
	wa2Content varchar(50),
	
	PRIMARY KEY(wa2ID)
);

CREATE TABLE dbQuestion2.wrongAns3
(
	wa3ID int auto_increment,
	wa3Content varchar(50),
	
	PRIMARY KEY(wa3ID)
);

ALTER TABLE dbQuestion2.question
ADD FOREIGN KEY(caID) REFERENCES dbQuestion2.correctAns(caID),
ADD FOREIGN KEY(wa1ID) REFERENCES dbQuestion2.wrongAns1(wa1ID),
ADD FOREIGN KEY(wa2ID) REFERENCES dbQuestion2.wrongAns2(wa2ID),
ADD FOREIGN KEY(wa3ID) REFERENCES dbQuestion2.wrongAns3(wa3ID);
	