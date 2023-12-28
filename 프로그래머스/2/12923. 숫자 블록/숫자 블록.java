class Solution {

    public int[] solution(long b, long e) {
        int[] answer = new int[(int) (e - b + 1)];

        for (int i = 0; i < answer.length; i++) {
            int number = (int) b + i;

            answer[i] = 1;
            for (int div = 2; div <= Math.sqrt(number); div++) {
                if (number % div == 0) {
                    answer[i] = div;

                    if (number / div <= 10000000) {
                        answer[i] = number / div;
                        break;
                    }
                }
            }
        }

        if (b == 1) {
            answer[0] = 0;
        }

        return answer;
    }
}
