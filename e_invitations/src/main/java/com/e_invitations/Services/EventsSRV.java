package com.e_invitations.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_invitations.DAO.IEventsDAO;
import com.e_invitations.Entities.Events;

@Service
public class EventsSRV implements IEventsSRV{
	@Autowired
	IEventsDAO eventDAO;
	public void addOrUpdateEvent(Events event) {
		eventDAO.addOrUpdateEvent(event);
	}
	public List<Events> selectAllEvent(){
		return eventDAO.selectAllEvent();
	}
	public Events selectEventById(int id) {
		return eventDAO.selectEventById(id);
	}
	public void deleteEvent(int id) {
		eventDAO.deleteEvent(id);
	}
}
