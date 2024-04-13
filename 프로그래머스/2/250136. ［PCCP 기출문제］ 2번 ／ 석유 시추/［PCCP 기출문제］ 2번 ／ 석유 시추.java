import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
		int[] total = new int[land[0].length];
		Set<Integer> set = null;
		Queue<int[]> que = new LinkedList<>();
		Map<Set<Integer>, Integer> map = new HashMap<>();

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				if (land[i][j] != 0) {
					set = new HashSet<>();
					int sum = 1;
					que.offer(new int[] { i, j });
					set.add(j);
					land[i][j] = 0;

					while (!que.isEmpty()) {
						int[] temp = que.poll();
						for (int k = 0; k < 4; k++) {
							int x = temp[0] + dx[k];
							int y = temp[1] + dy[k];
							if (x >= 0 && x < land.length && y >= 0 && y < land[i].length && land[x][y] != 0) {
								sum++;
								land[x][y] = 0;
								que.offer(new int[] { x, y });
								set.add(y);
							}
						}
					}
					if(map.containsKey(set)) {
						sum += map.get(set);
					}
					map.put(set, sum);
				}
			}
		}
		
		for (Set<Integer> s : map.keySet()) {
			int sum = map.get(s);
			for (int idx : s) {
				total[idx] += sum;
				answer = Math.max(answer, total[idx]);
			}
		}

		return answer;
    }
}