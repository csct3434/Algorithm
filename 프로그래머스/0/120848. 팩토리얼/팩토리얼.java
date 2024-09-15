class Solution {
    public int solution(int n) {
        int i = 1, val = 1;
        while(true) if((val *= ++i) > n) return --i;
    }
}