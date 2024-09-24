class Solution {
    public int[] solution(int[] arr) {
        double d = Math.log(arr.length) / Math.log(2);
        int[] answer = new int[d % 1 == 0 ? arr.length : (int) Math.pow(2, (int) d + 1)];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        return answer;
    }
}