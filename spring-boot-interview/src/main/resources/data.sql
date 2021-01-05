DROP TABLE IF EXISTS CLIENT;
DROP TABLE IF EXISTS CITY;
DROP TABLE IF EXISTS ESTATE;

CREATE TABLE ESTATE (  
estatecode INT AUTO_INCREMENT  PRIMARY KEY,  
estatename VARCHAR(50) NOT NULL
);  

CREATE TABLE CITY (  
citycode INT AUTO_INCREMENT  PRIMARY KEY,  
cityname VARCHAR(50) NOT NULL,
estatecode INT NOT NULL,
FOREIGN KEY(estatecode) REFERENCES ESTATE(estatecode)
);  

CREATE TABLE CLIENT (  
clientcode INT AUTO_INCREMENT  PRIMARY KEY,  
clientname VARCHAR(50) NOT NULL,  
dateofbirth date,
age INT(10) NOT NULL,
citycode INT,
gendercode ENUM('M', 'F'),
FOREIGN KEY (citycode) REFERENCES CITY(citycode)
);


INSERT INTO ESTATE (estatename) VALUES 
('RS'),
('SC'); 
INSERT INTO CITY VALUES 
(1, 'Porto Alegre', 1),
(2, 'Canoas', 1),
(3, 'Torres', 1),
(4, 'Florianópolis', 2),
(5, 'Tubarão', 2),
(6, 'Palhoça', 2);