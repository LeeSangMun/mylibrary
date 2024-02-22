import java.util.*;

class Solution {
    static Stack<Integer> st = new Stack<>();
	static Set<Integer> set = new HashSet<>();
	static int answer = 0;

	public static int solution(String numbers) {
		f("", numbers); 

		for (int num : set) {
			if (num != 0 && num != 1) {
				for (int j = 2; j <= (int) Math.sqrt(num); j++) {
					if (num % j == 0) {
						answer--;
						break;
					}
				}
				answer++;
			}
		}

		return answer;
	}

	static void f(String temp, String numbers) {
		for (int i = 0; i < numbers.length(); i++) {
			if (!st.contains(i)) {
				st.push(i);
				String str = temp + numbers.charAt(i);
				set.add(Integer.parseInt(str));
				f(str, numbers);
				st.pop();
			}
		}
	}
}