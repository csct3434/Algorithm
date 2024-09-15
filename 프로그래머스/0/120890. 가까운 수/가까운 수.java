class Solution {
    public int solution(int[] array, int n) {
        int ans = array[0];
        for(int i=0; i<array.length; i++) {
            if(diff(array[i], n) < diff(ans, n) || diff(ans, n) == diff(array[i], n) && array[i] < ans) ans = array[i];
        }
        return ans;
    }
    
    private int diff(int a, int b) {
        return Math.abs(a - b);
    }
}