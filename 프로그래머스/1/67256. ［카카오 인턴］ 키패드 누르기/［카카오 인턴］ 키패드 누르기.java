class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        boolean rightHanded = hand.equals("right");
        int[] left = {3, 0}, right = {3, 2};
        for(int number : numbers) {
            number = number == 0 ? 10 : number - 1;
            switch(number % 3) {
                case 0:
                    left[0] = number / 3;
                    left[1] = 0;
                    answer.append('L');
                    break;
                case 2:
                    right[0] = number / 3;
                    right[1] = 2;
                    answer.append('R');
                    break;
                default:
                    int[] h = resolveHand(left, right, number, rightHanded);
                    h[0] = number / 3;
                    h[1] = 1;
                    answer.append(left == h ? 'L' : 'R');
            }
        }
        return answer.toString();
    }
    
    private int[] resolveHand(int[] left, int[] right, int targetNumber, boolean rightHanded) {
        int lDiff = Math.abs(left[0] - targetNumber / 3) + Math.abs(left[1] - targetNumber % 3);
        
        int rDiff = Math.abs(right[0] - targetNumber / 3) + Math.abs(right[1] - targetNumber % 3);
        
        if(lDiff == rDiff) return rightHanded? right : left;
        return lDiff < rDiff ? left : right;
    }
}