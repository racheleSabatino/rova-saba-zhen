INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`) 
										 VALUES ('1', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in barca', 'genova');
INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`)
										 VALUES ('2', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in aereo', 'genova');
INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`)
										 VALUES ('3', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in sottomarino', 'genova');
INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`)
									VALUES ('4', 'napoli', '100', '2013-11-27 23:44:12', '2013-11-27 23:44:13','vista mare', '3', '3');
INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`)
									VALUES ('5', 'caserta', '100', '2013-11-27 23:44:12', '2013-11-27 23:44:13','vista reggia', '4', '4');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) 
										VALUES ('6', 'milano', 'roma', '65', '2013-11-27 23:44:12', '2013-11-27 23:44:13','aeroplano');
INSERT INTO `traveldreamsystem_db`.`pacchpred` (`IDPACCHPRED`, `DESCRIZIONE`) 
										VALUES ('1', 'vacanza di prova');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred` (`IDESCURSIONE`, `IDPACCHPRED` ) 
												  VALUES ('1', '1');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred` (`IDESCURSIONE`, `IDPACCHPRED` ) 
												  VALUES ('2', '1');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred` (`IDESCURSIONE`, `IDPACCHPRED` ) 
												  VALUES ('3', '1');
INSERT INTO `traveldreamsystem_db`.`hotelspacchpred` (`IDHOTEL`, `IDPACCHPRED` ) 
											 VALUES ('4', '1');
INSERT INTO `traveldreamsystem_db`.`hotelspacchpred` (`IDHOTEL`, `IDPACCHPRED` ) 
											 VALUES ('5', '1');
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED` ) 
											     VALUES ('6', '1');												  