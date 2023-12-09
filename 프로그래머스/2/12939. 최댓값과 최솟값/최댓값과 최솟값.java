class Solution {
	public String solution(String s) {
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;

		for (String strNum : s.split(" ")) {
			long num = Long.parseLong(strNum);
			max = Math.max(max, num);
			min = Math.min(min, num);
		}

		return String.valueOf(min) + " " + String.valueOf(max);
	}
}