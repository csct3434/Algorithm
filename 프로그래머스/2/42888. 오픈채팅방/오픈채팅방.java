import java.util.HashMap;
import java.util.LinkedList;

class Solution {

    public String[] solution(String[] record) {
        LinkedList<String> answer = new LinkedList<>();
        HashMap<String, String> nickname = new HashMap<>();
        
        for (String r : record) {
            String[] token = r.split(" ");

            if (!token[0].equals("Leave")) {
                nickname.put(token[1], token[2]);
            }
        }

        for (String r : record) {
            String[] token = r.split(" ");

            if (token[0].equals("Enter")) {
                answer.add(nickname.get(token[1]) + "님이 들어왔습니다.");
            } else if (token[0].equals("Leave")) {
                answer.add(nickname.get(token[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}