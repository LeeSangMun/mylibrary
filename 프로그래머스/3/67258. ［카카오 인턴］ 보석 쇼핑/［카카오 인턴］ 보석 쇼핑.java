import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = { 0, gems.length - 1 };
		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new LinkedHashMap<>();
		
		for (String gem : gems) {
			set.add(gem);
		}

		int n = set.size();

		if (n == 1)
			return new int[] { 1, 1 };

		for (int i = 0; i < gems.length; i++) {
			if(map.containsKey(gems[i])) {
				map.remove(gems[i]);
			}
			map.put(gems[i], i);
			
			if(map.size() == n) {
				int s = map.values().iterator().next();
				if(answer[1] - answer[0] > i - s) {
					answer[0] = s;
					answer[1] = i;
				}
			}
		}

		return new int[] { answer[0] + 1, answer[1] + 1 };
    }
}