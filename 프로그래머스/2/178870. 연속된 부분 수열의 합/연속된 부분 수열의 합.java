import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1000000};
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 0; i < sequence.length; i++) {
			k -= sequence[i];
			que.offer(sequence[i]);
			
			while(k < 0) {
				k += que.poll();
			}
			
			if(k == 0 && answer[1]-answer[0] > que.size()-1) {
				answer = new int[] {i-que.size()+1, i};
			}
		}
		
		return answer;
    }
}