import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
		int max = 1;
		boolean[] flag = new boolean[edge.length];
		Queue<int[]> que = new LinkedList<>();
		int[] len = new int[n];
		
		for (int i = 0; i < edge.length; i++) {
			if(Math.min(edge[i][0], edge[i][1]) == 1) {
				int num = Math.max(edge[i][0], edge[i][1]);
				que.offer(new int[] {1, num, 1});
				flag[i] = true;
				len[num-1] = 1;
			}
		}
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			
			for (int i = 0; i < edge.length; i++) {
				if(!flag[i]) {
					int num;
					if(temp[1] == edge[i][0]) {
						num = edge[i][1];
					} else if(temp[1] == edge[i][1]) {
						num = edge[i][0];
					} else {
						continue;
					}
					
					flag[i] = true;
					
					if(len[num-1] == 0) {
						que.offer(new int[] {temp[1], num, temp[2] + 1});
						len[num-1] = temp[2] + 1;
						max = Math.max(max, temp[2] + 1);
					}
				}
			}
		}
		
		for (int j = 0; j < len.length; j++) {
			if(len[j] == max) answer++;
		}
		
		return answer;
    }
}