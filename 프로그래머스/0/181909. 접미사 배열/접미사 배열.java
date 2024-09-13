import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] arr = new String[my_string.length()];
        for(int i=1, len = my_string.length(); i <= len; i++) arr[i-1] = my_string.substring(len - i, len);
        Arrays.sort(arr);
        return arr;
    }
}