import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable) {
            pq.add(convertToMinutes(time));
        }
        int time = 540 - t, capacity = m, lastBoardTime = 0;
        while(n-- > 0) {
            time += t;
            capacity = m;
            while(capacity > 0 && !pq.isEmpty() && pq.peek() <= time) {
                lastBoardTime = pq.remove();
                capacity--;
            }
        }
        if(capacity > 0) return convertToString(time);
        return convertToString(lastBoardTime - 1);
    }

    private int convertToMinutes(String time) {
        String[] token = time.split(":");
        return Integer.parseInt(token[0]) * 60 + Integer.parseInt(token[1]);
    }

    private String convertToString(int minutes) {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
    }
}