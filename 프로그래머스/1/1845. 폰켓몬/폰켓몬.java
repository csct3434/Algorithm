import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int num : nums) {
            numbers.add(num);
        }
        
        return numbers.size() < nums.length / 2 ? numbers.size() : nums.length / 2;
    }
}