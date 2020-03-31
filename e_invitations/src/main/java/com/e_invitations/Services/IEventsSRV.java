package com.e_invitations.Services;

import java.util.List;

import com.e_invitations.Entities.Events;

public interface IEventsSRV {
	public void addOrUpdateEvent(Events event);
	public List<Events> selectAllEvent();
	public Events selectEventById(int id);
	public void deleteEvent(int id);
}
