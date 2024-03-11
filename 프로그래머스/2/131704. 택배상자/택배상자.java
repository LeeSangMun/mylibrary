import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < order.length; i++) {
			que.offer(i+1);
		}
        
        int i = 0;
        while(!que.isEmpty() || !st.isEmpty()) {
        	if(que.isEmpty() && i < order.length && st.peek() != order[i])
        		break;
        	
        	if(!que.isEmpty() && que.peek() == order[i]) {
        		que.poll();
        		answer++;
        		++i;
        	} else if(!st.isEmpty() && st.peek() == order[i]) {
        		st.pop();
        		answer++;
        		++i;
        	} else {
        		st.push(que.poll());
        	}
        	
        }
        
        return answer;
    }
}