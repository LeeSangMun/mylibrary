class Solution {
    public int solution(int n, int[] tops) {
        int[][] answer = new int[n][2];
        
        answer[0][0] = 1;
        answer[0][1] = tops[0] == 1 ? 3 : 2;
        
        for (int i = 1; i < n; i++) {
			if(tops[i] == 1) {
				answer[i][0] = answer[i-1][0] + answer[i-1][1];
				answer[i][1] = answer[i-1][0] * 2 + answer[i-1][1] * 3;
			} else {
				answer[i][0] = answer[i-1][0] + answer[i-1][1];
				answer[i][1] = answer[i-1][0] + answer[i-1][1] * 2;
			}
			
			answer[i][0] %= 10007;
			answer[i][1] %= 10007;
		}
        
        return (answer[n-1][0] + answer[n-1][1]) % 10007;
    }
}