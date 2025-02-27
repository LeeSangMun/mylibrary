import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < players.length; i++) {
			while(!que.isEmpty()) {
				if(que.peek() == i) {
					que.poll();
				} else {
					break;
				}
			}
			
			int cnt = players[i] / m;
			
			if(cnt > que.size()) {
				answer += cnt - que.size();
				while(cnt != que.size()) {
					que.offer(i + k);
				}
			}
		}
        
        return answer;
    }
}