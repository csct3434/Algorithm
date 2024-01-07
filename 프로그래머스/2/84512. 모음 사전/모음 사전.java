import java.util.LinkedList;
import java.util.List;

class Solution {

    public int solution(String word) {
        List<String> dictionary = new LinkedList<>();
        initDictionary("", 0, dictionary);
        return dictionary.indexOf(word) + 1;
    }

    private void initDictionary(String word, int depth, List<String> dictionary) {
        String[] alphabets = {"A", "E", "I", "O", "U"};

        if (depth == 5) {
            return;
        }

        for (String alphabet : alphabets) {
            String nextWord = word.concat(alphabet);
            dictionary.add(nextWord);
            initDictionary(nextWord, depth + 1, dictionary);
        }
    }
}
