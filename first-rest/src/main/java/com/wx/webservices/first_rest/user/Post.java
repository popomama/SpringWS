package com.wx.webservices.first_rest.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

	@Id
	@GeneratedValue
	Integer id;
	
	@Size(min=5)
	String description;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	User user;

	public Integer getId() {
		return id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
