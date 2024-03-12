import java.util.*;

class Solution {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascPriorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> descPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String op : operations) {
            String[] tokens = op.split(" ");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            if (command.equals("I")) {
                ascPriorityQueue.add(value);
                descPriorityQueue.add(value);
                continue;
            }

            if (ascPriorityQueue.isEmpty()) {
                continue;
            }

            if (value < 0) {
                descPriorityQueue.remove(ascPriorityQueue.poll());
            } else {
                ascPriorityQueue.remove(descPriorityQueue.poll());
            }
        }

        return ascPriorityQueue.isEmpty() ? new int[]{0, 0} : new int[]{descPriorityQueue.poll(), ascPriorityQueue.poll()};
    }
}