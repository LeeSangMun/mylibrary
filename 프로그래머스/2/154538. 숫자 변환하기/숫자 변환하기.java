import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

		TreeSet<Integer> set = new TreeSet<>();
		set.add(x);
		
		while (!set.contains(y)) {
			if(set.first() > y) return -1;
			
			for (Integer i : new ArrayList<>(set.headSet(y))) {
				set.remove(i);
				set.add(i*3);
				set.add(i*2);
				set.add(i+n);
			}
			
			answer++;
		}

		return answer;
    }
}