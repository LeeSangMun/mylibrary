import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        Queue<int[]> que = new LinkedList<>();
        int[][] map = new int[101][101];
        boolean[][] flag = new boolean[101][101];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < rectangle.length; i++) {
			for (int j = rectangle[i][0]*2; j <= rectangle[i][2]*2; j++) {
				for (int k = rectangle[i][1]*2; k <= rectangle[i][3]*2; k++) {
					if(j == rectangle[i][0]*2 || j == rectangle[i][2]*2 || k == rectangle[i][1]*2 || k == rectangle[i][3]*2) {
						map[j][k] = map[j][k] == 2 ? 2 : 1;
					} else {
						map[j][k] = 2;
					}
				}
			}
		}
        
        que.offer(new int[] {characterX*2, characterY*2, 0});
        flag[characterX*2][characterY*2] = true;
        
        while(!que.isEmpty()) {
        	int[] temp = que.poll();
        	
        	if(temp[0] == itemX*2 && temp[1] == itemY*2) {
        		answer = Math.min(answer, temp[2]);
        	}
        	
        	for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				
				if(x >= 0 && x < map.length && y >= 0 && y < map[x].length && map[x][y] == 1 && !flag[x][y]) {
					que.offer(new int[] {x, y, temp[2] + 1});
					flag[x][y] = true;
				}
			}
        }
        
        return answer / 2;
    }
}