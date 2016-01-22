package com.question.lockpattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author vikhyatk
 * @category Test Class
 */
public class TestLockPatternValidator {

	private static List<int[]> sequenceList = new ArrayList<int[]>();
	private boolean result;

	static {

		// Exception generating cases
		sequenceList.add(new int[] { 1 });
		sequenceList.add(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		sequenceList.add(new int[] { 1, 10, 12 });
		sequenceList.add(null);

		// Invalid cases
		sequenceList.add(new int[] { 1, 2, 3, 1 });
		sequenceList.add(new int[] { 1, 7, 2 });
		sequenceList.add(new int[] { 1, 9, 2 });
		sequenceList.add(new int[] { 1, 3, 5 });
		sequenceList.add(new int[] { 7, 3, 2 });

		// Valid cases
		sequenceList.add(new int[] { 7, 6, 1 });
		sequenceList.add(new int[] { 7, 5, 1 });
		sequenceList.add(new int[] { 1, 8, 3 });
		sequenceList.add(new int[] { 1, 5, 9 });

	}

	/**
	 * Tests for less than minimum length
	 * 
	 * @throws PatternException
	 */
	@Test(expected = PatternException.class)
	public void test1() throws PatternException {

		result = LockPatternValidator.isPatternValid(sequenceList.get(0));
		//Method expects an exception on incorrect sequence
		System.out.println("Test for less than minimum length with values "
				+ Arrays.toString(sequenceList.get(0)) + ": " + result);		
		assertTrue(result);
	}

	/**
	 * Tests for more than maximum length
	 * 
	 * @throws PatternException
	 */
	@Test(expected = PatternException.class)
	public void test2() throws PatternException {
		System.out.println("Test for more than maximum length with values "
				+ Arrays.toString(sequenceList.get(1)));
		result = LockPatternValidator.isPatternValid(sequenceList.get(1));
		assertTrue(result);
	}

	/**
	 * Tests for range check
	 * 
	 * @throws PatternException
	 */
	@Test(expected = PatternException.class)
	public void test3() throws PatternException {
		System.out.println("Test for range check with values "
				+ Arrays.toString(sequenceList.get(2)));
		result = LockPatternValidator.isPatternValid(sequenceList.get(2));
		assertTrue(result);
	}

	/**
	 * Tests for empty pattern
	 * 
	 * @throws PatternException
	 */
	@Test(expected = PatternException.class)
	public void test4() throws PatternException {
		System.out.println("Test for empty pattern with values " + "\""
				+ Arrays.toString(sequenceList.get(3)) + "\"");
		result = LockPatternValidator.isPatternValid(sequenceList.get(3));
		assertTrue(result);
	}

	/**
	 * Tests for repetition
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test5() throws PatternException {

		result = LockPatternValidator.isPatternValid(sequenceList.get(4));
		
		System.out.println("Test for repetition with values "
				+ Arrays.toString(sequenceList.get(4)) + " : " + result);
		
		assertFalse(result);
	}

	/**
	 * Tests for difference of 2 in rows in same column
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test6() throws PatternException {
		
		result = LockPatternValidator.isPatternValid(sequenceList.get(5));
		System.out
				.println("Test for difference of 2 in rows in same column with values "
						+ Arrays.toString(sequenceList.get(5)) + " : " + result);
		
		assertFalse(result);
	}

	/**
	 * Tests for difference of 2 in rows and column
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test7() throws PatternException {
		result = LockPatternValidator.isPatternValid(sequenceList.get(6));
		System.out
				.println("Test for difference of 2 in rows and column with values "
						+ Arrays.toString(sequenceList.get(6)) + " : " + result);
		
		assertFalse(result);
	}

	/**
	 * Tests for difference of 2 in column in same row
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test8() throws PatternException {
		result = LockPatternValidator.isPatternValid(sequenceList.get(7));
		System.out
				.println("Test for difference of 2 in column in same row with values "
						+ Arrays.toString(sequenceList.get(7)) + " : " + result);
		
		assertFalse(result);
	}

	/**
	 * Tests for difference of 2 in column and row
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test9() throws PatternException {
		result = LockPatternValidator.isPatternValid(sequenceList.get(8));
		System.out
				.println("Test for difference of 2 in column and row with values "
						+ Arrays.toString(sequenceList.get(8)) + " : " + result);
		
		assertFalse(result);
	}

	/**
	 * Tests for difference of 2 in column and adjacent row
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test10() throws PatternException {
		result = LockPatternValidator.isPatternValid(sequenceList.get(9));
		System.out
				.println("Test for difference of 2 in column and adjacent row with values "
						+ Arrays.toString(sequenceList.get(9)) + " : " + result);
		
		assertTrue(result);
	}

	/**
	 * Tests for difference of 1 in column and adjacent row
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test11() throws PatternException {
		result = LockPatternValidator.isPatternValid(sequenceList.get(10));
		System.out
				.println("Test for difference of 1 in column and adjacent row with values "
						+ Arrays.toString(sequenceList.get(10)) + " : " + result);
		
		assertTrue(result);
	}

	/**
	 * Tests for difference of 2 in row and adjacent column
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test12() throws PatternException {
		result = LockPatternValidator.isPatternValid(sequenceList.get(11));
		System.out
				.println("Test for difference of 2 in row and adjacent column with values "
						+ Arrays.toString(sequenceList.get(11)) + " : " + result);
		
		assertTrue(result);
	}

	/**
	 * Tests for difference of 1 in row and adjacent column
	 * 
	 * @throws PatternException
	 */
	@Test
	public void test13() throws PatternException {
		result = LockPatternValidator.isPatternValid(sequenceList.get(12));
		System.out
				.println("Test for difference of 1 in row and adjacent column with values "
						+ Arrays.toString(sequenceList.get(12)) + " : " + result);
		
		assertTrue(result);

	}

}
