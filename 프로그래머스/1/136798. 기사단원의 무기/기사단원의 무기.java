import java.util.stream.*;

class Solution {
    public int solution(int number, int limit, int power) {
        return IntStream.rangeClosed(1, number)
            .map(n -> {
                int count = countYaksu(n);
                return count > limit ? power : count;
            })
            .sum();
    }
    
    private int countYaksu(int num) {
        int count = Math.sqrt(num) % 1 == 0 ? 1 : 0;
        for(int i=1; i * i < num; i++) {
            if(num % i == 0) count+=2;;
        }
        return count;
    }
}