import java.util.*;

class Solution {
    
    private static class Request {
        int start;
        int end;
        public Request(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        int answer = 0;
        List<Request> requests = init(lines);
        int from, to, count;
        for(int i=0, total = requests.size(); i < total; i++) {
            Request req = requests.get(i);
            from = req.end;
            to = from + 999;
            count = 1;
            for(int j=i-1; j>=0; j--) if(requests.get(j).end == from) count++;
            for(int j=i+1; j<total; j++) if(requests.get(j).start <= to) count++;
            answer = Math.max(answer, count);
        }
        return answer;
    }
    
    public List<Request> init(String[] lines) {
        List<Request> list = new ArrayList<>();
        int startTime, endTime, processTime;
        for(String line : lines) {
            String[] tokens = line.split(" ");
            int[] e = Arrays.stream(tokens[1].replace(".", ":").split(":")).mapToInt(s -> Integer.parseInt(s)).toArray();
            endTime = (e[0] * 3600 + e[1] * 60 + e[2]) * 1000 + e[3];
            startTime = endTime - (int) ((Double.parseDouble(tokens[2].substring(0, tokens[2].length() - 1))) * 1000) + 1;
            list.add(new Request(startTime, endTime));
        }
        return list;
    }
}