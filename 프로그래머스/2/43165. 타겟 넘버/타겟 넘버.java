import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> que = new LinkedList<>();
        que.add(numbers[0]);
        que.add(-numbers[0]);
        int s = que.size();
        Integer n;
        int idx = 1;
        
        while(s < (int)Math.pow(2, numbers.length)) {
        	for (int i = 0; i < s; i++) {
        		n = que.poll();
        		que.offer(n+numbers[idx]);
        		que.offer(n-numbers[idx]);
        	}
        	idx++;
        	s = que.size();
        }
        
        while(!que.isEmpty()) {
        	if(que.poll() == target) answer++;
        }
        
        return answer;
    }
}