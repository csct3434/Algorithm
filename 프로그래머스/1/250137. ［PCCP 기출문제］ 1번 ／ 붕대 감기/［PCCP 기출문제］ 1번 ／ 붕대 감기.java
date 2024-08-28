class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttackTime = 0, hp = health, t = bandage[0], x = bandage[1], y = bandage[2];
        for(int[] attack : attacks) {
            int pastTime = attack[0] - lastAttackTime - 1;
            hp = Math.min(health, hp + (pastTime * x) + (pastTime / t) * y);
            if((hp -= attack[1]) <= 0) return -1;
            lastAttackTime = attack[0];
        }
        return hp;
    }
}