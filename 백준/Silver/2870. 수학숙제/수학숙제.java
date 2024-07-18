import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		List<String> numbers = new ArrayList<>();
		while (M-- > 0) {
			char[] sentence = br.readLine().toCharArray();
			int idx = 0;
			while (idx < sentence.length) {
				if (!Character.isDigit(sentence[idx])) {
					idx++;
				} else {
					StringBuilder number = new StringBuilder();
					while (idx < sentence.length && Character.isDigit(sentence[idx])) {
						number.append(sentence[idx++]);
					}
					if (number.toString().replace("0", "").isEmpty()) {
						numbers.add("0");
					} else {
						int tempIdx = 0;
						while (tempIdx < number.length() && number.charAt(tempIdx) == '0') {
							tempIdx++;
						}
						numbers.add(number.substring(tempIdx));
					}
				}
			}
		}
		numbers.sort((a, b) -> {
			if (a.length() == b.length()) {
				int idx = 0;
				while (idx < a.length() && a.charAt(idx) == b.charAt(idx)) {
					idx++;
				}
				if (idx == a.length()) return 0;
				return a.charAt(idx) - b.charAt(idx);
			}
			return a.length() - b.length();
		});
		for (String number : numbers) {
			System.out.println(number);
		}
	}
}