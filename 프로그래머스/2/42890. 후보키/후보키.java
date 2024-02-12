import java.util.HashSet;
import java.util.LinkedList;

class Solution {

    public int solution(String[][] relation) {
        int rows = relation.length;
        int cols = relation[0].length;

        LinkedList<Integer> superKeys = new LinkedList<>();

        for (int mask = 1; mask < (1 << cols); mask++) {
            HashSet<String> uniqueIndexes = new HashSet<>();

            for (String[] record : relation) {
                StringBuilder index = new StringBuilder();

                for (int i = 0; i < cols; i++) {
                    if ((mask & (1 << i)) != 0) {
                        index.append(record[i]).append(" ");
                    }
                }

                uniqueIndexes.add(index.toString());
            }

            if (uniqueIndexes.size() == rows) {
                superKeys.add(mask);
            }
        }

        LinkedList<Integer> candidateKeys = new LinkedList<>();

        for (Integer superKey : superKeys) {
            boolean duplicate = candidateKeys.stream()
                .anyMatch(candidateKey -> (superKey & candidateKey) == candidateKey);

            if (!duplicate) {
                candidateKeys.add(superKey);
            }
        }

        return candidateKeys.size();
    }
}