package com.nguyenvanai.app.test.managers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nguyenvanai.app.managers.ExamManager;
import com.nguyenvanai.app.models.Exam;

public class ExamManagerTest {
	ExamManager manager = ExamManager.getInstance();

	String eId = "B01";
	String eName = "Room B01";
	String eContent = "Student Management System";
	String eMark = "distinction";
	String studentId = "GC00704";
	String courseId = "C01";

	// setup data
	@Before
	public void setup() {
		String id = eId;
		manager.add(new Exam(id, eName, eContent, eMark,studentId,courseId));
		id = "E02";
		manager.add(new Exam(id, eName, eContent, eMark,studentId,courseId));
		id = "E03";
		manager.add(new Exam(id, eName, eContent, eMark,studentId,courseId));
	}

	// test add a exam
	@Test
	public void testAddExam() {
		String id = eId;
		boolean expectedResult = false;
		boolean result = manager.add(new Exam(id, eName, eContent, eMark,studentId,courseId));
		assertEquals(expectedResult, result);

		id = "E0001";
		expectedResult = false;
		result = manager.add(new Exam(id, eName, eContent, eMark,studentId,courseId));
		assertEquals(expectedResult, result);
	}

	// test get json file Name
	@Test
	public void testGetFileName() {
		String expectedResult = "exams.json";
		String result = manager.getFileName();
		assertEquals(expectedResult, result);
	}

	// test save data
	@Test
	public void testSaveData() {
		boolean expectedResult = true;
		boolean result = manager.save();
		assertEquals(expectedResult, result);
	}

	// test load data
	@Test
	public void testLoadData() throws Exception {
		boolean expectedResult = true;
		boolean result = manager.loadData();
		assertEquals(expectedResult, result);
	}
}
