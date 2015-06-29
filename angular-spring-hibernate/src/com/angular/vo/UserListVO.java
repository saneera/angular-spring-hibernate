package com.angular.vo;

import java.util.List;

import com.angular.dto.CustomUserDTO;
import com.angular.model.CustomUser;

public class UserListVO {
    private int pagesCount;
    private long totalUsers;

    private String actionMessage;
    private String searchMessage;

    private List<CustomUserDTO> users;

    public UserListVO() {
    }

    public UserListVO(int pages, long totalUsers, List<CustomUserDTO> users) {
        this.pagesCount = pages;
        this.users = users;
        this.totalUsers = totalUsers;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }


	public List<CustomUserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<CustomUserDTO> users) {
		this.users = users;
	}

    public long getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}

	public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }

    public String getSearchMessage() {
        return searchMessage;
    }

    public void setSearchMessage(String searchMessage) {
        this.searchMessage = searchMessage;
    }
}