class Solution {
    public int solution(String s) {
        String[][] m = new String[][]{
            {"zero", "0"},
            {"one", "1"},
            {"two", "2"},
            {"three", "3"},
            {"four", "4"},
            {"five", "5"},
            {"six", "6"},
            {"seven", "7"},
            {"eight", "8"},
            {"nine", "9"},
        };
        for(int i=0; i<10; i++) {
            s = s.replace(m[i][0], m[i][1]);
        }
        return Integer.parseInt(s);
    }
}