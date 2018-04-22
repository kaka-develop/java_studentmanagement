package com.nguyenvanai.app.managers;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.reflect.TypeToken;
import com.nguyenvanai.app.models.Student;

public class StudentManager extends AbstractManager {

	private static final StudentManager instance = new StudentManager();

	public static StudentManager getInstance() {
		return instance;
	}
	
	
	// delete a student in map
	public boolean delete(String id) {
		if (isExisted(id)) {
			getMap().remove(id);
			
			return true;
		}
		return false;
	}

	// update a student in map
	public boolean update(Student student) {
		if (isExisted(student.getId())) {
			getMap().replace(student.getId(), student);
			return true;
		}
		return false;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "students.json";
	}

	@Override
	Type getListType() {
		Type listType = new TypeToken<Collection<Student>>() {
		}.getType();
		return listType;
	}

	@Override
	boolean validateID(String id) {
		String pattern = "gc[0-9]{5}$";
		Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(id);
		return m.find();
	}
	
	// validate email of student
	public boolean validateEmail(String email){
		return ValidationManager.validateEmail(email);
	}

	// validate phone number of student
	public boolean validatePhone(String phone){
		return ValidationManager.validatePhone(phone);
	}
}
