package com.e_invitations.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Invitations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mail;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date accepted_at;
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date refused_at;
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sent_at;
	@ManyToOne
	@JoinColumn(name="id_event")
	private Events event;
	
	
	public Invitations() {
		super();
	}
	public Invitations(int id, String mail, String status, Date accepted_at, Date refused_at, Date sent_at,
			Events event) {
		super();
		this.id = id;
		this.mail = mail;
		this.status = status;
		this.accepted_at = accepted_at;
		this.refused_at = refused_at;
		this.sent_at = sent_at;
		this.event = event;
	}
	public Invitations(String mail, String status, Date accepted_at, Date refused_at, Date sent_at, Events event) {
		super();
		this.mail = mail;
		this.status = status;
		this.accepted_at = accepted_at;
		this.refused_at = refused_at;
		this.sent_at = sent_at;
		this.event = event;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAccepted_at() {
		return accepted_at;
	}
	public void setAccepted_at(Date accepted_at) {
		this.accepted_at = accepted_at;
	}
	public Date getRefused_at() {
		return refused_at;
	}
	public void setRefused_at(Date refused_at) {
		this.refused_at = refused_at;
	}
	public Date getSent_at() {
		return sent_at;
	}
	public void setSent_at(Date sent_at) {
		this.sent_at = sent_at;
	}
	public Events getEvent() {
		return event;
	}
	public void setEvent(Events event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "Invitations [id=" + id + ", mail=" + mail + ", status=" + status + ", accepted_at=" + accepted_at
				+ ", refused_at=" + refused_at + ", sent_at=" + sent_at + ", event=" + event + "]";
	}
	
}
