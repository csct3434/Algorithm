import java.util.*;

class Solution {
    public int solution(String binomial) {
        int[] num = Arrays.stream(binomial.replace(" " , "").split("[+*-]")).mapToInt(Integer::parseInt).toArray();
        if(binomial.indexOf("+") > 0) return num[0] + num[1];
        if(binomial.indexOf("-") > 0) return num[0] - num[1];
        return num[0] * num[1];
    }
}