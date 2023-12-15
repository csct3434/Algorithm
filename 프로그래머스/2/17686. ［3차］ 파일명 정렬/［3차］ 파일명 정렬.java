import java.util.Arrays;
import java.util.HashMap;

class Solution {

	public String[] solution(String[] files) {
		HashMap<String, Integer> initialOrder = new HashMap<>();
		for (int i = 0; i < files.length; i++) {
			initialOrder.put(files[i], i);
		}

		return Arrays.stream(files)
			.sorted((str1, str2) -> {
				String head1 = parseHead(str1).toLowerCase();
				String head2 = parseHead(str2).toLowerCase();
				if (head1.compareTo(head2) == 0) {
					Integer number1 = parseNumber(str1.substring(head1.length()));
					Integer number2 = parseNumber(str2.substring(head2.length()));
					if (number1.compareTo(number2) == 0) {
						return initialOrder.get(str1) - initialOrder.get(str2);
					}
					return number1.compareTo(number2);
				}
				return head1.compareTo(head2);
			}).toArray(String[]::new);
	}

	private String parseHead(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				break;
			}
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}

	private Integer parseNumber(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c) || stringBuilder.length() == 5) {
				break;
			}
			stringBuilder.append(c);
		}
		return Integer.valueOf(stringBuilder.toString());
	}
}