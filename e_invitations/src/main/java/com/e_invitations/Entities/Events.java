package com.e_invitations.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String eventName;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date eventDate;
	private String location;
	private String organiser;
	@OneToMany(mappedBy ="event")
	private List<Invitations> InvitationsList;
	
	public Events() {
		super();
	}
	public Events(String eventName, String type, Date eventDate, String location, String organiser,
			List<Invitations> invitationsList) {
		super();
		this.eventName = eventName;
		this.type = type;
		this.eventDate = eventDate;
		this.location = location;
		this.organiser = organiser;
		InvitationsList = invitationsList;
	}
	public Events(int id, String eventName, String type, Date eventDate, String location, String organiser,
			List<Invitations> invitationsList) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.type = type;
		this.eventDate = eventDate;
		this.location = location;
		this.organiser = organiser;
		InvitationsList = invitationsList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrganiser() {
		return organiser;
	}
	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}
	public List<Invitations> getInvitationsList() {
		return InvitationsList;
	}
	public void setInvitationsList(List<Invitations> invitationsList) {
		InvitationsList = invitationsList;
	}
	@Override
	public String toString() {
		return "Events [id=" + id + ", eventName=" + eventName + ", type=" + type + ", eventDate=" + eventDate
				+ ", location=" + location + ", organiser=" + organiser + ", InvitationsList=" + InvitationsList + "]";
	}
	
	
}