
INSERT INTO `traveldreamsystem_db`.`pacchpred` (`IDPACCHPRED`, `DESCRIZIONE`) VALUES ('1000', 'maldive');
INSERT INTO `traveldreamsystem_db`.`pacchpred` (`IDPACCHPRED`, `DESCRIZIONE`) VALUES ('1001', 'roma');
INSERT INTO `traveldreamsystem_db`.`hotel`(`TIPOCAMERA`, `STELLE`, `DESCRIZIONE`,`COSTO`,`CITTA`,`IDPRODBASE`) VALUES('doppia', '3','costoso', '200', 'maldive', '1');
INSERT INTO `traveldreamsystem_db`.`hotel`(`TIPOCAMERA`, `STELLE`, `DESCRIZIONE`,`COSTO`,`CITTA`,`IDPRODBASE`) VALUES(`'oppia', '4','amato', '100', 'roma', '2');
INSERT INTO `traveldreamsystem_db`.`escursione`(`LUOGO`, `DESCRIZIONE`, `DATAPARTENZA`,`COSTO`,`IDPRODBASE`) VALUES('roma', 'escursione in montagna','2013-11-27 23:44:12', '2013-11-30 23:44:12', '250', '1');
INSERT INTO `traveldreamsystem_db`.`escursione`(`LUOGO`, `DESCRIZIONE`, `DATAPARTENZA`,`COSTO`,`IDPRODBASE`) VALUES('maldive', 'scii acqua','2013-12-02 23:44:12', '2013-12-02 23:44:12', '250', '2');
INSERT INTO `traveldreamsystem_db`.`escursione`(`LUOGO`, `DESCRIZIONE`, `DATAPARTENZA`,`COSTO`,`IDPRODBASE`) VALUES('maldive', 'sub','2013-12-03 23:44:12', '2013-12-04 23:44:12', '120', '3');
INSERT INTO `traveldreamsystem_db`.`trasporto`(`DESCRIZIONE`, `DATARITORNO`, `DATAPARTENZA`,`COSTO`,`CITTARITORNO`,`CITTAPARTENZA`, `IDPRODBASE`) VALUES('volo business', '2013-12-01 16:44:12','2013-12-12 23:44:12', '200', 'roma', 'milano', '1');
INSERT INTO `traveldreamsystem_db`.`trasporto`(`DESCRIZIONE`, `DATARITORNO`, `DATAPARTENZA`,`COSTO`,`CITTARITORNO`,`CITTAPARTENZA`, `IDPRODBASE`) VALUES('volo business', '2013-12-01 16:44:12','2013-12-12 23:44:12', '200', 'maldive', 'milano', '2');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred`(`IDPACCHPRED`, `IDESCURSIONE`) VALUES('1000', '2');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred`(`IDPACCHPRED`, `IDESCURSIONE`) VALUES('1001', '1');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred`(`IDPACCHPRED`, `IDESCURSIONE`) VALUES('1001', '3');
INSERT INTO `traveldreamsystem_db`.`hotelspacchpred`(`IDPACCHPRED`, `IDESCURSIONE`) VALUES('1000', '1');
INSERT INTO `traveldreamsystem_db`.`hotelspacchpred`(`IDPACCHPRED`, `IDESCURSIONE`) VALUES('1001', '2');
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred`(`IDPACCHPRED`, `IDESCURSIONE`) VALUES('1001', '2');
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred`(`IDPACCHPRED`, `IDESCURSIONE`) VALUES('1001', '1');
