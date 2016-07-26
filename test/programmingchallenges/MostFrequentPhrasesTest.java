package programmingchallenges;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static programmingchallenges.MostFrequentPhrases.mostFrequentPhrases;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MostFrequentPhrasesTest {
	
	@Test
	public void simpleFile() {
		List<Map.Entry<String,Integer>>  result = mostFrequentPhrases("resources", "phrases.txt");
		
		assertTrue(5 == result.get(0).getValue());
		assertEquals("This Job is better with Hadoop", result.get(0).getKey());
		assertEquals("Foobar Candy", result.get(1).getKey());
		assertEquals("Google",result.get(2).getKey());
	}
	
	@Test
	public void bigFile() {
		List<Map.Entry<String,Integer>>  result = mostFrequentPhrases("resources", "phrases_big_file.txt");

		assertEquals("gizmodo", result.get(0).getKey());
		assertTrue(107 == result.get(0).getValue());

		assertEquals("TechCrunch", result.get(1).getKey());
		assertTrue(106 == result.get(1).getValue());

		assertEquals("engadget", result.get(2).getKey());
		assertTrue(105 == result.get(2).getValue());

		assertEquals("amazondeals", result.get(3).getKey());
		assertTrue(104 == result.get(3).getValue());

		assertEquals("CNET", result.get(4).getKey());
		assertTrue(103 == result.get(4).getValue());

		assertEquals("gadgetlab", result.get(5).getKey());
		assertTrue(102 == result.get(5).getValue());

		assertEquals("mashable", result.get(6).getKey());
		assertTrue(101 == result.get(6).getValue());
	}
}
