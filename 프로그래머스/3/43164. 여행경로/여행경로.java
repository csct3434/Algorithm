import java.util.*;
import java.util.Map.Entry;

class Solution {

    String[] answer;

    public String[] solution(String[][] tickets) {
        Map<String, List<Ticket>> flight = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!flight.containsKey(ticket[0])) {
                flight.put(ticket[0], new ArrayList<>());
            }
            flight.get(ticket[0]).add(new Ticket(ticket[1]));
        }
        for(Entry<String, List<Ticket>> entry : flight.entrySet()) {
            entry.getValue().sort(Comparator.comparing(a -> a.dest));
        }
        List<String> route = new ArrayList<>();
        route.add("ICN");
        dfs(flight, tickets.length + 1, route);
        return answer;
    }

    private boolean dfs(Map<String, List<Ticket>> flight, int length, List<String> route) {
        if(route.size() == length) {
            answer = route.toArray(new String[0]);
            return true;
        }
        String from = route.get(route.size() - 1);
        if(!flight.containsKey(from)) return false;
        List<Ticket> tickets = flight.get(from);
        for(Ticket ticket : tickets) {
            if(ticket.used) continue;
            route.add(ticket.dest);
            ticket.used = true;
            if(dfs(flight, length, route)) {
                return true;
            }
            ticket.used = false;
            route.remove(route.size() - 1);
        }
        return false;
    }

    private static class Ticket {
        String dest;
        boolean used;
        public Ticket(String dest) {
            this.dest = dest;
            this.used = false;
        }
    }
}