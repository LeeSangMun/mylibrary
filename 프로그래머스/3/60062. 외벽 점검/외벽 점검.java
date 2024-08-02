import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;

	public int solution(int n, int[] weak, int[] dist) {
		boolean[] visited = new boolean[dist.length];
		int[] temp = new int[weak.length * 2];

		for (int i = 0; i < weak.length; i++) {
			temp[i] = weak[i];
			temp[i + weak.length] = weak[i] + n;
		}

		for (int i = 0; i < weak.length; i++) {
			f(temp, dist, visited, i, 0);
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	static void f(int[] weak, int[] dist, boolean[] visited, int idx, int cnt) {
		if(cnt >= weak.length / 2) {
			int n = 0;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) n++;
			}
			
			answer = Math.min(answer, n);
			return;
		}
		
		for (int i = 0; i < dist.length; i++) {
			if(!visited[i]) {
				int n = 0;
				for (int j = idx; j < weak.length; j++) {
					if(weak[idx] + dist[i] >= weak[j]) {
						n++;
					} else {
						break;
					}
				}
				
				visited[i] = true;
				f(weak, dist, visited, idx + n, cnt + n);
				visited[i] = false;
			}
		}
	}
}