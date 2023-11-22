package com.crud.bean;

import java.util.Date;

public class BoardVO {
	private int id;
	private String name;
	private String hguid;
	private int age;
	private String gender;
	private String email;
	private String major;
	private String rc;
	private String nickname;
	private String club;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHguid() {
		return hguid;
	}
	public void setHguid(String hguid) {
		this.hguid = hguid;
	}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {return email;}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {return major;}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getRc() {return rc;}
	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getNickname() {return nickname;}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getClub() {return club;}
	public void setClub(String club) {
		this.club = club;
	}

}
