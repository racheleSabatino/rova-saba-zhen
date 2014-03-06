INSERT INTO `traveldreamsystem_db`.`utente` (`MAIL`, `COGNOME`, `NOME`, `PASSWORD`, `REGISTEREDON`, `TIPOUTENTE`) VALUES ('admin', 'admin', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','2013-11-27 23:44:12', 'AMMINISTRATORE');
INSERT INTO `traveldreamsystem_db`.`utente` (`MAIL`, `COGNOME`, `NOME`, `PASSWORD`, `REGISTEREDON`, `TIPOUTENTE`) VALUES ('impiegato', 'impiegato', 'impiegato', '3f65f50ce25d0b80006018e4f6d90bf039f6ea2d717aa90aa224b90d3941f30a','2013-11-27 23:44:12', 'IMPIEGATO');
INSERT INTO `traveldreamsystem_db`.`utente` (`MAIL`, `COGNOME`, `NOME`, `PASSWORD`, `REGISTEREDON`, `TIPOUTENTE`) VALUES ('cliente', 'cliente', 'cliente', 'a60b85d409a01d46023f90741e01b79543a3cb1ba048eaefbe5d7a63638043bf','2013-11-27 23:44:12', 'CLIENTE');

INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`) 
										 VALUES ('1', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in barca: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', 'genova');
INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`)
										 VALUES ('2', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in aereo: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', 'genova');
INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`)
										 VALUES ('3', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in sottomarino: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', 'genova');
INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`)
										 VALUES ('4', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in sottomarino: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', 'genova');
INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`)
										 VALUES ('5', '10', '2013-11-27 23:44:12', '2013-11-27 23:44:13','escursione in sottomarino: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', 'genova');
INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`)
									VALUES ('1', 'napoli', '100', '2013-11-27 23:44:12', '2013-11-27 23:44:13','vista mare: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', '3', '3');
INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`)
									VALUES ('2', 'Caserta', '100', '2013-11-27 23:44:12', '2013-11-27 23:44:13','vista reggia: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', '4', '4');
INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`)
									VALUES ('3', 'Savona', '100', '2013-11-27 23:44:12', '2013-11-27 23:44:13','vista reggia: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', '4', '4');
INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`)
									VALUES ('4', 'Perugia', '100', '2013-11-27 23:44:12', '2013-11-27 23:44:13','vista reggia: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', '4', '4');
INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`)
									VALUES ('5', 'Berghem', '100', '2013-11-27 23:44:12', '2013-11-27 23:44:13','vista reggia: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ', '4', '4');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) 
										VALUES ('1', 'Savona', 'Roma', '65', '2013-11-27 23:44:12', '2013-11-27 23:44:13','aeroplano: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) 
										VALUES ('2', 'Roma', 'Savona', '65', '2013-11-27 23:44:12', '2013-11-27 23:44:13','aeroplano: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) 
										VALUES ('3', 'Milano', 'Perugia', '65', '2013-11-27 23:44:12', '2013-11-27 23:44:13','aeroplano: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) 
										VALUES ('4', 'Sondrio', 'Aosta', '65', '2013-11-27 23:44:12', '2013-11-27 23:44:13','aeroplano: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) 
										VALUES ('5', 'Aosta', 'Berghem', '65', '2013-11-27 23:44:12', '2013-11-27 23:44:13','aeroplano: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) 
										VALUES ('6', 'Berghem', 'Sondrio', '65', '2013-11-27 23:44:12', '2013-11-27 23:44:13','aeroplano: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. ');
INSERT INTO `traveldreamsystem_db`.`pacchpred` (`IDPACCHPRED`, `DESCRIZIONE`) 
										VALUES ('1', 'vacanza di prova: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
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
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED` ) 
											     VALUES ('2', '1');	
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED` ) 
											     VALUES ('3', '1');	
INSERT INTO `traveldreamsystem_db`.`pacchpred` (`IDPACCHPRED`, `DESCRIZIONE`) 
										VALUES ('2', 'vacanza di prova2: Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred` (`IDESCURSIONE`, `IDPACCHPRED` ) 
												  VALUES ('3', '2');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred` (`IDESCURSIONE`, `IDPACCHPRED` ) 
												  VALUES ('4', '2');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred` (`IDESCURSIONE`, `IDPACCHPRED` ) 
												  VALUES ('5', '2');
INSERT INTO `traveldreamsystem_db`.`hotelspacchpred` (`IDHOTEL`, `IDPACCHPRED` ) 
											 VALUES ('4', '2');
INSERT INTO `traveldreamsystem_db`.`hotelspacchpred` (`IDHOTEL`, `IDPACCHPRED` ) 
											 VALUES ('5', '2');
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED` ) 
											     VALUES ('6', '2');		
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED` ) 
											     VALUES ('4', '2');	
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED` ) 
											     VALUES ('2', '2');	
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED` ) 
											     VALUES ('3', '2');	
