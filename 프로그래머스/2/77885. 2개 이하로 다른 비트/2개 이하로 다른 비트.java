class Solution {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;

        for (long number : numbers) {
            if (number % 2 == 0) {
                answer[index++] = number + 1;
                continue;
            }

            String binaryString = Long.toBinaryString(number);
            int idx = binaryString.lastIndexOf('0');

            String smallestBigNumber;
            if (idx == -1) {
                smallestBigNumber = "10" + binaryString.substring(1);
            } else {
                smallestBigNumber = binaryString.substring(0, idx) + "10" + binaryString.substring(idx + 2);
            }

            answer[index++] = Long.parseLong(smallestBigNumber, 2);
        }

        return answer;
    }
}