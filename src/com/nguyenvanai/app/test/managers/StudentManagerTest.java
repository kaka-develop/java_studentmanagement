package com.nguyenvanai.app.test.managers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nguyenvanai.app.managers.StudentManager;
import com.nguyenvanai.app.models.Student;

public class StudentManagerTest {
	StudentManager manager = StudentManager.getInstance();

	String sId = "GC00704";
	String sName = "Ai";
	String sEmail = "ainvgc00704@fpt.edu.vn";
	String sPhone = "0123456789";
	String majorId = "M01";
	String batchId = "B01";

	// set up first
	@Before
	public void setup() {
		String id = sId;
		manager.add(new Student(id, "terry", sEmail, sPhone, majorId, batchId));
		id = "GC00701";
		manager.add(new Student(id, "Kaka", sEmail, sPhone, majorId, batchId));
		id = "GC00702";
		manager.add(new Student(id, sName, sEmail, sPhone, majorId, batchId));
	}

	// test add a student
	@Test
	public void testAddStudent() {

		String id = sId;

		boolean expectedResult = false;
		boolean result = manager.add(new Student(id, sName, sEmail, sPhone, majorId, batchId));
		assertEquals(expectedResult, result);

		id = "gc12";
		result = manager.add(new Student(id, sName, sEmail, sPhone, majorId, batchId));
		assertEquals(expectedResult, result);

	}

	@Test
	// test clear all students
	public void testClear() {

		boolean expectedResult = true;
		boolean result = manager.clear();
		assertEquals(expectedResult, result);
	}

	// test delete a student
	@Test
	public void testDelete() {

		boolean expectedResult = true;
		boolean result = manager.delete(sId);
		assertEquals(expectedResult, result);

		result = manager.delete("GC00702");
		assertEquals(expectedResult, result);
	}

	// test update a student
	@Test
	public void testUpdate() {
		boolean expectedResult = true;
		boolean result = manager.update(new Student(sId, "New Name", sEmail, "new Phone", majorId, batchId));
		assertEquals(expectedResult, result);

		expectedResult = false;
		result = manager.update(new Student("GC00708", "New Name", sEmail, "new Phone", majorId, batchId));
		assertEquals(expectedResult, result);
	}

	// validate student's email
	@Test
	public void testValidateEmail() {
		boolean expectedResult = true;
		boolean result = manager.validateEmail(sEmail);
		assertEquals(expectedResult, result);

		expectedResult = false;
		result = manager.validateEmail("asasa@sas");
		assertEquals(expectedResult, result);

		result = manager.validateEmail("@sas.");
		assertEquals(expectedResult, result);
	}

	// validate student's phone
	@Test
	public void testValidatePhone() {
		boolean expectedResult = true;
		boolean result = manager.validatePhone(sPhone);
		assertEquals(expectedResult, result);

		expectedResult = false;
		result = manager.validatePhone("1254-213");
		assertEquals(expectedResult, result);

		result = manager.validatePhone("1254");
		assertEquals(expectedResult, result);
	}

	// validate get json file name
	@Test
	public void testGetFileName() {
		String expectedResult = "students.json";
		String result = manager.getFileName();
		assertEquals(expectedResult, result);
	}


	// test load data
	@Test
	public void testLoadData() throws Exception {
		boolean expectedResult = true;
		boolean result = manager.loadData();
		assertEquals(expectedResult, result);
	}

	// test sort by ID
	@Test
	public void testSortByID() {
		String expectedResult = "GC00701";
		String result = manager.sortByID().get(0).getId();
		assertEquals(expectedResult, result);
	}

	// test sort by Name
	@Test
	public void testSortByName() {
		String expectedResult = "Ai";
		String result = manager.sortByName().get(0).getName();
		assertEquals(expectedResult, result);
	}
	
	
}
