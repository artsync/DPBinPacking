package nl.arthurvlug.dpbinpacking;

import static org.junit.Assert.*;

import org.junit.Test;


public class ResultTest {
	@Test
	public void testResult() throws Exception {
		Result result = new Result();
		Result otherResult = new Result();
		assertEquals(result, otherResult);
	}

	@Test
	public void testNonEmpty() throws Exception {
		Result result = new Result(new Result(new Result(), new Item("b", 553, 516)), new Item("a", 3, 56));
		Result otherResult = new Result(new Result(new Result(), new Item("b", 553, 516)), new Item("a", 3, 56));
		assertEquals(result, otherResult);
	}
}
