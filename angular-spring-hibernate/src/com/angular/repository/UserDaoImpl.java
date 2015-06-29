package com.angular.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.angular.model.Contact;
import com.angular.model.CustomUser;
import com.angular.model.SystemUser;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	
	private SessionFactory sessionFactory;
		
	
	@SuppressWarnings("unchecked")
	public SystemUser findByUserName(String userName){	
		List<SystemUser> users = new ArrayList<SystemUser>();
		 
		users = sessionFactory.getCurrentSession()
			.createQuery("from SystemUser where username=?")
			.setParameter(0, userName).list();
 
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
		 
	}
	
	
	@Override
	public List<CustomUser> findAll(int page, int maxResults, String sort) {
		List<CustomUser> contact = new ArrayList<CustomUser>();
		 
		Query query = sessionFactory.getCurrentSession()
					  .createQuery("from CustomUser");
		
		query.setFirstResult(page);
		query.setMaxResults(maxResults);
		
		contact = query.list();
		return contact;
	}


	@Override
	public List<CustomUser> findByNameLike(int page, int maxResults, String search, String sort) {
	
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
	public void persist(Object customUser) {
		sessionFactory.getCurrentSession().saveOrUpdate(customUser);
		
	}


	@Override
	public void delete(String contactId) {
		int updateQuery = sessionFactory.getCurrentSession().createQuery("delete from CustomUser where id = ?")
		.setParameter(0,  contactId)
		.executeUpdate();	
		
	}


	@Override
	public int findCount() {
		int count = ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from CustomUser")
				.uniqueResult())
				.intValue();
		
		return count;
	}

	
	@Override
	public int findCountBySearch(String search) {
		int count = ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from CustomUser where name like ?")
				.setParameter(0, search)
				.uniqueResult())
				.intValue();
		
		return count;
	}
	
	public Object findById(Class c, String id) {
		return this.sessionFactory.getCurrentSession().get(c, id);
	}
	
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	 @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
}
