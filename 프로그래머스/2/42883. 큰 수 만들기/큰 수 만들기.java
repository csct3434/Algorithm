class Solution {

    public String solution(String number, int k) {
        int index = 0;
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder(number);

        while (count < k && index + 1 < stringBuilder.length()) {
            if (stringBuilder.charAt(index) < stringBuilder.charAt(index + 1)) {
                stringBuilder.deleteCharAt(index);
                count++;
                index = Math.max(index - 1, 0);
            } else {
                index++;
            }
        }

        return stringBuilder.substring(0, number.length() - k);
    }
}