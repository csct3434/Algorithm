import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

	public int solution(String str1, String str2) {
		Map<String, Long> tokenMap1 = extractTokenMap(str1.toLowerCase());
		Map<String, Long> tokenMap2 = extractTokenMap(str2.toLowerCase());

		if (tokenMap1.equals(tokenMap2)) {
			return 65536;
		}

		int intersectionSize = calcIntersectionSize(tokenMap1, tokenMap2);
		int unionSize = calcUnionSize(tokenMap1, tokenMap2);
		return 65536 * intersectionSize / unionSize;
	}

	public Map<String, Long> extractTokenMap(String str) {
		return IntStream.range(0, str.length() - 1)
			.mapToObj(i -> str.substring(i, i + 2))
			.filter(token -> token.chars().allMatch(Character::isAlphabetic))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	public int calcIntersectionSize(Map<String, Long> tokenMap1, Map<String, Long> tokenMap2) {
		return tokenMap1.keySet().stream()
			.filter(tokenMap2::containsKey)
			.map(key -> Math.min(tokenMap1.getOrDefault(key, 0L), tokenMap2.getOrDefault(key, 0L)))
			.mapToInt(Long::intValue)
			.sum();
	}

	public int calcUnionSize(Map<String, Long> map1, Map<String, Long> map2) {
		map1.forEach((key, value) -> map2.put(key, Math.max(value, map2.getOrDefault(key, 0L))));
		return map2.values().stream().mapToInt(Long::intValue).sum();
	}
}
