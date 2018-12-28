package com.kafka.model;

public class User {

	private String name;
	private String dept;
	private Long sal;
	
	public User(String name, String dept, Long sal) {
		this.name = name;
		this.dept = dept;
		this.sal = sal;
	}
	
	public User() {	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Long getSal() {
		return sal;
	}

	public void setSal(Long sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", dept=" + dept + ", sal=" + sal + "]";
	}
	
	
	
}
