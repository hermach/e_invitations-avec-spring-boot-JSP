package com.e_invitations.DAO;

import java.util.List;

import com.e_invitations.Entities.Events;

public interface IEventsDAO {
	public void addOrUpdateEvent(Events event);
	public List<Events> selectAllEvent();
	public Events selectEventById(int id);
	public void deleteEvent(int id);
}
