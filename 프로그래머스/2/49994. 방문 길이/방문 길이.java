import java.util.HashSet;
import java.util.Objects;

class Solution {

    public int solution(String dirs) {
        Position position = new Position(0, 0);
        HashSet<Path> paths = new HashSet<>();

        for (char direction : dirs.toCharArray()) {
            Position nextPosition = position.goTo(direction);
            if (position != nextPosition) {
                paths.add(new Path(position, nextPosition));
                position = nextPosition;
            }
        }

        return paths.size();
    }

    private static class Position {

        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position goTo(char direction) {
            int nx = x, ny = y;

            switch (direction) {
                case 'L':
                    ny--;
                    break;
                case 'R':
                    ny++;
                    break;
                case 'U':
                    nx--;
                    break;
                case 'D':
                    nx++;
                    break;
            }

            if (nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5) {
                return new Position(nx, ny);
            }
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static class Path {

        Position from;
        Position to;

        public Path(Position from, Position to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Path path = (Path) o;
            return (from.equals(path.from) && to.equals(path.to)) ||
                (from.equals(path.to) && to.equals(path.from));
        }

        @Override
        public int hashCode() {
            return Math.min(Objects.hash(from.hashCode(), to.hashCode()), Objects.hash(to.hashCode(), from.hashCode()));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("LRLR"));
    }
}