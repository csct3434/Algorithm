import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int N = park.length, M = park[0].length;
        for(int s : Arrays.stream(mats).boxed().sorted((a, b) -> b - a).collect(Collectors.toList())) {
            for(int i=0; i<=N-s; i++) {
                for(int j=0; j<=M-s; j++) {
                    boolean flag = true;
                    for(int k=i; k<i+s; k++) {
                        for(int l=j; l<j+s; l++) {
                            if(!park[k][l].equals("-1")) {
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;
                    }
                    if(flag) return s;
                }
            }
        }
        return -1;
    }
}