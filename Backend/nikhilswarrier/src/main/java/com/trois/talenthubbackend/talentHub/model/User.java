package com.trois.talenthubbackend.talentHub.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gson.annotations.SerializedName;
@Entity
public class User {
	@Id
	@SerializedName("userid")
	private int id;
	@SerializedName("username")
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
