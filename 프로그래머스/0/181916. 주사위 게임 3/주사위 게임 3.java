import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] t = {a,b,c,d};
        Arrays.sort(t);
        if(t[0] == t[1] && t[1] == t[2] && t[2] == t[3]) return 1111 * t[0];
        if(t[0] == t[1] && t[1] == t[2]) return (t[0] * 10 + t[3]) * (t[0] * 10 + t[3]);
        if(t[1] == t[2] && t[2] == t[3]) return (t[1] * 10 + t[0]) * (t[1] * 10 + t[0]);
        if(t[0] == t[1] && t[2] == t[3]) return (t[0] + t[2]) * (t[2] - t[0]);
        if(t[0] == t[1]) return t[2] * t[3];
        if(t[1] == t[2]) return t[0] * t[3];
        if(t[2] == t[3]) return t[0] * t[1];
        return t[0];
    }
}