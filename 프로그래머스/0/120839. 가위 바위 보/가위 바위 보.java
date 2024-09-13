import java.util.stream.*;

class Solution {
    public String solution(String rsp) {
        int[] a = {0, 5, 2};
        return rsp.chars().mapToObj(i -> String.valueOf(a["205".indexOf(i)])).collect(Collectors.joining());
    }
}