import java.util.Arrays;

class Solution {

    public int solution(int[] citations) {
        int answer = 0;
        int total = citations.length;

        Arrays.sort(citations);

        int index = 0;
        for (int h = 0; h <= total; h++) {

            while (index < total) {
                if (citations[index] < h) {
                    index++;
                } else {
                    break;
                }
            }

            if (h <= total - index) {
                answer = h;
            } else {
                break;
            }
        }

        return answer;
    }
}
