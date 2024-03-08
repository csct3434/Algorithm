import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        Arrays.sort(program, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<Process> queue = new PriorityQueue<>((a, b) -> a.priority == b.priority ?
            a.createdTime - b.createdTime : a.priority - b.priority);

        int idx = 0, finished = 0;
        long currentTime = program[0][1];

        while (finished < program.length) {
            while (idx < program.length) {
                if (program[idx][1] <= currentTime) {
                    queue.add(new Process(program[idx][0], program[idx][1], program[idx][2]));
                    idx++;
                } else {
                    break;
                }
            }

            if (!queue.isEmpty()) {
                Process process = queue.poll();
                answer[process.priority] += process.createdTime < currentTime ? currentTime - process.createdTime : 0;
                answer[0] = currentTime = Math.max(currentTime, process.createdTime) + process.duration;
                finished++;
            } else {
                currentTime = program[idx][1];
            }
        }

        return answer;
    }

    private static class Process {

        int priority;
        int createdTime;
        int duration;

        public Process(int priority, int created, int duration) {
            this.priority = priority;
            this.createdTime = created;
            this.duration = duration;
        }
    }
}
