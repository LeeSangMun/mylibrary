import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>();
        String[] temp = null;
        
        for (int i = 0; i < operations.length; i++) {
        	temp = operations[i].split(" ");
			if(temp[0].startsWith("I")) {
				set.add(Integer.parseInt(temp[1]));
			} else if(temp[1].equals("1")) {
				set.pollLast();
			} else {
				set.pollFirst();
			}
		}
        
        return set.size() == 0 ? new int[] {0, 0} : new int[] {set.pollLast(), set.pollFirst()};
    }
}