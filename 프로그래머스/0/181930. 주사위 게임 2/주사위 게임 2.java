class Solution {
    public int solution(int a, int b, int c) {
        int[] num = {a, b, c};
        int answer = 1, pow = (a == b && b == c) ? 3 : (a != b && b != c && c != a) ? 1 : 2;
        for (int i = 1; i <= pow; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += (int) Math.pow(num[j], i);
            }
            answer *= sum;
        }
        return answer;
    }
}