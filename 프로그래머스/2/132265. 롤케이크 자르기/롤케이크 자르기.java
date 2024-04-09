import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();

		for (int i = 0; i < topping.length; i++) {
			set1.add(topping[i]);
			map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
		}

		for (int i = topping.length - 1; i >= 0; i--) {
			map.put(topping[i], map.get(topping[i]) - 1);
			set2.add(topping[i]);
			if (map.get(topping[i]) == 0)
				set1.remove(topping[i]);
			if (set1.size() == set2.size()) {
				answer++;
			} else if (set1.size() < set2.size()) {
				break;
			} else {
				answer = 0;
			}
		}

		return answer;
    }
}