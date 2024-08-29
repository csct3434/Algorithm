import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    private static int[][] place;
    private static final int[][] stairwayPosition = new int[2][2];
    private static List<int[]> peoplePosition;
    private static int minTotalTime;

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()), N;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            place = new int[N][N];
            peoplePosition = new ArrayList<>();
            int stairwayCount = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if ((place[i][j] = Integer.parseInt(st.nextToken())) == 0) continue;
                    if (place[i][j] == 1) {
                        peoplePosition.add(new int[]{i, j});
                    } else {
                        stairwayPosition[stairwayCount][0] = i;
                        stairwayPosition[stairwayCount++][1] = j;
                    }
                }
            }
            minTotalTime = Integer.MAX_VALUE;
            dfs(0, new int[peoplePosition.size()]);
            answer.append('#').append(tc).append(' ').append(minTotalTime).append('\n');
        }
        System.out.println(answer);
    }

    private static void dfs(int depth, int[] stairwayPick) {
        if (depth == stairwayPick.length) {
            calcTime(stairwayPick);
            return;
        }

        for (int i = 0; i < 2; i++) {
            stairwayPick[depth] = i;
            dfs(depth + 1, stairwayPick);
        }
    }

    private static void calcTime(int[] stairwayPickForPerson) {
        List<List<Integer>> arrivalTimesForStairway = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            arrivalTimesForStairway.add(new ArrayList<>());
        }
        for (int i = 0; i < stairwayPickForPerson.length; i++) {
            int stairwayNumber = stairwayPickForPerson[i];
            int arrivalTime = calcArrivalTime(i, stairwayNumber);
            arrivalTimesForStairway.get(stairwayNumber).add(arrivalTime);
        }
        for (int i = 0; i < 2; i++) {
            Collections.sort(arrivalTimesForStairway.get(i));
        }

        int totalTime = 0;
        for (int i = 0; i < 2; i++) {
            int movingTime = place[stairwayPosition[i][0]][stairwayPosition[i][1]];
            int lastExitTime = calcLastExitTime(arrivalTimesForStairway.get(i), movingTime);
            totalTime = Math.max(totalTime, lastExitTime);
        }
        minTotalTime = Math.min(minTotalTime, totalTime);
    }

    private static int calcArrivalTime(int peopleNumber, int stairwayNumber) {
        return Math.abs(peoplePosition.get(peopleNumber)[0] - stairwayPosition[stairwayNumber][0])
                + Math.abs(peoplePosition.get(peopleNumber)[1] - stairwayPosition[stairwayNumber][1]);
    }

    private static int calcLastExitTime(List<Integer> arrivalTimes, int movingTime) {
        ArrayDeque<Integer> exitTime = new ArrayDeque<>();
        for (int arrivalTime : arrivalTimes) {
            while (!exitTime.isEmpty() && exitTime.peek() < arrivalTime + 1) {
                exitTime.remove();
            }
            if (exitTime.size() >= 3) {
                exitTime.add(exitTime.remove() + movingTime);
            } else {
                exitTime.add(arrivalTime + 1 + movingTime);
            }
        }
        return exitTime.isEmpty() ? 0 : exitTime.peekLast();
    }
}