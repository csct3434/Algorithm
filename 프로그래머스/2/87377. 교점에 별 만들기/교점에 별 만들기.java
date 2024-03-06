import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    public String[] solution(int[][] line) {
        Set<Point> points = getPoints(line);
        return draw(points);
    }

    private Set<Point> getPoints(int[][] line) {
        HashSet<Point> points = new HashSet<>();

        for (int i = 0; i < line.length; i++) {
            double A = line[i][0];
            double B = line[i][1];
            double E = line[i][2];

            // y = -A/Bx + -C/B
            for (int j = i + 1; j < line.length; j++) {
                double C = line[j][0];
                double D = line[j][1];
                double F = line[j][2];

                if (A * D - B * C == 0) {
                    continue;
                }

                double x = (B * F - E * D) / (A * D - B * C);
                double y = (E * C - A * F) / (A * D - B * C);

                if (x % 1 == 0 && y % 1 == 0) {
                    points.add(new Point((long) x, (long) y));
                }
            }
        }

        return points;
    }

    private String[] draw(Set<Point> points) {
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point point : points) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }

        char[][] map = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        for (char[] line : map) {
            Arrays.fill(line, '.');
        }

        for (Point point : points) {
            map[(int) (maxY - point.y)][(int) (point.x - minX)] = '*';
        }

        String[] result = new String[(int) (maxY - minY + 1)];
        for (int i = 0; i < map.length; i++) {
            result[i] = new String(map[i]);
        }
        return result;
    }

    private static class Point {

        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}