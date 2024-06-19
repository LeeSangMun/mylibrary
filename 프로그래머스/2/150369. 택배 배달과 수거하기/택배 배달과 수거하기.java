import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
		Stack<Integer> delivery = new Stack<>();
		Stack<Integer> pickup = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < deliveries[i]; j++) 
				delivery.push(i+1);
			for (int j = 0; j < pickups[i]; j++) 
				pickup.push(i+1);
		}
		
		while(!delivery.isEmpty() || !pickup.isEmpty()) {
			int d = delivery.isEmpty() ? 0 : delivery.peek();
			int p = pickup.isEmpty() ? 0 : pickup.peek();
			answer += Math.max(d, p) * 2;
			
			for (int i = 0; i < cap; i++) {
				if(!delivery.isEmpty()) delivery.pop();
				if(!pickup.isEmpty()) pickup.pop();
			}
		}
		
		return answer;
    }
}