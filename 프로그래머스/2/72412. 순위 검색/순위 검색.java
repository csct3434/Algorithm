import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Map<String, List<Integer>> conditionMap = makeConditionMap(info);
        
        for(int i=0; i<query.length; i++) {
            int score = Integer.parseInt(query[i].substring(query[i].lastIndexOf(" ") + 1));
            
            for(String condition : extractConditions(query[i])) {
                condition = condition.trim();
                if(conditionMap.containsKey(condition)) {
                    List<Integer> list = conditionMap.get(condition);
                    answer[i] += list.size() - binarySearch(list, score);
                }
            }
        }
        
        return answer;
    }
    
    private Map<String, List<Integer>> makeConditionMap(String[] info) {
        Map<String, List<Integer>> conditionMap = new HashMap<>();
        
        for(String inf : info) {
            String condition = inf.substring(0, inf.lastIndexOf(" "));
            int score = Integer.parseInt(inf.substring(inf.lastIndexOf(" ") + 1));
            
            if(!conditionMap.containsKey(condition)) {
                conditionMap.put(condition, new ArrayList<Integer>());
            }
            
            conditionMap.get(condition).add(score);
        }
        
        for(List<Integer> list : conditionMap.values()) {
            Collections.sort(list);
        }
        
        return conditionMap;
    }
    
    private static String[][] TOKENS = {{"cpp", "java", "python"}, {"backend", "frontend"}, {"junior", "senior"}, {"chicken", "pizza"}};
    
    private List<String> extractConditions(String query) {
        String[] queryTokens = query.substring(0, query.lastIndexOf(" ")).split(" and ");
        
        List<String> conditions = new LinkedList<>();
        conditions.add("");
        
        for(int i=0; i<4; i++) {
            String queryToken = queryTokens[i];
            
            List<String> temp = new LinkedList<>();
            
            for(String condition : conditions) {
                if(queryToken.equals("-")) {
                    Arrays.stream(TOKENS[i]).forEach(token -> temp.add(condition + " " + token));
                } else {
                    temp.add(condition + " " + queryToken);
                }
            }
            
            conditions = temp;
        }
        
        return conditions;
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