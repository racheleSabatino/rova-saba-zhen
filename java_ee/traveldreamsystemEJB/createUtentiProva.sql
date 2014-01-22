START TRANSACTION;
BEGIN;

INSERT INTO `traveldreamsystem_db`.`utente` (`MAIL`, `COGNOME`, `NOME`, `PASSWORD`, `REGISTEREDON`, `TIPOUTENTE`) VALUES ('admin', 'admin', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','2013-11-27 23:44:12', 'AMMINISTRATORE');
INSERT INTO `traveldreamsystem_db`.`utente` (`MAIL`, `COGNOME`, `NOME`, `PASSWORD`, `REGISTEREDON`, `TIPOUTENTE`) VALUES ('impiegato', 'impiegato', 'impiegato', '3f65f50ce25d0b80006018e4f6d90bf039f6ea2d717aa90aa224b90d3941f30a','2013-11-27 23:44:12', 'IMPIEGATO');
INSERT INTO `traveldreamsystem_db`.`utente` (`MAIL`, `COGNOME`, `NOME`, `PASSWORD`, `REGISTEREDON`, `TIPOUTENTE`) VALUES ('cliente', 'cliente', 'cliente', 'a60b85d409a01d46023f90741e01b79543a3cb1ba048eaefbe5d7a63638043bf','2013-11-27 23:44:12', 'CLIENTE');

COMMIT;