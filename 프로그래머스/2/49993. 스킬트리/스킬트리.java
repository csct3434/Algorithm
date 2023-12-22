import java.util.HashMap;

class Solution {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		HashMap<Character, Integer> priorityMap = new HashMap<>();
		
		for (int i = 0; i < skill.length(); i++) {
			priorityMap.put(skill.charAt(i), i);
		}

		for (String skillTree : skill_trees) {
			int lastPriority = -1;
			boolean possible = true;

			for (char c : skillTree.toCharArray()) {
				Integer currentPriority = priorityMap.get(c);
				if (currentPriority == null) {
					continue;
				}

				if (currentPriority != lastPriority + 1) {
					possible = false;
					break;
				}
				lastPriority = currentPriority;
			}

			if (possible) {
				answer++;
			}
		}

		return answer;
	}
}