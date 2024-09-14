class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int number : numbers) if((answer+=number) > n) return answer;
        return -1;
    }
}