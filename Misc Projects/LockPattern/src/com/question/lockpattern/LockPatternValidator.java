package com.question.lockpattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class contains static method to check the validity of phone unlocking
 * sequence
 * 
 * @author vikhyatk
 * 
 * 
 */
public class LockPatternValidator {

	private static final int MINLENGTH = 3; // Minimum length of the sequence
	private static final int MAXLENGTH = 9; // Maximum length of the sequence

	// coordinatesMap contains number as keys and coordinates as values
	private static Map<Integer, int[]> coordinatesMap = new HashMap<Integer, int[]>();

	// Static initializer block to populate the coordinatesMap
	static {
		int key = 1;
		for (int x = 0; x <= 2; x++) {
			for (int y = 0; y <= 2; y++) {
				// every number has coordinates attached to it as value
				coordinatesMap.put(key, new int[] { x, y });
				key++;
			}
		}
	}

	/**
	 * This method checks for the validation of the entered sequence
	 * 
	 * @param sequence
	 * @return boolean
	 * 
	 */
	public static boolean isPatternValid(int[] sequence)
			throws PatternException {

		int currData = -1; // current digit in the sequence
		int nextData = -1; // next digit in the sequence
		int fRow = -1, fCol = -1; // variables to hold coordinates of current
									// digit
		int sRow = -1, sCol = -1; // variables to hold coordinates of the next
									// digit

		if (isPatternWellFormed(sequence)) {
			// if pattern is valid only then the code proceeds

			for (int index = 0; index < sequence.length - 1; index++) {
				// loop to check each digit
				currData = sequence[index];
				nextData = sequence[1 + index];

				fRow = coordinatesMap.get(currData)[0]; // Coordinates of
														// current digit are
														// extracted from
														// coordinatesMap
				fCol = coordinatesMap.get(currData)[1];

				sRow = coordinatesMap.get(nextData)[0]; // Coordinates of next
														// digit are extracted
														// from coordinatesMap
				sCol = coordinatesMap.get(nextData)[1];

				if (Math.abs(fRow - sRow) == 2) { // condition to check if the
													// next digit belongs to
													// next to next ROW of the
													// current digit
					if (fCol == sCol || Math.abs(fCol - sCol) == 2) // condition
																	// to check
																	// the
																	// columns
																	// are same
																	// have
																	// difference
																	// of 2
					{
						return false;
					}
				}

				if (Math.abs(fCol - sCol) == 2) { // condition to check if the
													// next digit belongs to
													// next to next COLUMN of
													// the current digit
					if (fRow == sRow || Math.abs(fRow - sRow) == 2) // condition
																	// to check
																	// the row
																	// are same
																	// have
																	// difference
																	// of 2

					{
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method checks if the entered sequence is well-formed i.e. if it
	 * fulfills all the required constraints
	 * 
	 * @param sequence
	 * @return boolean
	 * @throws PatternException
	 */
	private static boolean isPatternWellFormed(int[] sequence)
			throws PatternException {

		if (sequence == null) // to check null
			throw new PatternException("The pattern is null");
		if (sequence.length < MINLENGTH) // to check minimum length
			throw new PatternException(
					"The length of pattern should be more than 2");
		if (sequence.length > MAXLENGTH) // to check maximum length
			throw new PatternException(
					"The length of pattern should be less than 9");

		Set<Integer> set = new HashSet<Integer>();

		for (int value : sequence) {
			if (value > 0 && value < 10) { // to check the range of numbers
											// added
				set.add(value);
			} else {
				throw new PatternException(
						"The number should be in range 1 - 9");
			}
		}

		if (set.size() != sequence.length) // to check repetition
			return false;

		return true;
	}
}
