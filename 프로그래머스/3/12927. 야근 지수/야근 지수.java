import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        TreeMap<Integer, Integer> tMap = new TreeMap<>(Comparator.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
			tMap.put(works[i], tMap.getOrDefault(works[i], 0) + 1);
		}
        
        while(n != 0 && tMap.firstKey() != 0) {
        	int firstKey = tMap.firstKey();
        	int cnt = tMap.get(firstKey);
        	
        	if(cnt > n) {
        		tMap.put(firstKey, tMap.get(firstKey) - n);
        		tMap.put(firstKey - 1, tMap.getOrDefault(firstKey - 1, 0) + n);
        		n = 0;
        	} else {
        		tMap.put(firstKey - 1, tMap.getOrDefault(firstKey - 1, 0) + cnt);
        		tMap.remove(firstKey);
        		n -= cnt;
        	}
        }
        
        for (int key : tMap.keySet()) {
			answer+= (long)key*key*tMap.get(key);
		}
        
        return answer;
    }
}