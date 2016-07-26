package programmingchallenges;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static programmingchallenges.KComplementary.find;

import org.junit.Test;

public class KComplementaryTest {
	
	@Test
	public void KComplementarytest() {
		int arr[] = {1, 8, -3, 0, 1, 3, -2, 4, 5};
		assertTrue(find(2, arr) == 8);
		assertTrue(find(3, arr) == 4);
		assertTrue(find(5, arr) == 8);
		assertTrue(find(6, arr) == 7);
		assertFalse(find(8, arr) == 1);
	}

}
