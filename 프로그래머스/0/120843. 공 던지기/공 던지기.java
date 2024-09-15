class Solution {
    public int solution(int[] numbers, int k) {
        return numbers[(--k * 2) % numbers.length];
    }
}