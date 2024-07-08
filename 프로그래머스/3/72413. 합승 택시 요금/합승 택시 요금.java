import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
		List<int[]>[] list = new List[n];
		Queue<int[]> que = new LinkedList<>();
		int[][] cost = new int[n][n];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			Arrays.fill(cost[i], Integer.MAX_VALUE);
			cost[i][i] = 0;
		}

		for (int i = 0; i < fares.length; i++) {
			list[fares[i][0] - 1].add(new int[] { fares[i][1] - 1, fares[i][2] });
			list[fares[i][1] - 1].add(new int[] { fares[i][0] - 1, fares[i][2] });
		}

		que.offer(new int[] {s-1, s-1, 0});
		que.offer(new int[] {a-1, a-1, 0});
		que.offer(new int[] {b-1, b-1, 0});
		
		while (!que.isEmpty()) {
			int[] temp = que.poll();

			for (int[] arr : list[temp[1]]) {
				if (cost[temp[0]][arr[0]] >= temp[2] + arr[1]) {
					que.offer(new int[] {temp[0], arr[0], temp[2] + arr[1] });
					cost[temp[0]][arr[0]] = cost[arr[0]][temp[0]] = temp[2] + arr[1];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			answer = Math.min(answer, cost[s - 1][i] + cost[i][a - 1] + cost[i][b - 1]);
		}

		return answer;
    }
}