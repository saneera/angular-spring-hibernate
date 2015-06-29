package com.angular.repository;

import java.util.List;

import com.angular.model.CustomUser;
import com.angular.model.SystemUser;

public interface UserDao {
	
	public SystemUser findByUserName(String email);	
	
	public List<CustomUser> findByNameLike(int page, int maxResults, String search, String sort);

	public List<CustomUser> findAll(int page, int maxResults, String sort);

	public void persist(Object customUser);

	public void delete(String contactId);

	public int findCount();
	
	public int findCountBySearch(String search);
	
	public Object findById(Class c, String id);
	
	
}
