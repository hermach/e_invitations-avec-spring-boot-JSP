package com.e_invitations.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_invitations.DAO.IInvitationsDAO;
import com.e_invitations.Entities.Events;
import com.e_invitations.Entities.Invitations;

@Service
public class InvitationsSRV implements IInvitationsSRV {
	@Autowired
	IInvitationsDAO invDAO;
	public void addOrUpdateInvitation(Invitations inv) {
		invDAO.addOrUpdateInvitation(inv);
	}
	public List<Invitations> selectInvitationByEvent(Events event){
		return invDAO.selectInvitationByEvent(event);
	}
	public Invitations selectInvitationById(int id) {
		return invDAO.selectInvitationById(id);
	}
	public void deleteInvitation(int id) {
		invDAO.deleteInvitation(id);
	}
}
