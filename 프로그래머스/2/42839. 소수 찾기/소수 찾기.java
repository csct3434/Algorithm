import java.util.HashSet;
import java.util.Set;

class Solution {

    private Set<Integer> answer = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        int[] selected = new int[numbers.length()];

        for (int count = 1; count <= numbers.length(); count++) {
            solve(numbers.toCharArray(), visited, selected, 0, count);
        }

        return answer.size();
    }

    private void solve(char[] numbers, boolean[] visited, int[] selected, int depth, int count) {
        if (depth == count) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < count; i++) {
                stringBuilder.append(selected[i]);
            }
            int number = Integer.parseInt(stringBuilder.toString());

            if (isPrime(number)) {
                answer.add(number);
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = numbers[i] - '0';
                solve(numbers, visited, selected, depth + 1, count);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}