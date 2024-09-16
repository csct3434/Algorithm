class Solution {
    public int solution(int[] arr) {
        int x = 0;
        while(true) {
            boolean flag = false;
            for(int i=0; i<arr.length; i++) {
                int n = arr[i];
                if(arr[i] >= 50 && arr[i] % 2 == 0) n = arr[i] / 2;
                else if(arr[i] < 50 && arr[i] % 2 == 1) n = arr[i] * 2 + 1;
                if(n != arr[i]) flag = true;
                arr[i] = n;
            }
            if(!flag) return x;
            x++;
        }
    }
}