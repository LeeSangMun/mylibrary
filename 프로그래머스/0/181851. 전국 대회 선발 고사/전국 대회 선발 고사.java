import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for (int i = 0; i < rank.length; i++) {
			if(attendance[i]) {
				map.put(rank[i], i);
			}
		}
		
        return map.pollFirstEntry().getValue()*10000 + map.pollFirstEntry().getValue()*100 + map.pollFirstEntry().getValue();
    }
}