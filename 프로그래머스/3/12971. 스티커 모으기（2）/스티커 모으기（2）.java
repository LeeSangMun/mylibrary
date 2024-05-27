import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
		int[][] dp = new int[2][len];
        
        if(len == 1) return sticker[0];
		
		dp[0][0] = dp[0][1] = sticker[0];
		dp[1][0] = 0;
		dp[1][1] = sticker[1];
		
		for (int i = 2; i < len; i++) {
			if(i == len) {
				dp[1][i] = Math.max(dp[1][i-2] + sticker[i], dp[1][i-1]);
			} else {
				dp[0][i] = Math.max(dp[0][i-2] + sticker[i], dp[0][i-1]);
				dp[1][i] = Math.max(dp[1][i-2] + sticker[i], dp[1][i-1]);
			}
		}
		
        return Math.max(dp[0][len-2], dp[1][len-1]);
    }
}