class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] map = new int[m+1][n+1][2];	
		map[0][0][0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(cityMap[i][j] == 1) {
					continue;
				} else if(cityMap[i][j] == 2) {
					map[i+1][j][0] = map[i][j][0];
					map[i][j+1][1] = map[i][j][1];
				} else {
					map[i+1][j][0] = (map[i][j][0] + map[i][j][1])%MOD;
					map[i][j+1][1] = (map[i][j][0] + map[i][j][1])%MOD;
				}
			}
		}

		return (map[m - 1][n - 1][0] + map[m - 1][n - 1][1])%MOD;
    }
}