import java.util.ArrayList;
import java.util.HashMap;

class Solution {

	public int[] solution(String msg) {
		ArrayList<Integer> answer = new ArrayList<>();

		HashMap<String, Integer> dict = new HashMap<>();
		for (char c = 'A'; c <= 'Z'; c++) {
			dict.put(String.valueOf(c), c - 'A' + 1);
		}

		while (!msg.isEmpty()) {
			int len = 1;

			while (++len <= msg.length()) {
				if (!dict.containsKey(msg.substring(0, len))) {
					break;
				}
			}
			len--;

			answer.add(dict.get(msg.substring(0, len)));
			if (len + 1 <= msg.length()) {
				dict.put(msg.substring(0, len + 1), dict.size() + 1);
			}
			msg = msg.substring(len);
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}