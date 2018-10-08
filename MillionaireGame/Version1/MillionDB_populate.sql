USE dbQuestion;

INSERT INTO correctAns(caContent)
VALUES	('4'),
	('Asia'),
	('Osmium'),
	('Hercules'),
	('Thor');

INSERT INTO questions(qcontent, caID)
VALUES('What is 2 + 2?',1),
	('Where is Malaysia?',2),
	('What is the densest metal?',3),
	('Who is not a Greek God?',4),
	('Who did Thanos not kill?',5);
    
INSERT INTO wrongAns(waContent)
VALUES
	('5'),
	('3'),
	('22'),
	('Europe'),
	('South America'),
	('Africa'),
	('Gold'),
	('Plutonium'),
	('Iridium'),
	('Ares'),
	('Hephaestus'),
	('Demeter'),
	('Scarlet Witch'),
	('Black Panther'),
	('Doctor Strange');
    
INSERT INTO questions_wrongAns (qID, waID)
VALUES
	(1,1),
    (1,2),
    (1,3),
    (2,4),
    (2,5),
    (2,6),
    (3,7),
    (3,8),
    (3,9),
    (4,10),
    (4,11),
    (4,12),
    (5,13),
    (5,14),
    (5,15);
	