class Solution {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int count = 0;

        for (long num = left; num <= right; num++, count++) {
            long base = (num / n) + 1;
            long rem = num % n;

            answer[count] = (int) base;

            if (rem >= base) {
                answer[count] += (int) (rem - base + 1);
            }
        }

        return answer;
    }
}