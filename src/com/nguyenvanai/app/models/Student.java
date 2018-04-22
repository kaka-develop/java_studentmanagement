package com.nguyenvanai.app.models;

public class Student extends AbstractEntity {

	private String email;
	private String phone;
	private String majorId;
	private String batchId;
	
	
	public Student(String id, String name, String email, String phone,String batchId, String majorId ){
		super.setId(id);
		super.setName(name);
		this.email = email;
		this.phone = phone;
		this.majorId = majorId;
		this.batchId = batchId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	
	

	

}
