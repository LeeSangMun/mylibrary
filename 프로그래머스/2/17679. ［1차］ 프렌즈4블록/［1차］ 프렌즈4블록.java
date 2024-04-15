import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
		char[][] cBoard = new char[board[0].length()][board.length];
		Set<int[]> set = new HashSet<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				cBoard[j][i] = board[board.length - i - 1].charAt(j);
			}
		}
		
		boolean flag = true;
		
		while(flag) {
			flag = false;
			set.clear();
			for (int i = 1; i < cBoard.length; i++) {
				for (int j = 1; j < cBoard[i].length; j++) {
					char temp = cBoard[i][j];
					try {
						if(temp == cBoard[i-1][j] && temp == cBoard[i][j-1] && temp == cBoard[i-1][j-1]) {
							set.add(new int[] {i, j});
							set.add(new int[] {i-1, j});
							set.add(new int[] {i, j-1});
							set.add(new int[] {i-1, j-1});
							flag = true;
						}
					} catch(Exception e) {
						
					}
				}
			}
			
			for (int[] is : set) {
				if(cBoard[is[0]][is[1]] != ' ') {
					cBoard[is[0]][is[1]] = ' ';
					answer++;
				}
			}
			
			for (int i = 0; i < cBoard.length; i++) {
				cBoard[i] = String.valueOf(cBoard[i]).replaceAll(" ", "").toCharArray();
			}
		}

		return answer;
    }
}