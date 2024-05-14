import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] parent = new int[enroll.length];
        int[] profit = new int[enroll.length];
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<enroll.length; i++) {
            indexMap.put(enroll[i], i);
        }
        for(int i=0; i<referral.length; i++) {
            if(referral[i].equals("-")) parent[i] = -1;
            else parent[i] = indexMap.get(referral[i]);
        }
        for(int i=0; i<seller.length; i++) {
            int idx = indexMap.get(seller[i]);
            sell(parent, profit, idx, amount[i] * 100);
        }
        return profit;
    }
    
    public void sell(int[] parent, int[] profit, int idx, int amount) {
        int commission = amount / 10;
        profit[idx] += amount - commission;
        if(commission > 0 && parent[idx] != -1) {
            sell(parent, profit, parent[idx], commission);
        }
    }
}