class Solution {

    private int answer = Integer.MAX_VALUE;

    public int solution(String name) {
        solve(name, "A".repeat(name.length()), 0, 0);
        return answer;
    }

    private void solve(String correctName, String currentName, int pos, int count) {
        count += Math.min(Math.abs(correctName.charAt(pos) - currentName.charAt(pos)),
            Math.abs(currentName.charAt(pos) + 26 - correctName.charAt(pos)));

        char[] charArray = currentName.toCharArray();
        charArray[pos] = correctName.charAt(pos);
        String nextName = new String(charArray);

        if (nextName.equals(correctName)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 1; i < correctName.length(); i++) {
            int index = (pos + correctName.length() - i) % correctName.length();

            if (nextName.charAt(index) != correctName.charAt(index)) {
                solve(correctName, nextName, index, count + i);
                break;
            }
        }

        for (int i = 1; i < correctName.length(); i++) {
            int index = (pos + correctName.length() + i) % correctName.length();

            if (nextName.charAt(index) != correctName.charAt(index)) {
                solve(correctName, nextName, index, count + i);
                break;
            }
        }
    }
}