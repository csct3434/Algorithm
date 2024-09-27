class Solution {
    public int solution(int[][] lines) {
        int[] a = new int[201];
        for(int[] line : lines) {
            for(int i=line[0]; i<line[1]; i++) {
                a[100 + i]++;
            }
        }
        int answer = 0;
        for(int i=0; i<201; i++) {
            if(a[i] > 1) answer++;
        }
        return answer;
    }
}