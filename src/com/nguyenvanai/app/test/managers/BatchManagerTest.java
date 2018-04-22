package com.nguyenvanai.app.test.managers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nguyenvanai.app.managers.BatchManager;
import com.nguyenvanai.app.models.Batch;

public class BatchManagerTest {

	BatchManager manager = BatchManager.getInstance();

	String bId = "B01";
	String bName = "Room B01";

	// setup data
	@Before
	public void setup() {
		String id = bId;
		manager.add(new Batch(id, bName));
		id = "B02";
		manager.add(new Batch(id, "Room " + id));
		id = "B03";
		manager.add(new Batch(id, "Room " + id));
	}

	// test add a batch
	@Test
	public void testAddBatch() {
		String id = bId;
		boolean expectedResult = false;
		boolean result = manager.add(new Batch(id, bName));
		assertEquals(expectedResult, result);

		id = "B0001";
		expectedResult = false;
		result = manager.add(new Batch(id, bName));
		assertEquals(expectedResult, result);
	}

	// test get json file Name
	@Test
	public void testGetFileName() {
		String expectedResult = "batches.json";
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
