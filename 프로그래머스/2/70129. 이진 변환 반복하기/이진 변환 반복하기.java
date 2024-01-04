class Solution {

    public int[] solution(String s) {
        int rep = 0;
        int count = 0;

        while (!s.equals("1")) {
            rep++;

            String sWithoutZero = s.replace("0", "");
            count += s.length() - sWithoutZero.length();
            
            s = Integer.toBinaryString(sWithoutZero.length());
        }
        
        return new int[]{rep, count};
    }
}