class Solution {
    public String solution(String new_id) {
        String ans = new_id.toLowerCase().replaceAll("[^a-z0-9._-]", "").replaceAll("[.]{2,}", ".").replaceAll("^[.]|[.]$", "");
        ans = ans.isEmpty() ? "a" : ans;
        ans = ans.substring(0, Math.min(ans.length(), 15)).replaceAll("[.]$", "");
        return ans + String.valueOf(ans.charAt(ans.length() - 1)).repeat(Math.max(0, 3 - ans.length()));
    }
}