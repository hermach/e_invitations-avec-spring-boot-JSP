package com.e_invitations.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_invitations.Entities.Invitations;
import com.e_invitations.Services.IInvitationsSRV;

@Controller
public class InvitationsCTR {
	@Autowired
	IInvitationsSRV invSRV;
	
	@RequestMapping("/addinvitation")
	public String addinvitation(@RequestParam("ide")int ide,Model M){
		Invitations inv = new Invitations();
		M.addAttribute("invitation",inv);
		M.addAttribute("id_event",ide);
		return"addinvitation";
	}
	@RequestMapping("/addEventOrInvitation")
	public String addEventOrInvitation(@ModelAttribute()Invitations inv){
		invSRV.addOrUpdateInvitation(inv);
		System.out.println(inv);
		return"redirect:event?ide="+inv.getEvent().getId();
	}
	@RequestMapping("/updateinvitation")
	public String updateinvitation(@RequestParam("idi")int idi,Model M){
		Invitations inv = invSRV.selectInvitationById(idi);
		int id = inv.getEvent().getId();
		M.addAttribute("invitation",inv);
		M.addAttribute("id_event",id);
		return"addinvitation";
	}
	@RequestMapping("/deleteinvitation")
	public String deleteinvitation(@RequestParam("idi")int idi,Model M){
		Invitations inv = invSRV.selectInvitationById(idi);
		invSRV.deleteInvitation(idi);
		return "redirect:event?ide="+inv.getEvent().getId();
	}
	

}
