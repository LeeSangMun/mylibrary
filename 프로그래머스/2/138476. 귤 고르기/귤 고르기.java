import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
			map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
		}
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        
        for (Integer i : list) {
        	answer++;
			if((k-=i) <= 0) {
				break;
			}
		}
        
        return answer;
    }
}