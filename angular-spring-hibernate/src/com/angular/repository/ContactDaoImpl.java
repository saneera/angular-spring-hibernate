package com.angular.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.angular.model.Contact;
import com.angular.model.SystemUser;


@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao{

	private SessionFactory sessionFactory;
		
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Contact> findAll(int page, int maxResults, String sort) {
		List<Contact> contact = new ArrayList<Contact>();
		 
		Query query = sessionFactory.getCurrentSession()
					  .createQuery("from Contact");
		
		query.setFirstResult(page);
		query.setMaxResults(maxResults);
		
		contact = query.list();
				
		return contact;
	}


	@Override
	public List<Contact> findByNameLike(int page, int maxResults, String search, String sort) {
	
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
	public void save(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
	}


	@Override
	public void delete(String contactId) {
		int updateQuery = sessionFactory.getCurrentSession().createQuery("delete from Contact where id = ?")
		.setParameter(0,  contactId)
		.executeUpdate();	
		
	}


	@Override
	public int findCount() {
		int count = ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from Contact")
				.uniqueResult())
				.intValue();
		
		return count;
	}

	
	@Override
	public int findCountBySearch(String search) {
		int count = ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from Contact where name like ?")
				.setParameter(0, search)
				.uniqueResult())
				.intValue();
		
		return count;
	}
	
}
