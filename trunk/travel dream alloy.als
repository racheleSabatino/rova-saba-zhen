open util/integer

//Definizione di 
//Prodotto base
//	Volo
//	Hotel
//	Escursione
abstract sig ProdottoBase {}
	abstract sig Trasporto extends ProdottoBase {
		partenza: one Int,
		ritorno: one Int
}{
		partenza > 0 and
		ritorno > partenza
	}
		sig Volo extends Trasporto {}
	sig Hotel extends ProdottoBase {
		inizio: one Int,
		fine: one Int
}{
		inizio > 0 and
		fine > inizio
	}
	sig Escursione extends ProdottoBase  {
		inizio: one Int,
		fine: one Int
}{
		inizio > 0 and
		fine > inizio
	}
//Fine Prodotto base

//Definizione di
//Pacchetto vacanza
//	PacchettoVacanzaPredefinito
//	PacchettoVacanzaPersonalizzato
abstract sig PacchettoVacanza {
		trasporto: some Trasporto,
		hotel: some Hotel,
		escursioni: some Escursione
}
	sig PacchettoVacanzaPredefinito extends PacchettoVacanza{}
	sig PacchettoVacanzaPersonalizzato extends PacchettoVacanza {}
//Fine Pacchetto vacanza

//Definizione Degli attori
//Amministratore
sig Amministratore {
	crea: some Impiegato
}
//Impiegato
sig Impiegato {
	pvpre: some PacchettoVacanzaPredefinito
}
//Cliente
sig Cliente {
	pvper: some PacchettoVacanzaPersonalizzato,
	listaRegali: set ListaRegali
} {
	all pp: PacchettoVacanzaPersonalizzato |
	pp.trasporto.partenza <= pp.hotel.inizio and
	pp.trasporto.ritorno >= pp.hotel.fine and
	pp.trasporto.partenza <= pp.escursioni.inizio and
	pp.trasporto.ritorno >= pp.escursioni.fine and
#listaRegali <= #pvper
}
//Fine Attori

//Definizione di lista regali
sig ListaRegali {
	pvper: one PacchettoVacanzaPersonalizzato
}

//Da qui iniziano i fatti
//un pacchetto vacanza personalizzato puo' avere piu clienti associati
fact fact1 {
	all pvper1: PacchettoVacanzaPersonalizzato | some cl1: Cliente |
		pvper1 in cl1.pvper
}
//un pacchetto vacanza predefinito puo' avere piu impiegati associati
fact fact2 {
	all pvper1: PacchettoVacanzaPredefinito | some im1:  Impiegato |
		pvper1 in im1.pvpre
}

pred show1 {

	#ListaRegali = 1
	#Cliente = 1
	#Impiegato = 1
	#PacchettoVacanzaPersonalizzato = 1
	#PacchettoVacanzaPredefinito = 1
	#Escursione = 1
	#Trasporto = 1
	#Hotel = 1
}

run show1 for 4
