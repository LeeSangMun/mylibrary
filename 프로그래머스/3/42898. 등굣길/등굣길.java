import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m+1];

		for (int i = 0; i < puddles.length; i++) {
			board[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}
		
		board[0][0] = 1;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if(board[i][j] == -1) continue;
				
				if(i != board.length - 1) {
					board[i][j+1] += board[i][j+1] != -1 ? board[i][j] : 0;
					board[i+1][j] += board[i+1][j] != -1 ? board[i][j] : 0;
					
					board[i][j+1] %= 1000000007;
					board[i+1][j] %= 1000000007;
				} else {
					board[i][j+1] += board[i][j+1] != -1 ? + board[i][j] : 0;
					board[i][j+1] %= 1000000007;
				}
			}
		}

		return board[n-1][m-1];
    }
}