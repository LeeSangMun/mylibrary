import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        boolean[] flag = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
			if(!flag[i]) {
				que.offer(computers[i]);
		        flag[i] = true;
		        answer++;
		        while(!que.isEmpty()) {
		        	int[] temp = que.poll();
		        	for (int j = 0; j < temp.length; j++) {
						if(temp[j] == 1 && !flag[j]) {
							que.offer(computers[j]);
							flag[j] = true;
						}
					}
		        }
			}
		}
        
        return answer;
    }
}