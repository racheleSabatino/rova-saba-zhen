ALTER TABLE Escursione DROP FOREIGN KEY FK_Escursione_IDPRODBASE
ALTER TABLE Hotel DROP FOREIGN KEY FK_Hotel_IDPRODBASE
ALTER TABLE PacchPer DROP FOREIGN KEY FK_PacchPer_IDPACCHPER
ALTER TABLE PacchPer DROP FOREIGN KEY FK_PacchPer_Clienti
ALTER TABLE PacchPer DROP FOREIGN KEY FK_PacchPer_idPacchPred
ALTER TABLE Trasporto DROP FOREIGN KEY FK_Trasporto_IDPRODBASE
ALTER TABLE Composizione DROP FOREIGN KEY FK_Composizione_idProdBase
ALTER TABLE Composizione DROP FOREIGN KEY FK_Composizione_idPacchPred
DROP TABLE Escursione
DROP TABLE Hotel
DROP TABLE PacchPer
DROP TABLE PacchPred
DROP TABLE ProdBase
DROP TABLE Trasporto
DROP TABLE Utente
DROP TABLE Composizione