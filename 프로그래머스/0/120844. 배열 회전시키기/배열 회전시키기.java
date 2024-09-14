class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int d = direction.equals("right") ? 1 : -1;
        for(int i=0; i<answer.length; i++) {
            answer[(i + answer.length + d) % answer.length] = numbers[i];
        }
        return answer;
    }
}