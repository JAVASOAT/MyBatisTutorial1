package com.soat.beans;

/**
 * @author formation
 *
 */
public class User {
	private Integer id;
	private String email;
	private String name;
	private String firstname;
	private String password;
	
	
	
	@Override
	public String toString() {
		return String.format("User [id=%s, email=%s, name=%s, firstname=%s, password=%s]", id, email, name, firstname, password);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public User(){
		super();
	}

	public User(String mail, String nom, String prenom, String password) {
		super();
		this.email = mail;
		this.name = nom;
		this.firstname = prenom;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String prenom) {
		this.firstname = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
