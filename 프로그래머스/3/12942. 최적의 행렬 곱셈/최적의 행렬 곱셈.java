class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length; 
	    int[][] dp = new int[n][n]; 

	    for (int l = 2; l <= n; l++) {
	        for (int i = 0; i <= n - l; i++) {
	            int j = i + l - 1;
	            dp[i][j] = Integer.MAX_VALUE;
	            for (int k = i; k < j; k++) {
	                int q = dp[i][k] + dp[k + 1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1];
	                dp[i][j] = Math.min(dp[i][j], q);
	            }
	        }
	    }

	    return dp[0][n - 1];
    }
}