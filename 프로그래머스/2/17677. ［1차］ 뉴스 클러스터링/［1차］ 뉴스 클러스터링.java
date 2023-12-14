import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

	public int solution(String str1, String str2) {
		HashMap<String, Integer> tokenMap1 = new HashMap<>();
		HashMap<String, Integer> tokenMap2 = new HashMap<>();

		extractTokens(str1.toLowerCase(), tokenMap1);
		extractTokens(str2.toLowerCase(), tokenMap2);

		if (tokenMap1.size() + tokenMap2.size() == 0) {
			return 65536;
		}

		int intersectionSize = calcIntersectionSize(tokenMap1, tokenMap2);
		int unionSize = calcUnionSize(tokenMap1, tokenMap2);
		return 65536 * intersectionSize / unionSize;
	}

	public void extractTokens(String str, Map<String, Integer> tokenMap) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
				String token = str.substring(i, i + 2);
				Integer count = tokenMap.getOrDefault(token, 0);
				tokenMap.put(token, count + 1);
			}
		}
	}

	public int calcIntersectionSize(Map<String, Integer> tokenMap1, Map<String, Integer> tokenMap2) {
		int size = 0;

		for (String key : tokenMap1.keySet()) {
			if (tokenMap2.containsKey(key)) {
				size += Math.min(tokenMap1.get(key), tokenMap2.get(key));
			}
		}

		return size;
	}

	public int calcUnionSize(Map<String, Integer> map1, Map<String, Integer> map2) {
		int size = 0;
		
		HashSet<String> allKeys = new HashSet<>();
		allKeys.addAll(map1.keySet());
		allKeys.addAll(map2.keySet());

		for (String key : allKeys) {
			size += Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
		}
		
		return size;
	}
}
