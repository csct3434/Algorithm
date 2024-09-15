import java.util.stream.IntStream;

class Solution {
    public int solution(int i, int j, int k) {
        return (int) IntStream.rangeClosed(i, j).map(n -> String.valueOf(n).length() - String.valueOf(n).replace(""+k,"").length()).sum();
    }
}