package com.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.model.Contact;
import com.angular.pagination.Page;
import com.angular.repository.ContactDao;
import com.angular.vo.ContactListVO;

@Service
@Transactional
public class ContactService {

    @Autowired
    private ContactDao contactDao;    
    

    @Transactional(readOnly = true)
    public ContactListVO findAll(int page, int maxResults) {
    	int  count = executeQueryCount();
    	page = page*5;
        List<Contact> contactList = executeQueryFindAll(page, maxResults);        
        Page<Contact> result = new Page<Contact>(count, contactList);
        
        if(shouldExecuteSameQueryInLastPage(page, result)){
            int lastPage = result.getTotalPages() - 1;
            lastPage = lastPage*5;
            contactList = executeQueryFindAll(lastPage, maxResults);
        }

        return buildResult(result);
    }

    public void save(Contact contact) {
    	contactDao.save(contact);
    }

    @Secured("ROLE_ADMIN")
    public void delete(String contactId) {
    	contactDao.delete(contactId);
    }

    @Transactional(readOnly = true)
    public ContactListVO findByNameLike(int page, int maxResults, String name) {
        
    	int  count = executeQueryCountSearch(name);
    	List<Contact> contactList = executeQueryFindByName(page, maxResults, name);
               
        Page<Contact> result = new Page<Contact>(count, contactList);
        
        if(shouldExecuteSameQueryInLastPage(page, result)){
            int lastPage = result.getTotalPages() - 1;
            contactList = executeQueryFindByName(lastPage, maxResults, name);
        }

        return buildResult(result);
    }

    private boolean shouldExecuteSameQueryInLastPage(int page, Page<Contact> result) {
        return isUserAfterOrOnLastPage(page, result) && hasDataInDataBase(result);
    }

    private List<Contact> executeQueryFindAll(int page, int maxResults) {     
        return contactDao.findAll(page, maxResults, "");
    }

    private int executeQueryCount() {     
        return contactDao.findCount();
    }
    
    private int executeQueryCountSearch(String name) {     
        return contactDao.findCountBySearch(name);
    }

    private ContactListVO buildResult(Page<Contact> result) {
        return new ContactListVO(result.getTotalPages(), result.getTotalElements(), result.getContent());
    }

    private List<Contact> executeQueryFindByName(int page, int maxResults, String name) {     
        return contactDao.findByNameLike(page, maxResults, "%" + name + "%", "");
    }

    private boolean isUserAfterOrOnLastPage(int page, Page<Contact> result) {
        return page >= result.getTotal() - 1;
    }

    private boolean hasDataInDataBase(Page<Contact> result) {
        return result.getTotalElements() > 0;
    }
}