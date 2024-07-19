import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int[][] dp = new int[200][200];
        int maxAlp = alp, maxCop = cop;
        
        for (int i = 0; i < problems.length; i++) {
			maxAlp = Math.max(maxAlp, problems[i][0]);
			maxCop = Math.max(maxCop, problems[i][1]);
		}
        
        for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
        
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= maxAlp; i++) {
			for (int j = cop; j <= maxCop; j++) {
				dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
				dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
				
				for (int k = 0; k < problems.length; k++) {
					if(i >= problems[k][0] && j >= problems[k][1]) {
						int x = Math.min(i+problems[k][2], maxAlp);
						int y = Math.min(j+problems[k][3], maxCop);
						
						dp[x][y] = Math.min(dp[x][y], dp[i][j] + problems[k][4]);
					}
				}
			}
		}
        
        return dp[maxAlp][maxCop];
    }
}