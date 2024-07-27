import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] list = new List[n+1];
        int[][] dp = new int[k][n+1];
        
        for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			list[i].add(i);
		}
        
        for (int i = 0; i < edge_list.length; i++) {
			list[edge_list[i][0]].add(edge_list[i][1]);
			list[edge_list[i][1]].add(edge_list[i][0]);
		}
        
        for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {
			for (int j = 1; j <= n; j++) {
				if(dp[i-1][j] == Integer.MAX_VALUE) continue;
				for (int v : list[j]) {
					if(gps_log[i] == v) {
						dp[i][v] = Math.min(dp[i][v], dp[i-1][j]);
					} else {
						dp[i][v] = Math.min(dp[i][v], dp[i-1][j] + 1);
					}
				}
			}
			
		}
        
        return dp[k-1][gps_log[k-1]] == Integer.MAX_VALUE ? -1 : dp[k-1][gps_log[k-1]];
    }
}