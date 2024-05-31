class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
		int[][] temp = new int[board.length+1][board[0].length+1];
		
		for (int i = 0; i < skill.length; i++) {
			if(skill[i][0] == 1) {
				temp[skill[i][1]][skill[i][2]] -= skill[i][5];
				temp[skill[i][1]][skill[i][4]+1] += skill[i][5];
				temp[skill[i][3]+1][skill[i][2]] += skill[i][5];
				temp[skill[i][3]+1][skill[i][4]+1] -= skill[i][5];
			} else {
				temp[skill[i][1]][skill[i][2]] += skill[i][5];
				temp[skill[i][1]][skill[i][4]+1] -= skill[i][5];
				temp[skill[i][3]+1][skill[i][2]] -= skill[i][5];
				temp[skill[i][3]+1][skill[i][4]+1] += skill[i][5];
			}
		}
		
		for (int i = 0; i < temp[0].length - 1; i++) {
			for (int j = 0; j < temp.length - 2; j++) {
				temp[j+1][i] += temp[j][i];
			}
		}
		
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < temp[0].length - 2; j++) {
				temp[i][j+1] += temp[i][j];
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(temp[i][j] + board[i][j] > 0) answer++;
			}
		}

		return answer;
    }
}