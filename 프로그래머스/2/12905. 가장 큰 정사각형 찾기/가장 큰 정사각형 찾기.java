class Solution
{
    public int solution(int[][] board) {
		int answer = 1;
		
		if(!f(board)) 
			return 0;
		
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if(board[i][j] != 0) {
					board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
					answer = Math.max(board[i][j], answer);
				}
			}
		}

		return answer * answer;
	}
	
	static boolean f(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] != 0)
					return true;
			}
		}
		
		return false;
	}
}