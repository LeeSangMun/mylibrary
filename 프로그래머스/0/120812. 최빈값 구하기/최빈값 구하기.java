import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < array.length; i++) {
			map.put(array[i], map.getOrDefault(array[i], 0)+1);
		}
          
        int max = Collections.max(map.values());
        
        for (Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue() == max) list.add(e.getKey());
		}
        
        return list.size() == 1 ? list.get(0) : -1;
    }
}