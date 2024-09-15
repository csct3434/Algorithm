import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0], b = slicer[1], c = slicer[2];
        if(n==1) return Arrays.copyOfRange(num_list, 0, b+1);
        if(n==2) return Arrays.copyOfRange(num_list, a, num_list.length);
        if(n==3) return Arrays.copyOfRange(num_list, a, b+1);
        int[] ans = new int[1 + (b-a) / c];
        for(int i=0; i<ans.length; i++) {
            ans[i] = num_list[a + c * i];
        }
        return ans;
    }
}