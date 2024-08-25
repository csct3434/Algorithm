class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] win = new boolean[46];
        for(int num : win_nums) {
            win[num] = true;
        }
        int count = 0, bonus = 0;
        for(int lotto : lottos) {
            if(win[lotto]) count++;
            else if(lotto == 0) bonus++;
        }
        return new int[]{Math.min(6, 7 - (count + bonus)), Math.min(6, 7 - count)};
    }
}