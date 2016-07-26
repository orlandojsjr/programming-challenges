package programmingchallenges;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static programmingchallenges.Palindrome.isPalindrome;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void palindrome() {
		assertTrue(isPalindrome("1221"));
		assertTrue(isPalindrome("arara"));
		assertTrue(isPalindrome("Sore was I ere I saw Eros."));
		assertTrue(isPalindrome("Never a foot too far, even."));
		assertTrue(isPalindrome("A new order began, a more Roman age bred Rowena."));

		assertFalse(isPalindrome("notpalindrome"));
		assertFalse(isPalindrome("x*******$$$a"));
		assertFalse(isPalindrome(null));
	}
}
