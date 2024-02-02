import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numlist.length; i++) {
			map.put(numlist[i], Math.abs(numlist[i]-n));
		}
        
        List<Entry<Integer, Integer>> list = map.entrySet().stream()
        		.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        		.sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        
        return list.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}