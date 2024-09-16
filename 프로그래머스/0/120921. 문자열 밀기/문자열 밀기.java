class Solution {
    public int solution(String A, String B) {
        int len = A.length();
        char[] c = A.toCharArray();
        for(int i=0; i<len; i++) {
            char[] temp = new char[len];
            for(int j=0; j<len; j++) temp[(j + i) % len] = c[j];
            if (new String(temp).equals(B)) return i;
        }
        return -1;
    }
}