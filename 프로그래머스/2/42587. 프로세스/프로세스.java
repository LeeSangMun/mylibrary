import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        int[] arr = new int[priorities.length];
        for (Integer i : priorities) {
			que.add(i);
		}
        
        for (int i = 0; que.size() != 0; i++) {
			if(priorities[i%priorities.length] == que.peek()) {
				arr[i%priorities.length] = ++answer;
				que.poll();
			}
		}
        
        return arr[location];
    }
}