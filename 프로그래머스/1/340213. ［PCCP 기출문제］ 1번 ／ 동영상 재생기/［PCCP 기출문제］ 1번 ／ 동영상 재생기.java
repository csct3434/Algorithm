class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = convert(video_len), position = convert(pos), opStart = convert(op_start), opEnd = convert(op_end);
        if(opStart <= position && position <= opEnd) position = opEnd;
        for(String command : commands) {
            if(command.equals("prev")) {
                position = Math.max(0, position - 10);
            } else {
                position = Math.min(videoLen, position + 10);
            }
            if(opStart <= position && position <= opEnd) position = opEnd;
        }
        return convert(position);
    }
    
    private String convert(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
    
    private int convert(String time) {
        String[] token = time.split(":");
        return Integer.parseInt(token[0]) * 60 + Integer.parseInt(token[1]);
    }
}