class Solution {
    
    // 직선 방향
    private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    // 대각선 방향
    private static int[] dx2 = {-1, -1, 1, 1}, dy2 = {-1, 1, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = checkSafety(places[i]) ? 1 : 0;
        }
        return answer;
    }

    private boolean checkSafety(String[] places) {
        char[][] place = new char[5][5];
        for (int i = 0; i < 5; i++) {
            place[i] = places[i].toCharArray();
        }
        
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if(place[x][y] != 'P') {
                    continue;
                }
                
                // 직선 거리 1 확인
                for(int i=0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if(checkIndex(nx, ny) && place[nx][ny] == 'P') {
                        return false;
                    }
                }
                
                // 직선 거리 2 확인
                for(int i=0; i<4; i++) {
                    int nx = x + dx[i] * 2;
                    int ny = y + dy[i] * 2;
                    
                    if(checkIndex(nx, ny) && place[nx][ny] == 'P' && place[x + dx[i]][y + dy[i]] != 'X') {
                        return false;
                    }
                }
                
                // 대각선 거리 2 확인
                for(int i=0; i<4; i++) {
                    int nx = x + dx2[i];
                    int ny = y + dy2[i];
                    
                    if(checkIndex(nx, ny) && place[nx][ny] == 'P' && (place[x + dx2[i]][y] != 'X' || place[x][y + dy2[i]] != 'X')) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    
    private boolean checkIndex(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}