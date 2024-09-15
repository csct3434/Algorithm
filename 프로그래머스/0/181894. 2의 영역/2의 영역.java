import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int l = -1, r = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 2) {
                l = i;
                break;
            }
        }
        if(l == -1) return new int[]{-1};
        for(int i=arr.length - 1; i>=0; i--) {
            if(arr[i] == 2) {
                r = i;
                break;
            }
        }
        return Arrays.copyOfRange(arr, l, r+1);
    }
}