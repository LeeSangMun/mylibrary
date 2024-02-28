import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
	static Set<Integer> set;

	public static String[] solution(String[] orders, int[] course) {
		set = Arrays.stream(course).boxed().collect(Collectors.toCollection(HashSet::new));
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			String[] str = orders[i].split("");
			Arrays.sort(str);
			for (int j = 0; j < str.length - 1; j++) {
				f(str[j], j + 1, str);
			}
		}
		
		map.entrySet().removeIf(e -> e.getValue() < 2);
		
		for (int i : set) {
			Optional<Entry<String, Integer>> op = map.entrySet().stream().filter(e -> e.getKey().length() == i).max(Map.Entry.comparingByValue());
			if(!op.isPresent()) {
				continue;
			}
			int max = op.get().getValue();
			
			answer.addAll(map.entrySet().stream().filter(e -> e.getKey().length() == i).filter(e -> e.getValue() == max)
					.map(Map.Entry::getKey).collect(Collectors.toList()));
		}
		answer.sort(null);

		return answer.stream().toArray(String[]::new);
	}

	static void f(String temp, int i, String[] str) {
		if (set.contains(temp.length())) {
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}
		for (int j = i; j < str.length; j++) {
			f(temp + str[j], j + 1, str);
		}
	}
}