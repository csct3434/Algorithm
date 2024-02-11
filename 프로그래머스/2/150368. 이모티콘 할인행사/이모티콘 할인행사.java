class Solution {

    private int subscribe = 0;
    private int purchase = 0;

    private static int[] rate = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        func(users, emoticons, new int[emoticons.length], 0);
        return new int[]{subscribe, purchase};
    }

    private void func(int[][] users, int[] emoticons, int[] discount, int count) {
        if (count == emoticons.length) {
            solve(users, emoticons, discount);
            return;
        }

        for (int i = 0; i < 4; i++) {
            discount[count] = rate[i];
            func(users, emoticons, discount, count + 1);
        }
    }

    private void solve(int[][] users, int[] emoticons, int[] discount) {
        int[] purchaseAmount = new int[users.length];

        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < emoticons.length; j++) {
                if (users[i][0] <= discount[j]) {
                    purchaseAmount[i] += (emoticons[j] / 100) * (100 - discount[j]);
                }
            }
        }

        int sub = 0, total = 0;
        for (int i = 0; i < users.length; i++) {
            if (purchaseAmount[i] >= users[i][1]) {
                sub++;
            } else {
                total += purchaseAmount[i];
            }
        }

        if (sub > subscribe) {
            subscribe = sub;
            purchase = total;
        }
        
        if (sub == subscribe) {
            purchase = Math.max(purchase, total);
        }
    }
}
