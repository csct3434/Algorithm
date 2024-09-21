import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] t = a.toCharArray();
        for(int i=0; i<t.length; i++) t[i] = Character.isLowerCase(t[i]) ? Character.toUpperCase(t[i]) : Character.toLowerCase(t[i]);
        System.out.print(new String(t));
    }
}