package com.e_invitations.Services;

import java.util.List;

import com.e_invitations.Entities.Events;
import com.e_invitations.Entities.Invitations;

public interface IInvitationsSRV {
	public void addOrUpdateInvitation(Invitations inv);
	public List<Invitations> selectInvitationByEvent(Events event);
	public Invitations selectInvitationById(int id);
	public void deleteInvitation(int id);
}
