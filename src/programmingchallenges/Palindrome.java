package programmingchallenges;

public class Palindrome {
	
	public static boolean isPalindrome(String word) {
		if (word == null) {
            return false;
        }
		String chars = removeSpecialChars(word);
        int left = 0;
        int right = chars.length() - 1;
        while (left < right) {
            if (chars.charAt(left++) != chars.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
	
	private static String removeSpecialChars(String word) {
		return word.replaceAll("[^a-zA-Z]", "").toLowerCase();
	}
}
