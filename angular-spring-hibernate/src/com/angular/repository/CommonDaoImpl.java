package com.angular.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.angular.model.Contact;
import com.angular.model.CustomUser;
import com.angular.model.SystemUser;

public class CommonDaoImpl implements CommonDao {

	private SessionFactory sessionFactory;
		
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public List<Contact> findContactByNameLike(int page, int maxResults, String search, String sort) {
		
		List<Contact> contact = new ArrayList<Contact>();
		Query query = sessionFactory.getCurrentSession()
					  .createQuery("from Contact where name like ?");
		
		query.setParameter(0, search);
		query.setFirstResult(page);
		query.setMaxResults(maxResults);
		
		contact = query.list();
		return contact;
	}

	@Override
	public List<CustomUser> findUsersByNameLike(int page, int maxResults, String search, String sort) {
		
		List<CustomUser> contact = new ArrayList<CustomUser>();
		Query query = sessionFactory.getCurrentSession()
					  .createQuery("from CustomUser where name like ?");
		
		query.setParameter(0, search);
		query.setFirstResult(page);
		query.setMaxResults(maxResults);
		
		contact = query.list();
		return contact;
	}
	
	
	@Override
	public List<?> findAll(int page, int maxResults, String sort) {
		
		return null;
	}

		
	@Override
	public void persist(Object object) {
		sessionFactory.getCurrentSession().saveOrUpdate(object);		
	}

	

	@Override
	public void deleteContact(int contactId) {		
		
	}

	@Override
	public int findCountAll() {
		
		return 0;
	}

	@Override
	public SystemUser findByEmail(String email) {		
		return null;
	}


	@Override
	public void delete(int id, Class clas) {
		// TODO Auto-generated method stub
		
	}


	

}
