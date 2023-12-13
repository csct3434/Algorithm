import java.util.HashSet;

class Solution {

	public int[] solution(int n, String[] words) {
		HashSet<String> usedWords = new HashSet<>();

		char lastCharacter = words[0].charAt(0);
		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (usedWords.contains(word) || word.charAt(0) != lastCharacter) {
				return new int[]{1 + i % n, 1 + i / n};
			}

			usedWords.add(word);
			lastCharacter = word.charAt(word.length() - 1);
		}

		return new int[]{0, 0};
	}
}
