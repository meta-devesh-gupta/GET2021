CREATE TABLE State(
    District_Id INT NOT NULL,
    District VARCHAR(50),  
    State VARCHAR(50),
    PRIMARY KEY (District_Id)
);

CREATE TABLE ZipCode(
    Pincode INT NOT NULL,
    City VARCHAR(100),
    District_Id INT,
    PRIMARY KEY (Pincode),
    FOREIGN KEY (District_Id) REFERENCES State(District_Id)
);


INSERT INTO State (District_Id, District, State) 
VALUES
(1, 'Alwar', 'Rajasthan'),
(2, 'Amritsar','Punjab'),
(3, 'Agra', 'Uttar Pradesh'),
(4, 'Jaipur', 'Rajasthan'),
(5, 'Jodhpur', 'Rajasthan');

INSERT INTO ZipCode (Pincode, City, District_Id) 
VALUES
(301001, 'Alwar', 1),
(282002, 'JagdishPura', 3),
(283111, 'Fatehabad', 3),
(302013, 'Akhepura',4),
(282003, 'Agra Fort', 3),
(143006, 'Golden Temple',2),
(342605, 'Bala',5);

SELECT Z.Pincode, Z.City, S.District, S.State
FROM ZipCode Z
INNER JOIN State S
ON S.District_Id = Z.District_Id
ORDER BY S.State, Z.City;
