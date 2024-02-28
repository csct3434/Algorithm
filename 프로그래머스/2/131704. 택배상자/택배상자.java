import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public int solution(int[] orders) {
        int answer = 0;

        Queue<Integer> mainContainer = IntStream.rangeClosed(1, orders.length).boxed()
            .collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> subContainer = new Stack<>();

        for (int order : orders) {
            while (!mainContainer.isEmpty() && order > mainContainer.peek()) {
                subContainer.push(mainContainer.poll());
            }

            if (!mainContainer.isEmpty() && order == mainContainer.peek()) {
                mainContainer.poll();
                answer++;
                continue;
            }

            if (!subContainer.isEmpty() && order == subContainer.peek()) {
                subContainer.pop();
                answer++;
                continue;
            }

            break;
        }

        return answer;
    }
}