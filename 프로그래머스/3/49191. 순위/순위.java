import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = n;
		int[][] map = new int[n][n];
		
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 2);
			map[i][i] = 0;
		}
		
		for (int i = 0; i < results.length; i++) {
			map[results[i][0]-1][results[i][1]-1] = 1;
			map[results[i][1]-1][results[i][0]-1] = -1;
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					for (int k = 0; k < n; k++) {
						if(map[i][k] == -1) {
							map[j][k] = -1;
							map[k][j] = 1;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 2)  {
					answer--;
					break;
				}
			}
		}
		
		return answer;
    }
}