import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < want.length; i++) {
			map.put(want[i], number[i]);
		}

		Map<String, Integer> temp;

		outer:
		for (int i = 0; i <= discount.length - 10; i++) {
			temp = new HashMap<>(map);
			for (int j = i; j < i+10; j++) {
				if (!temp.containsKey(discount[j])) {
					continue outer;
				}

				Integer n = temp.get(discount[j]) - 1;
				if (n < 0) {
					continue outer;
				}

				temp.put(discount[j], n);
			}
			
			answer++;
		}

		return answer;
    }
}