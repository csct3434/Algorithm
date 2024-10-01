class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int s = queries[i][0], e = queries[i][1], k = queries[i][2];
            int t = Integer.MAX_VALUE;
            for(int j=s; j<=e; j++) {
                if(arr[j] > k && arr[j] < t) t = arr[j];
            }
            answer[i] = t == Integer.MAX_VALUE ? -1 : t;
        }
        return answer;
    }
}