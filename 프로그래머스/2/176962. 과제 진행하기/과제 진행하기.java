import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;

        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            int minutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            plan[1] = String.valueOf(minutes);
        }

        Arrays.sort(plans, Comparator.comparingInt(p -> Integer.parseInt(p[1])));

        Stack<int[]> stack = new Stack<>();
        for (int taskNumber = 0; taskNumber < plans.length - 1; taskNumber++) {
            int currentTaskEndTime = Integer.parseInt(plans[taskNumber][1]) + Integer.parseInt(plans[taskNumber][2]);
            int nextTaskStartTime = Integer.parseInt(plans[taskNumber + 1][1]);

            if (currentTaskEndTime > nextTaskStartTime) {
                stack.push(new int[]{taskNumber, currentTaskEndTime - nextTaskStartTime});
                continue;
            }

            answer[index++] = plans[taskNumber][0];

            int freeTime = nextTaskStartTime - currentTaskEndTime;
            while (!stack.isEmpty() && freeTime > 0) {
                int[] taskInfo = stack.pop();
                int remainingTime = taskInfo[1];

                if (remainingTime <= freeTime) {
                    answer[index++] = plans[taskInfo[0]][0];
                    freeTime -= remainingTime;
                    continue;
                }

                stack.push(new int[]{taskInfo[0], remainingTime - freeTime});
                break;
            }
        }

        answer[index++] = plans[plans.length - 1][0];

        while (!stack.isEmpty()) {
            int[] taskInfo = stack.pop();
            answer[index++] = plans[taskInfo[0]][0];
        }

        return answer;
    }
}