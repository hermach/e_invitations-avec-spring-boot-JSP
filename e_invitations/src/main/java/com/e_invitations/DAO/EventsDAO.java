package com.e_invitations.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.e_invitations.Entities.Events;

@Transactional
@Repository
public class EventsDAO implements IEventsDAO {
	@PersistenceContext
	EntityManager em;
	public void addOrUpdateEvent(Events event) {
		em.merge(event);
	}
	public List<Events> selectAllEvent() {
		String sql="FROM Events";
		Query query = em.createQuery(sql);
		List<Events> liste = query.getResultList();
		return liste;
	}
	public Events selectEventById(int id) {
		Events ev = (Events) em.find(Events.class , id); 
		return ev;
	}
	public void deleteEvent(int id) {
		Events ev = (Events) em.find(Events.class , id);
		em.remove(ev);
	}
}
