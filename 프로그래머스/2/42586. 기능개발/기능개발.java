import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int d1 = (100-progresses[0])/speeds[0] + ((100-progresses[0])%speeds[0] == 0 ? 0 : 1);
        int d2;
        int n = 1;
        
        for (int i = 1; i < progresses.length; i++) {
        	d2 = (100-progresses[i])/speeds[i] + ((100-progresses[i])%speeds[i] == 0 ? 0 : 1);
			if(d1 < d2) {
				list.add(n);
				n = 0;
				d1 = d2;
			}
			n++;
		}
        
        list.add(n);
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}