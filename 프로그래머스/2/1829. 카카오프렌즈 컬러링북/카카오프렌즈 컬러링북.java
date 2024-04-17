import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        Queue<int[]> que = new LinkedList<>();
        boolean[][] flag = new boolean[m][n];
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!flag[i][j] && picture[i][j] != 0) {
					int cnt = 1;
					int num = picture[i][j];
					que.offer(new int[] {i, j});
					flag[i][j] = true;;
					answer[0]++;
                    
					while(!que.isEmpty()) {
			        	int[] temp = que.poll();
			        	
			        	for (int k = 0; k < 4; k++) {
							int x = temp[0] + dx[k];
							int y = temp[1] + dy[k];
							if(x >= 0 && x < m && y >= 0 && y < n && picture[x][y] != 0 && !flag[x][y] && picture[x][y] == num) {
								cnt++;
								que.offer(new int[] {x, y});
								flag[x][y] = true;
							}
						}
			        }
					answer[1] = Math.max(answer[1], cnt);
				}
			}
		}
        
        return answer;
    }
}