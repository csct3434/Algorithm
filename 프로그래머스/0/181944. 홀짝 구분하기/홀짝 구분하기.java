import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.printf("%d is %s", n, n % 2 == 0 ? "even" : "odd");
    }
}