import java.util.Stack;

class Solution {

	public int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return 5 * cities.length;
		}
		
		int answer = 0;

		Stack<String> stack = new Stack<>();

		for (String city : cities) {
			city = city.toLowerCase();

			int index = stack.search(city);
			if (index == -1) {
				answer += 5;
				if (stack.size() == cacheSize) {
					stack.remove(0);
				}
			} else {
				answer += 1;
				stack.remove(stack.size() - index);
			}
			stack.push(city);
		}

		return answer;
	}
}