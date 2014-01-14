package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import java.util.List;

import javax.annotation.Resource;
//import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UtenteMgrBean
 */
@Stateless
public class UtenteMgrBean implements UtenteMgrBeanLocal {

	/**
	 * Default constructor.
	 */
	public UtenteMgrBean() {
	}

	@PersistenceContext
	private EntityManager em;

	@Resource
	private EJBContext context;

	@Override
	// @RolesAllowed({Utente._UTENTE, Utente._AMMINISTRATORE})
	public void save(UtenteDTO utente) {
		Utente newUtente = new Utente(utente);
		newUtente.setTipoUtente(Utente._CLIENTE);
		em.persist(newUtente);
	}

	@Override
	public void update(UtenteDTO utente) {
		em.merge(new Utente(utente));
	}

	@Override
	public UtenteDTO getUtenteDTO() {
		if (getPrincipalUser() != null) {
			return convertToDTO(getPrincipalUser());
		} else {
			return null;
		}
	}

	@Override
	public void unregister() {
		remove(getPrincipalUser());
	}

	public Utente find(String mail) {
		return em.find(Utente.class, mail);
	}

	public List<Utente> getAllUsers() {
		return em.createNamedQuery("Utente.findALL", Utente.class)
				.getResultList();
	}

	public void remove(String mail) {
		Utente utente = find(mail);
		em.remove(utente);
	}

	public void remove(Utente utente) {
		em.remove(utente);
	}

	public Utente getPrincipalUser() {
		return find(getPrincipalEmail());
	}

	public String getPrincipalEmail() {
		return context.getCallerPrincipal().getName();
	}

	private UtenteDTO convertToDTO(Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setMail(utente.getMail());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setPassword(utente.getPassword());
		utenteDTO.setTipoutente(utente.getTipoutente());
		return utenteDTO;
	}

}