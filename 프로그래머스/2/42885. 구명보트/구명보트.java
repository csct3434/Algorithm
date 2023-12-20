import java.util.Arrays;

class Solution {

	public int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		
		int light = 0, heavy = people.length - 1;
		while (light < heavy) {
			if(people[light] <= limit - people[heavy--]) {
				light++;
			}
			answer++;
		}

		return light == heavy? answer + 1 : answer;
	}
}