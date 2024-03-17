import java.util.*;

class Solution {
    public int solution(String[] board) {
        Queue<int[]> que = new LinkedList<>();
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        char[][] b = new char[board.length][board[0].length()];
        int[] r = new int[3];
        
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if(board[i].charAt(j) == 'R') {
					r[0] = i;
					r[1] = j;
				}
				b[i][j] = board[i].charAt(j);
			}
		}
        
        que.offer(r);
        
        while(!que.isEmpty()) {
        	int[] temp = que.poll();
        	
        	for (int i = 0; i < 4; i++) {
        		int x = temp[0];
        		int y = temp[1];
        		
        		while(x >= 0 && x < b.length && y >= 0 && y < b[0].length && b[x][y] != 'D') {
        			x += dx[i];
        			y += dy[i];
        		}
        		
        		x -= dx[i];
        		y -= dy[i];
        		
        		if(b[x][y] == 'G') {
        			return temp[2] + 1;
        		} else if(b[x][y] != 'X') {
        			que.add(new int[] {x, y, temp[2] + 1});
        			b[x][y] = 'X';
        		}
			}
        }
        
        return -1;
    }
}