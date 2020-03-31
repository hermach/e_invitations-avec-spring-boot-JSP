package com.e_invitations.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_invitations.Services.IEmailSRV;
import com.e_invitations.DAO.IInvitationsDAO;
import com.e_invitations.Entities.Invitations;
import com.e_invitations.Services.IInvitationsSRV;

@Controller
public class emailCTR {
	
	@Autowired
	IEmailSRV emailSRV;
	@Autowired
	IInvitationsSRV Invitations;
	@Autowired
	IInvitationsDAO invDAO;
	
	@RequestMapping("/sendMail")
	private String sendMail(@RequestParam("idi")int idi) {
		Invitations inv = Invitations.selectInvitationById(idi); 
		emailSRV.sendEmail(inv);
		Date date = new Date();
		inv.setSent_at(date);
		invDAO.addOrUpdateInvitation(inv);
		return"redirect:event?ide="+inv.getEvent().getId();
	}
	@RequestMapping("/accepteinvite")
	private String accepteinvite(@RequestParam("idi")int idi) {
		Invitations inv = Invitations.selectInvitationById(idi);
		Date date = new Date();
		Date date2 = null;
		inv.setAccepted_at(date);
		inv.setRefused_at(date2);
		inv.setStatus("accepte");
		invDAO.addOrUpdateInvitation(inv);
		return"accepteemail";
	}
	@RequestMapping("/refuseinvite")
	private String refuseinvite(@RequestParam("idi")int idi) {
		Invitations inv = Invitations.selectInvitationById(idi);
		Date date = new Date();
		Date date2 = null;
		inv.setAccepted_at(date2);
		inv.setRefused_at(date);
		inv.setStatus("refuse");
		invDAO.addOrUpdateInvitation(inv);
		return"refuseemail";
	}
}
