class Solution {
	public long solution(int n) {
		long answer = n;
		long back = 1; // 2칸 뒤
		long front = 2; // 1칸 뒤

		for (int i = 3; i <= n; i++) {
			answer = (back + front) % 1234567;
			back = front;
			front = answer;
		}

		return answer;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 50; i++) {
			System.out.println(new Solution().solution(i));
		}
	}
}