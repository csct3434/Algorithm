class Solution {
    public String solution(int a, int b) {
        int[] base = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        int day = base[a-1] + b;
        return switch(day % 7) {
            case 1 -> "FRI";
            case 2 -> "SAT";
            case 3 -> "SUN";
            case 4 -> "MON";
            case 5 -> "TUE";
            case 6 -> "WED";
            default -> "THU";
        };
    }
}