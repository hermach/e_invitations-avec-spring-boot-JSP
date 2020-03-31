package com.e_invitations.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e_invitations.Entities.Events;
import com.e_invitations.Entities.Invitations;
import com.e_invitations.Services.IEventsSRV;
import com.e_invitations.Services.IInvitationsSRV;

import java.text.DateFormat;  
import java.text.SimpleDateFormat; 

@Controller
public class EventsCTR {
	@Autowired
	IEventsSRV eventsSRV;
	@Autowired
	IInvitationsSRV invSRV;
	@RequestMapping("/")
	public String home(Model M){
		List<Events> listEvent = eventsSRV.selectAllEvent();
		M.addAttribute("listEvent",listEvent);
		return"home";
	}
	@RequestMapping("/addevent")
	public String addevent(Model M){
		Events ev = new Events();
		M.addAttribute("event",ev);
		return"addevent";
	}
	@RequestMapping("/addEventOrUpdate")
	public String addEventOrUpdate(@ModelAttribute() Events event){
		eventsSRV.addOrUpdateEvent(event);
		return"redirect:/";
	}
	@RequestMapping("/event")
	public String event(@RequestParam("ide") int ide,Model M){
		Events ev = eventsSRV.selectEventById(ide);
		List<Invitations> list_inv= invSRV.selectInvitationByEvent(ev);
		M.addAttribute("list_inv",list_inv);
		M.addAttribute("oneEvent",ev);
		return"event";
	}
	@RequestMapping("/updateevent")
	public String updateevent(@RequestParam("ide") int ide,Model M){
		Events ev = eventsSRV.selectEventById(ide);
		
		M.addAttribute("event",ev);
		return"addevent";
	}
	@RequestMapping("/deleteevent")
	public String deleteevent(@RequestParam("ide") int ide){
		eventsSRV.deleteEvent(ide);
		return"redirect:/";
	}
	
	
}
