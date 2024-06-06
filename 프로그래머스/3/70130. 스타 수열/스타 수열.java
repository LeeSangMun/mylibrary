import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        if(a.length == 1) return 0;
        
        for (int i = 0; i < a.length; i++) {
        	list = map.get(a[i]);
        	if(list == null) {
        		list = new ArrayList<>();
        		map.put(a[i], list);
        	}
        	
			list.add(i);
		}
        
        for (List<Integer> li : map.values()) {
        	int len = 0;
        	int idx = -1;       	
        	
        	for (int i = 0; i < li.size(); i++) {
        		int n = li.get(i);
        		
        		if(n-1 >= 0 && idx < n-1 && a[n-1] != a[n]) {
					idx = n;
					len += 2;
				} else if(n+1 < a.length && a[n+1] != a[n]) {
					idx = n+1;
					len += 2;
				}
        	}
        	
        	answer = Math.max(answer, len);
		}
        
        return answer;
    }
}