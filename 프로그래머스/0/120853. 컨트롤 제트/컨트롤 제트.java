class Solution {
    public int solution(String s) {
        int sum = 0, prev = 0;
        for(String t : s.split(" ")) {
            if(t.equals("Z")) sum -= prev;
            else {
                int n = Integer.parseInt(t);
                sum += n;
                prev = n;
            }
        }
        return sum;
    }
}