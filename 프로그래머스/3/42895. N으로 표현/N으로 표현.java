import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1;
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        Set<Integer> used = new HashSet<>();
        dp.put(1, new HashSet<>(List.of(N)));
        used.add(N);
        for(int count = 2; count < 9; count++) {
            Set<Integer> temp = new HashSet<>();
            temp.add(Integer.parseInt(String.valueOf(N).repeat(count)));
            for(int i=1; i<count; i++) {
                for(int a : dp.get(i)) {
                    for(int b : dp.get(count - i)) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(List.of(a + b, a - b, a * b, b - a));
                        if(a != 0) list.add(b / a);
                        if(b != 0) list.add(a / b);
                        for(int l : list) {
                            if(used.contains(l)) continue;
                            used.add(l);
                            temp.add(l);
                        }
                    }
                }
            }
            for(int t : temp) if(t == number) return count;
            dp.put(count, temp);
        }
        return -1;
    }
}