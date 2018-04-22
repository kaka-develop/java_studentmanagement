package com.nguyenvanai.app.test.managers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nguyenvanai.app.managers.MajorManager;
import com.nguyenvanai.app.models.Major;

public class MajorManagerTest {
	MajorManager manager = MajorManager.getInstance();

	String cId = "M01";
	String mName = "Java Major";

	// setup data
	@Before
	public void setup() {
		String id = cId;
		manager.add(new Major(id, mName));
		id = "M02";
		manager.add(new Major(id, mName));
		id = "M03";
		manager.add(new Major(id, mName));
	}

	// test add a major
	@Test
	public void testAddMajor() {
		String id = cId;
		boolean expectedResult = false;
		boolean result = manager.add(new Major(id, mName));
		assertEquals(expectedResult, result);

		id = "C0001";
		expectedResult = false;
		result = manager.add(new Major(id, mName));
		assertEquals(expectedResult, result);
	}

	// test get json file Name
	@Test
	public void testGetFileName() {
		String expectedResult = "majors.json";
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
