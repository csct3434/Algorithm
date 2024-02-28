import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        List<Integer> aDivs = getDivisiors(arrayA[0]);
        List<Integer> bDivs = getDivisiors(arrayB[0]);

        int aOfArrayA = calcA(aDivs, arrayA, arrayB);
        int aOfArrayB = calcA(bDivs, arrayB, arrayA);

        return Math.max(aOfArrayA, aOfArrayB);
    }

    private List<Integer> getDivisiors(int number) {
        LinkedList<Integer> divs = new LinkedList<>();
        for (int i = number; i >= 1; i--) {
            if (number % i == 0) {
                divs.add(i);
            }
        }
        return divs;
    }

    private int calcA(List<Integer> divs, int[] divisibleNumbers, int[] indivisibleNumbers) {
        for (Integer div : divs) {
            if (checkDivisible(divisibleNumbers, div) && checkIndivisible(indivisibleNumbers, div)) {
                return div;
            }
        }
        return 0;
    }

    private boolean checkDivisible(int[] array, int div) {
        for (int number : array) {
            if (number % div != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIndivisible(int[] array, int div) {
        for (int number : array) {
            if (number % div == 0) {
                return false;
            }
        }
        return true;
    }
}