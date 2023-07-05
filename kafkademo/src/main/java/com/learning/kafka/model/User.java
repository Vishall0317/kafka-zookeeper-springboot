package com.learning.kafka.model;

public class User {
	
	private Integer id;
	private String name;
	private Long mobileNo;
	
	
	public User(Integer id, String name, Long mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
	}
	
	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + "]";
	}
	
}
