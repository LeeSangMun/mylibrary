import java.util.*;

class Solution {
    public int solution(int[][] board) {
        Queue<int[]> que = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] dir = {1, 0, 1, 0};
        
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0) board[i][j] = Integer.MAX_VALUE;
			}
		}
        board[0][0] = 0;
        
        if(board[0][1] != 1) {
        	que.offer(new int[] {0, 1, 100, 0});
        	board[0][1] = 100;
        }
        
        if(board[1][0] != 1) {
        	que.offer(new int[] {1, 0, 100, 1});
        	board[1][0] = 100;
        }
        
        while(!que.isEmpty()) {
        	int[] temp = que.poll();
        	
        	for (int i = 0; i < 4; i++) {
        		int x = temp[0] + dx[i];
        		int y = temp[1] + dy[i];
        		int m = temp[2] + (dir[i] == temp[3] ? 100 : 600);
        		
				if(x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] != 1) {
					if(board[x][y] >= m) {
						board[x][y] = m;
						que.offer(new int[] {x, y, m, dir[i]});
					} else if(board[x][y] + 500 >= m) {
						que.offer(new int[] {x, y, m, dir[i]});
					}
				}
			}
        }
        
        return board[board.length-1][board[0].length-1];
    }
}