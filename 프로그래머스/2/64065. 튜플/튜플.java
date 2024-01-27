import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] str = s.substring(1, s.length()-1).replace("},{", "} {").split(" ");
        Set<Integer> set = new LinkedHashSet<>();
        
        Arrays.sort(str, Comparator.comparing(String::length));
        
        for (String t1 : str) {
			for (String t2 :t1.substring(1, t1.length()-1).split(",")) {
				set.add(Integer.parseInt(t2));
			}
		}
        
        return set.stream().mapToInt(Integer::valueOf).toArray();
    }
}