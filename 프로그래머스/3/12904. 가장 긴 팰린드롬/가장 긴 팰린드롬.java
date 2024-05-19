import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1;
		Map<Character, List<Integer>> map = new HashMap<>();
		List<Integer> list = null;

		for (int i = 0; i < s.length(); i++) {
			list = map.get(s.charAt(i));

			if (list == null) {
				list = new ArrayList<>();
				map.put(s.charAt(i), list);
			}

			list.add(i);
		}

		for (Character key : map.keySet()) {
			list = map.get(key);
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = list.size() - 1; j >= i + 1 ; j--) {
					int start = list.get(i);
					int end = list.get(j);
					
					if(answer >= end - start + 1) break;
					
					int k = 0;
					for (k = 0; k < (end - start + 1) / 2; k++) {
						if(s.charAt(start + k) != s.charAt(end - k)) break;
					}
					
					if(k == (end - start + 1) / 2) 
						answer = end - start + 1;
				}
			}
		}

		return answer;
    }
}