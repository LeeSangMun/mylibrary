import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        Queue<int[]> que = new LinkedList<>();
        int N = board.length;
        boolean[][][] visited = new boolean[N][N][2];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        que.offer(new int[] {0, 0, 0, 1, 0, 0});
        visited[0][0][0] = visited[0][1][0] = true;
        
        while(!que.isEmpty()) {
        	int[] temp = que.poll();
        	
        	if(temp[2] == N-1 && temp[3] == N-1) {
        		answer = Math.min(answer, temp[4]);
        		continue;
        	}
        	
        	for (int i = 0; i < 4; i++) {
        		int x1 = temp[0] + dx[i];
        		int y1 = temp[1] + dy[i];
        		int x2 = temp[2] + dx[i];
        		int y2 = temp[3] + dy[i];
        		
        		if(x1 >= 0 && x1 < N && y1 >= 0 && y1 < N && x2 >= 0 && x2 < N && y2 >= 0 && y2 < N
        				&& board[x1][y1] != 1 && board[x2][y2] != 1 
        				&& (!visited[x1][y1][0] || !visited[x2][y2][0])) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, temp[5]});
        			visited[x1][y1][0] = true;
        		}
			}
        	
        	int x1, y1, x2, y2;
        	
        	if(temp[5] == 0) {
        		x1 = temp[2] - 1;
        		y1 = temp[3] - 1;
        		x2 = temp[0];
        		y2 = temp[1];
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x1][y1+1] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 1});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        		
        		x1 = temp[0] - 1;
        		y1 = temp[1] + 1;
        		x2 = temp[2];
        		y2 = temp[3];
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x1][y1-1] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 1});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        		
        		x1 = temp[0];
        		y1 = temp[1];
        		x2 = temp[2] + 1;
        		y2 = temp[3] - 1;
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x2][y2+1] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 1});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        		
        		x1 = temp[2];
        		y1 = temp[3];
        		x2 = temp[0] + 1;
        		y2 = temp[1] + 1;
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x2][y2-1] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 1});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        	} else {
        		x1 = temp[2] - 1;
        		y1 = temp[3] - 1;
        		x2 = temp[0];
        		y2 = temp[1];
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x1+1][y1] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 0});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        		
        		x1 = temp[0] + 1;
        		y1 = temp[1] - 1;
        		x2 = temp[2];
        		y2 = temp[3];
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x1-1][y1] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 0});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        		
        		x1 = temp[2];
        		y1 = temp[3];
        		x2 = temp[0] + 1;
        		y2 = temp[1] + 1;
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x2-1][y2] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 0});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        		
        		x1 = temp[0];
        		y1 = temp[1];
        		x2 = temp[2] - 1;
        		y2 = temp[3] + 1;
        		
        		if(check(board, visited, x1, y1, x2, y2, N) && board[x2+1][y2] != 1) {
        			que.offer(new int[] {x1, y1, x2, y2, temp[4] + 1, 0});
        			visited[x1][y1][1] = visited[x2][y2][1] = true;
        		}
        	}
        }
        
        return answer;
    }
	
	static boolean check(int[][] board, boolean[][][] visited, int x1, int y1, int x2, int y2, int N) {
		return x1 >= 0 && x1 < N && y1 >= 0 && y1 < N && x2 >= 0 && x2 < N && y2 >= 0 && y2 < N
				&& board[x1][y1] != 1 && board[x2][y2] != 1
				&& (!visited[x1][y1][1] || !visited[x2][y2][1]);
	}
}