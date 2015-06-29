package com.angular.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.angular.model.Contact;

public interface ContactDao   {

	public List<Contact> findByNameLike(int page, int maxResults, String search, String sort);

	public List<Contact> findAll(int page, int maxResults, String sort);

	public void save(Contact contact);

	public void delete(String contactId);

	public int findCount();
	
	public int findCountBySearch(String search);
}
