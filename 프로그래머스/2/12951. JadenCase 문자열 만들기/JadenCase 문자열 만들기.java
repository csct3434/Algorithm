class Solution {

	public String solution(String s) {
		StringBuilder answer = new StringBuilder();
		boolean isBehindWhiteSpace = true;
		
		for(String token : s.toLowerCase().split("")) {
			answer.append(isBehindWhiteSpace? token.toUpperCase() : token);
			isBehindWhiteSpace = token.equals(" ");
		}

		return answer.toString();
	}
}
