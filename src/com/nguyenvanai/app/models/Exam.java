package com.nguyenvanai.app.models;

public class Exam extends AbstractEntity {

	private String content;
	private String mark;
	private String studentId;
	private String courseId;
	
	
	public Exam(String id, String name, String content, String mark, String studentId, String courseId) {
		super.setId(id);
		super.setName(name);
		this.content = content;
		this.mark = mark;
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
