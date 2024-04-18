class Solution {
    
    public String solution(String m, String[] musicinfos) {        
        String answer = "(None)";
        int maxPlaytime = 0;
        
        String M = flatMelody(m);
        
        for(String info : musicinfos) {
            String[] token = info.split(",");
            int playtime = parsePlaytime(token[0], token[1]);
            String name = token[2];
            String melody = flatMelody(token[3]);
            
            String playedMelody = melody
                .repeat(playtime / melody.length())
                .concat(melody.substring(0, playtime % melody.length()));
                        
            if(playedMelody.contains(M) && playtime > maxPlaytime) {
                answer = name;
                maxPlaytime = playtime;
            }
        }
        
        return answer;
    }
    
    private int parsePlaytime(String start, String end) {
        int startTime = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
        int endTime = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
        return endTime - startTime;
    }
    
    private String flatMelody(String melody) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<melody.length(); i++) {
            if(melody.charAt(i) == '#') {
                sb.setCharAt(sb.length() - 1, Character.toUpperCase(sb.charAt(sb.length() - 1)));
            } else {
                sb.append(Character.toLowerCase(melody.charAt(i)));
            }
        }
        
        return sb.toString();
    }
}