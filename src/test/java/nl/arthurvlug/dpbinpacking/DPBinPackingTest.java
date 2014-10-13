package nl.arthurvlug.dpbinpacking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class DPBinPackingTest {
	@Test
	public void testTakeNone() throws Exception {
		BinPacking dbBinPacking = new BinPacking(5, new ArrayList<Item>());
		Result items = dbBinPacking.packBins();
		Result expectedItems = new Result();
		assertEquals(expectedItems, items);
	}

	@Test
	public void testTakeOne() throws Exception {
		BinPacking dbBinPacking = new BinPacking(5, Arrays.asList(
				new Item("Banana", 1, 2)
		));
		Result items = dbBinPacking.packBins();
		Result expectedItems = new Result(
				new Item("Banana", 1, 2)
		);
		assertEquals(expectedItems, items);
	}

	@Test
	public void testTakeTwo() throws Exception {
		BinPacking dbBinPacking = new BinPacking(5, Arrays.asList(
				new Item("Banana", 1, 2),
				new Item("Apple", 2, 3)
		));
		Result items = dbBinPacking.packBins();
		Result expectedItems = new Result(
				new Item("Banana", 1, 2),
				new Item("Apple", 2, 3)
		);
		assertEquals(expectedItems, items);
	}
	
	@Test
	public void testTakeMany() throws Exception {
		BinPacking dbBinPacking = new BinPacking(5, Arrays.asList(
				new Item("Jewels", 5, 7),
				new Item("Banana", 1, 2),
				new Item("Gold", 4, 9),
				new Item("bike", 8, 4)
		));
		Result items = dbBinPacking.packBins();
		Result expectedItems = new Result(
				new Item("Banana", 1, 2),
				new Item("Gold", 4, 9)
		);
		assertEquals(expectedItems, items);
	}
	
	@Test
	public void testTakeSmart() throws Exception {
		BinPacking dbBinPacking = new BinPacking(9, Arrays.asList(
				new Item("Jewels", 5, 7),
				new Item("Banana", 1, 2),
				new Item("Gold", 4, 9),
				new Item("bike", 8, 4)
		));
		Result items = dbBinPacking.packBins();
		Result expectedItems = new Result(
				new Item("Jewels", 5, 7),
				new Item("Gold", 4, 9)
		);
		assertEquals(expectedItems, items);
	}
	
	
	

	
//	@Test
//	public void testIsAvailableYes() {
//		DPBinPacking dbBinPacking = new DPBinPacking(5, Arrays.asList(
//			new Item("a", 14, 51)
//		));
//		assertTrue(dbBinPacking.isAvailable(0, 0));
//	}
//	
//	@Test
//	public void testIsAvailableNo() {
//		DPBinPacking dbBinPacking = new DPBinPacking(5, Arrays.asList(
//				new Item("a", 14, 51),
//				new Item("b", 14, 51)
//		));
//		dbBinPacking.chooseItem(0);
//		assertFalse(dbBinPacking.isAvailable(0));
//		assertTrue(dbBinPacking.isAvailable(1));
//	}
}
