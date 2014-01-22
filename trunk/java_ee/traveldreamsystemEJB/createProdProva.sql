START TRANSACTION;
BEGIN;

INSERT INTO `traveldreamsystem_db`.`hotel` (`IDPRODBASE`, `CITTA`, `COSTO`, `DESCRIZIONE`, `STELLE`, `TIPOCAMERA`) VALUES ('1', 'mi', '22', 'desc', '5', 'dopp');
INSERT INTO `traveldreamsystem_db`.`escursione` (`IDPRODBASE`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`, `LUOGO`) VALUES ('1', '1', '2014-01-01 00:00:00', '2014-01-01 00:00:00', '1', '1');
INSERT INTO `traveldreamsystem_db`.`trasporto` (`IDPRODBASE`, `CITTAPARTENZA`, `CITTARITORNO`, `COSTO`, `DATAPARTENZA`, `DATARITORNO`, `DESCRIZIONE`) VALUES ('1', 'asd', 'asd', '2', '2014-01-01 00:00:00', '2014-01-01 00:00:00', 'a');
INSERT INTO `traveldreamsystem_db`.`pacchpred` (`IDPACCHPRED`, `DESCRIZIONE`) VALUES ('1', 'maldive');
INSERT INTO `traveldreamsystem_db`.`pacchper` (`IDPACCHPER`, `DATAACQUISTO`, `LISTAREGALI`, `IDPACCHPRED`) VALUES ('1', '2014-01-01 00:00:00', '0', '1');

INSERT INTO `traveldreamsystem_db`.`hotelspacchpred` (`IDHOTEL`, `IDPACCHPRED`) VALUES ('1', '1');
INSERT INTO `traveldreamsystem_db`.`escursionipacchpred` (`IDESCURSIONE`, `IDPACCHPRED`) VALUES ('1', '1');
INSERT INTO `traveldreamsystem_db`.`trasportipacchpred` (`IDTRASPORTO`, `IDPACCHPRED`) VALUES ('1', '1');


COMMIT;