package programmingchallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KComplementary {

	public static int find(int K, int[] arr) {
		int count = 0;
		Map<Integer, Integer> occ = new HashMap<Integer, Integer>();
		 
		for (int i : arr) {
			if (occ.get(i) == null) occ.put(i, 1);
			else occ.put(i, occ.get(i) + 1);
		}
		 
		Set<Integer> keys = occ.keySet();
		for (Integer key : keys) {
			int needed = K - key;
			if (occ.containsKey(needed)) {
				count += occ.get(key) * occ.get(needed);
			}
		}
		return count;
	}
}
