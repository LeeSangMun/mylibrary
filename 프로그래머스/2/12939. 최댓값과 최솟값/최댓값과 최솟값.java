import java.util.*;

class Solution {
    public String solution(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for (String str : s.split(" ")) {
			set.add(Integer.parseInt(str));
		}
        
        return set.first() + " " + set.last();
    }
}