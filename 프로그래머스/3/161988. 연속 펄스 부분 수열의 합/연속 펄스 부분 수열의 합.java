class Solution {
    public long solution(int[] sequence) {
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        long max = Math.max(dp[0][0], dp[0][1]);
        int sign = 1, sign1 = -1;
        
        for (int i = 1; i < sequence.length; i++) {
        	sign *= -1;
        	sign1 *= -1;
			dp[i][0] = Math.max(dp[i-1][0] + sign*sequence[i], sign*sequence[i]);
			dp[i][1] = Math.max(dp[i-1][1] + sign1*sequence[i], sign1*sequence[i]);
		
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        
        return max;
    }
}