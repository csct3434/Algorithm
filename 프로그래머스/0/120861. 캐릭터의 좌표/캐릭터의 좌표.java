class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        for(String key : keyinput) {
            switch(key) {
                    case "up" -> answer[1] = Math.min(board[1] / 2, answer[1] + 1);
                    case "down" -> answer[1] = Math.max(-(board[1] / 2), answer[1] - 1);
                    case "right" -> answer[0] = Math.min(board[0] / 2, answer[0] + 1);
                    case "left" -> answer[0] = Math.max(-(board[0] / 2), answer[0] - 1);
            }
        }
        return answer;
    }
}