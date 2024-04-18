import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Map<String, List<Integer>> conditionMap = makeConditionMap(info);
        
        for(int i=0; i<query.length; i++) {
            int score = Integer.parseInt(query[i].substring(query[i].lastIndexOf(" ") + 1));
            String condition = query[i].substring(0, query[i].lastIndexOf(" "));
            
            if(conditionMap.containsKey(condition)) {
                List<Integer> list = conditionMap.get(condition);
                answer[i] = list.size() - binarySearch(list, score);
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private Map<String, List<Integer>> makeConditionMap(String[] info) {
        Map<String, List<Integer>> conditionMap = new HashMap<>();
        
        for(String inf : info) {
            String condition = inf.substring(0, inf.lastIndexOf(" "));
            int score = Integer.parseInt(inf.substring(inf.lastIndexOf(" ") + 1));
            
            String[] tokens = condition.split(" ");
            
            for(int mask=0; mask < (1 << tokens.length); mask++) {
                String cond = "";
                
                for(int i=0; i < tokens.length; i++) {
                    if((mask & (1 << i)) > 0)   cond += tokens[i];
                    else cond += "-";
                    
                    if(i < tokens.length - 1) cond += " and ";    
                }
                
                if(!conditionMap.containsKey(cond)) {
                    conditionMap.put(cond, new ArrayList<Integer>());
                }
                conditionMap.get(cond).add(score);
            }
        }
       
        conditionMap.values().forEach(Collections::sort);
        
        return conditionMap;
    }
    
    private int binarySearch(List<Integer> list, int key) {
        int left = 0, right = list.size() - 1;
        
        while(left <= right) {
            int middle = (left + right) / 2;
            if(list.get(middle) < key) left = middle + 1;
            else right = middle - 1;
        }
        
        return left;
    }
}