package com.e_invitations.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.e_invitations.Entities.Events;
import com.e_invitations.Entities.Invitations;

@Transactional
@Repository
public class InvitationsDAO implements IInvitationsDAO {
	@PersistenceContext
	EntityManager em;
	public void addOrUpdateInvitation(Invitations inv) {
		em.merge(inv);
	}
	public List<Invitations> selectInvitationByEvent(Events event) {
		List<Invitations> liste = event.getInvitationsList();
		return liste;
	}
	public Invitations selectInvitationById(int id) {
		Invitations inv = (Invitations) em.find(Invitations.class, id);
		return inv;
	}
	public void deleteInvitation(int id) {
		Invitations inv = (Invitations) em.find(Invitations.class, id);
		em.remove(inv);
	}
}
