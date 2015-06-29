package com.angular.vo;

import java.io.Serializable;
import java.util.List;


public class CommonListVO implements Serializable{
	

	private static final long serialVersionUID = 7638088548995962036L;

	private int pagesCount;
	
    private long total;

    private String actionMessage;
    
    private String searchMessage;
    
    private List<?> content;
    
    
    public CommonListVO() {
    }

    public CommonListVO(int pages, long total, List<?> content) {
        this.pagesCount = pages;
        this.total = total;
        this.content = content;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }
	

    public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getContent() {
		return content;
	}

	public void setContent(List<?> content) {
		this.content = content;
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
