class Solution {

    public int[] solution(long b, long e) {
        int begin = Math.toIntExact(b);
        int end = Math.toIntExact(e);

        int[] answer = new int[end - begin + 1];
        int number = begin;

        if (begin == 1) {
            answer[0] = 0;
            number = 2;
        }

        for (; number <= end; number++) {
            int index = number - begin;

            answer[index] = 1;
            for (int div = 2; div <= Math.sqrt(number); div++) {
                if(number % div == 0) {
                    answer[index] = div;
                    if (number / div <= 10000000) {
                        answer[index] = number / div;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
