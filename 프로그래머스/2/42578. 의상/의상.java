import java.util.HashMap;

class Solution {

	public int solution(String[][] clothes) {
		HashMap<String, Integer> clothesInfo = new HashMap<>();
		for (String[] clothe : clothes) {
			clothesInfo.put(clothe[1], 1 + clothesInfo.getOrDefault(clothe[1], 1));
		}

		return clothesInfo.values().stream().reduce((a, b) -> a * b).orElse(1) - 1;
	}
}
