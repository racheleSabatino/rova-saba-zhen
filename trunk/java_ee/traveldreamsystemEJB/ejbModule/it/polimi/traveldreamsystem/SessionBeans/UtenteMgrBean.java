package it.polimi.traveldreamsystem.SessionBeans;

import it.polimi.traveldreamsystem.Entities.Utente;
import it.polimi.traveldreamsystem.dto.UtenteDTO;

import java.util.List;

import javax.annotation.Resource;
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
	protected EntityManager em;

	@Resource
	private EJBContext context;

	protected void save(UtenteDTO utente) {
		Utente newUtente = new Utente(utente);
		em.persist(newUtente);
	}


	private void update(UtenteDTO utente) {
		em.merge(new Utente(utente));
	}

	@Override
	public UtenteDTO getUtenteDTO() {
			return convertToDTO(getPrincipalUser());
	}
	
	@Override
	public UtenteDTO findUtenteDTO(String mail) {
		return this.convertToDTO(findUtente(mail));
	}

	@Override
	public void unregister() {
		removeUtente(getPrincipalUser());
	}

	public Utente findUtente(String mail) {
		return em.find(Utente.class, mail);
		
	}
	

	public List<Utente> getAllUsers() {
		return em.createNamedQuery("Utente.findALL", Utente.class)
				.getResultList();
	}

	public void removeUtente(String mail) {
		Utente utente = findUtente(mail);
		em.remove(utente);
	}

	public void removeUtente(Utente utente) {
		em.remove(utente);
	}

	public Utente getPrincipalUser() {
		return findUtente(getPrincipalEmail());
	}

	public String getPrincipalEmail() {
		return context.getCallerPrincipal().getName();
	}

	public UtenteDTO convertToDTO(Utente utente) {
		if (utente == null) {
			return null;
		}
		UtenteDTO utenteDTO = new UtenteDTO();
		utenteDTO.setMail(utente.getMail());
		utenteDTO.setNome(utente.getNome());
		utenteDTO.setCognome(utente.getCognome());
		utenteDTO.setPassword(utente.getPassword());
		utenteDTO.setTipoUtente(utente.getTipoutente());
		return utenteDTO;
	}

}
