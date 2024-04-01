import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        if(k >= enemy.length) 
        	return enemy.length;
        
        for (int i = 0; i < k; i++) {
			pq.offer(enemy[i]);
		}
        
        for (int i = k; i < enemy.length; i++) {
        	if(pq.peek() < enemy[i]) {
        		n -= pq.poll();
        		pq.offer(enemy[i]);
        	} else {
        		n -= enemy[i];
        	}
        	
        	answer++;
        	
        	if(n < 0)
        		break;
		}
        
        return k + answer + (n < 0 ? -1 : 0);
    }
}