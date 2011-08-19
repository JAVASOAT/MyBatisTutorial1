package com.soat.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author formation
 * 
 */
public class Rent {
	private Integer id;
	private Date dateRent;
	private Date dateReturn;
	private Set<User> userSet = new HashSet<User>();
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Date getDateRent() {
		return dateRent;
	}

	public void setDateRent(Date dateRent) {
		this.dateRent = dateRent;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	public Set<User> getUserSet() {
		return userSet;
	}
}
