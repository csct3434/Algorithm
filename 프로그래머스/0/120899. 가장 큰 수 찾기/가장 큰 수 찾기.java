class Solution {
    public int[] solution(int[] array) {
        int value = -1, idx = 0;
        for(int i=0; i < array.length; i++) {
            if(array[i] > value) {
                value=array[i];
                idx = i;
            }
        }
        return new int[]{value, idx};
    }
}