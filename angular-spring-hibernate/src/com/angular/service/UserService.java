package com.angular.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.dto.CustomUserDTO;
import com.angular.model.CustomUser;
import com.angular.model.SystemUser;
import com.angular.pagination.Page;
import com.angular.repository.UserDao;
import com.angular.vo.UserListVO;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public SystemUser findByUserName(String userName){
        return userDao.findByUserName(userName);
    }
    
    
    @Transactional(readOnly = true)
    public UserListVO findAll(int page, int maxResults) {
    	int  count = executeQueryCount();
    	page = page*5;
        List<CustomUser> customUserList = executeQueryFindAll(page, maxResults);     
        
        List<CustomUserDTO> customUsersDTO = new ArrayList<CustomUserDTO>();
    	
    	if(customUserList != null && customUserList.size() > 0) {
    		for (CustomUser customUser : customUserList) {
    			CustomUserDTO customUsersDto = new CustomUserDTO();
    			customUsersDto.setId(customUser.getId());
    			customUsersDto.setEmail(customUser.getEmail());
    			customUsersDto.setCode(customUser.getCode());
    			customUsersDto.setName(customUser.getName());
    			customUsersDto.setSurname(customUser.getSurname());
    			if(customUser.getSystemUser() != null) {
    				customUsersDto.setUserName(customUser.getSystemUser().getUsername());
    			}
    			customUsersDTO.add(customUsersDto);
			}
    	}
        
        
        Page<CustomUserDTO> result = new Page<CustomUserDTO>(count, customUsersDTO);
        
        if(shouldExecuteSameQueryInLastPage(page, result)){
            int lastPage = result.getTotalPages() - 1;
            lastPage = lastPage*5;
            customUserList = executeQueryFindAll(lastPage, maxResults);
        }

        return buildResult(result);
    }

    public void save(CustomUserDTO user) {
    	
    	boolean isNew = false;
    	
    	CustomUser customUser = null;    	
		
		if(StringUtils.isEmpty(user.getId())) {
			isNew = true;			
		}
		
		if (isNew) {
			customUser = new CustomUser();			
		} else {
			customUser = (CustomUser) userDao.findById(CustomUser.class, user.getId());	
		}			
		
		if(customUser != null) {
			customUser.setCode(user.getCode());
			customUser.setEmail(user.getEmail());
			customUser.setName(user.getName());
			customUser.setSurname(user.getSurname());
			
			SystemUser systemUser = new SystemUser();
			
			if(customUser.getSystemUser() != null) {
				systemUser = customUser.getSystemUser();
			}			
				
			systemUser.setEnabled(true);
			systemUser.setPassword("test");		
			systemUser.setFirstName(user.getName());
			systemUser.setSurname(user.getSurname());
			systemUser.setUsername(user.getUserName());
			userDao.persist(systemUser);    
			
			customUser.setSystemUser(systemUser);
			userDao.persist(customUser);
		}
		
		
    }

    @Secured("ROLE_ADMIN")
    public void delete(String userId) {
    	userDao.delete(userId);
    }

    @Transactional(readOnly = true)
    public UserListVO findByNameLike(int page, int maxResults, String name) {
        
    	int  count = executeQueryCountSearch(name);
    	List<CustomUser> customUserList = executeQueryFindByName(page, maxResults, name);
    	      
    	List<CustomUserDTO> customUsersDTO = new ArrayList<CustomUserDTO>();
    	
    	if(customUserList != null && customUserList.size() > 0) {
    		for (CustomUser customUser : customUserList) {
    			CustomUserDTO customUsersDto = new CustomUserDTO();
    			customUsersDto.setId(customUser.getId());
    			customUsersDto.setEmail(customUser.getEmail());
    			customUsersDto.setCode(customUser.getCode());
    			customUsersDto.setName(customUser.getName());
    			customUsersDto.setSurname(customUser.getSurname());
    			if(customUser.getSystemUser() != null) {
    				customUsersDto.setUserName(customUser.getSystemUser().getUsername());
    			}
    			customUsersDTO.add(customUsersDto);
			}
    	}
    	
        Page<CustomUserDTO> result = new Page<CustomUserDTO>(count, customUsersDTO);
        
        if(shouldExecuteSameQueryInLastPage(page, result)){
            int lastPage = result.getTotalPages() - 1;
            customUserList = executeQueryFindByName(lastPage, maxResults, name);
        }

        return buildResult(result);
    }

    private boolean shouldExecuteSameQueryInLastPage(int page, Page<CustomUserDTO> result) {
        return isUserAfterOrOnLastPage(page, result) && hasDataInDataBase(result);
    }

    private List<CustomUser> executeQueryFindAll(int page, int maxResults) {     
        return userDao.findAll(page, maxResults, "");
    }

    private int executeQueryCount() {     
        return userDao.findCount();
    }
    
    private int executeQueryCountSearch(String name) {     
        return userDao.findCountBySearch(name);
    }

    private UserListVO buildResult(Page<CustomUserDTO> result) {
        return new UserListVO(result.getTotalPages(), result.getTotalElements(), result.getContent());
    }

    private List<CustomUser> executeQueryFindByName(int page, int maxResults, String name) {     
        return userDao.findByNameLike(page, maxResults, "%" + name + "%", "");
    }

    private boolean isUserAfterOrOnLastPage(int page, Page<CustomUserDTO> result) {
        return page >= result.getTotal() - 1;
    }

    private boolean hasDataInDataBase(Page<CustomUserDTO> result) {
        return result.getTotalElements() > 0;
    }
    
}
