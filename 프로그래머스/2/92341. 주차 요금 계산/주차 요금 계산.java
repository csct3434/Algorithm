import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> totalTimes = new HashMap<>();
        Map<Integer, Integer> lastEntranceTimes = new HashMap<>();
        
        for(String record : records) {
            String[] tokens = record.split(" ");
            int recordTime = parseTime(tokens[0]);
            int carNumber = Integer.parseInt(tokens[1]);
            
            if(tokens[2].equals("IN")) {
                lastEntranceTimes.put(carNumber, recordTime);
                continue;
            }
            
            totalTimes.put(carNumber, totalTimes.getOrDefault(carNumber, 0) + recordTime - lastEntranceTimes.get(carNumber));
            lastEntranceTimes.remove(carNumber);
        }
        
        for(Integer carNumber : lastEntranceTimes.keySet()) {
            totalTimes.put(carNumber, totalTimes.getOrDefault(carNumber, 0) + 1439 - lastEntranceTimes.get(carNumber));
        }
        
        List<Integer> carNumbers = new LinkedList<>(totalTimes.keySet());
        Collections.sort(carNumbers);
        int[] answer = new int[carNumbers.size()];
        
        for(int i=0; i<carNumbers.size(); i++) {
            int carNumber = carNumbers.get(i);
            int totalTime = totalTimes.get(carNumber);
            answer[i] = fees[1];
            
            if(totalTime > fees[0]) {
                answer[i] += Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
            }            
        }
        
        return answer;
    }
    
    private int parseTime(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }
}