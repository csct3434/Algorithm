import java.util.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = new Scanner(System.in).nextInt();
        for(int i=1; i <= n; i++) sb.append("*".repeat(i)).append('\n');
        System.out.print(sb);
    }
}