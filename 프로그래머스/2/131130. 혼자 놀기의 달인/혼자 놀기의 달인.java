import java.util.*;

class Solution {
    public int solution(int[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        boolean[] flag = new boolean[cards.length];
        
        for (int i = 0; i < cards.length; i++) {
        	int cnt = 0;
        	int idx = i;
			while(!flag[idx]) {
				flag[idx] = true;
				cnt++;
				idx = cards[idx] - 1;
			}
			
			if(cnt != 0) 
				pq.offer(cnt);
		}
        
        if(pq.size() < 2)
        	return 0;
        
        return pq.poll() * pq.poll();
    }
}