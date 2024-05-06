import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> que = new LinkedList<>();
		int t = 0, idx = 0;

		while(true) {
			if(idx == truck_weights.length && que.isEmpty())
				break;
			
			if(!que.isEmpty()) {
				int[] temp = que.peek();
				if(temp[1] == t) {
					que.poll();
					weight += temp[0];
				}
			}
			
			if(idx < truck_weights.length && weight - truck_weights[idx] >= 0) {
				que.offer(new int[] {truck_weights[idx], t + bridge_length});
				weight -= truck_weights[idx];
				idx++;
			}
			
			
			t++;
		}

		return t;
    }
}