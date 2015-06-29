package com.angular.pagination;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{
	
	private static final long serialVersionUID = 8622930013769037204L;
	
	private boolean hasNext;
	
	private long total;
	
	private int numOfPages;
	
	private List<T> content;
	
	private int pageSize = 5;//default 5
	
	private int currentPageNumber;
		
	
	public Page(long total, List<T> content) {
		super();
		this.total = total;
		this.content = content;
	}

	public int getNumOfPages() {
		return (int) (this.total != 0 ? this.total/ this.pageSize : 0);
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean hasNext() {
		return hasNext;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public boolean hasContent() {
		return !content.isEmpty();
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	
	public boolean hasPrevious() {
		return getCurrentPageNumber() > 0;
	}

	public boolean isFirst() {
		return !hasPrevious();
	}
	
	public boolean isLast() {
		return !hasNext();
	}

	public int getTotalElements() {		
		return (int) getTotal();
	}

	public int getTotalPages() {
		return (int) (this.total != 0 ? (this.total/ this.pageSize)+1 : 0);
	}
}
