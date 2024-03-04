import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public int solution(int[] cards) {
        List<HashSet<Integer>> groups = new LinkedList<>();
        boolean[] selected = new boolean[cards.length + 1];

        for (int card : cards) {
            HashSet<Integer> group = new HashSet<>();

            while (!selected[card]) {
                selected[card] = true;
                group.add(card);
                card = cards[card - 1];
            }

            groups.add(group);
        }

        List<Integer> groupSizes = groups.stream()
            .map(HashSet::size)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        return groupSizes.size() == 1 ? 0 : groupSizes.get(0) * groupSizes.get(1);
    }
}