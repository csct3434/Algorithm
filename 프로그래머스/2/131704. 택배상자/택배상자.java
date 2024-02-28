import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public int solution(int[] orders) {
        int answer = 0;

        List<Integer> mainContainer = IntStream.rangeClosed(1, orders.length).boxed()
            .collect(Collectors.toCollection(LinkedList::new));

        Stack<Integer> subContainer = new Stack<>();

        for (int order : orders) {
            while (true) {
                if (!mainContainer.isEmpty() && order > mainContainer.get(0)) {
                    subContainer.push(mainContainer.remove(0));
                } else {
                    break;
                }
            }

            if (!mainContainer.isEmpty() && order == mainContainer.get(0)) {
                mainContainer.remove(0);
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