package com.nguyenvanai.app.models;

public class Course extends AbstractEntity {
	
	private String majorId;
	private String lecturerId;
	
		
	public Course(String id, String name, String majorId,String lecturerId) {
		super.setId(id);
		super.setName(name);
		this.majorId = majorId;
		this.lecturerId = lecturerId;
	}
	
	

	public String getMajorId() {
		return majorId;
	}


	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
	}
	
	
	
	
}
