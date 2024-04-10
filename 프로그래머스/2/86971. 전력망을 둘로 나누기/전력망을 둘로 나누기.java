import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 0;
        
        for (int i = 0; i < wires.length; i++) {
			answer = Math.max(f(i, wires), answer);
		}
        
        return wires.length + 1 - answer - answer;
    }
	
	static int f(int i, int[][] wires) {
		int cnt = 0;
		Queue<int[]> que = new LinkedList<>();
		boolean[] flag = new boolean[wires.length];
		for (int j = 0; j < wires.length; j++) {
			if(i != j) {
				que.offer(wires[j]);
				flag[j] = true;
				cnt++;
				break;
			}
		}
		flag[i] = true;
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			for (int j = 0; j < wires.length; j++) {
				if(!flag[j] && (temp[0] == wires[j][0] || temp[1] == wires[j][0] || temp[0] == wires[j][1] || temp[1] == wires[j][1])) {
					que.offer(wires[j]);
					cnt++;
					flag[j] = true;
				}
			}
		}
		
		return Math.min(wires.length + 1 - (cnt+1), cnt+1);
	}
}