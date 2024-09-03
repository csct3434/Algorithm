import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<String, int[]> dxdys = new HashMap<>();
        dxdys.put("E", new int[]{0, 1});
        dxdys.put("W", new int[]{0, -1});
        dxdys.put("S", new int[]{1, 0});
        dxdys.put("N", new int[]{-1, 0});
        int x = 0, y = 0, H = park.length, W = park[0].length();
        boolean found = false;
        for(int i=0; i < H; i++) {
            for(int j=0; j < W; j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        for(String route : routes) {
            String[] token = route.split(" ");
            int[] dxdy = dxdys.get(token[0]);
            int distance = Integer.parseInt(token[1]);
            int nx = x + dxdy[0] * distance, ny = y + dxdy[1] * distance;
            if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
            boolean flag = true;
            for(int i=1; i<=distance; i++) {
                if(park[x + dxdy[0] * i].charAt(y + dxdy[1] * i) == 'X') {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                x = nx;
                y = ny;
            }
        }
        return new int[]{x, y};
    }
}