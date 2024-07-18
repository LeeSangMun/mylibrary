import java.util.*;

class Data {
	int x;
	int y;
	int[][] board;
	int idx;
	int len;
	public Data(int x, int y, int[][] board, int idx, int len) {
		this.x = x;
		this.y = y;
		this.board = board;
		this.idx = idx;
		this.len = len;
	}
}

class Solution {
    static List<Integer> list = new ArrayList<>();
	static Map<Integer, List<int[]>> map = new HashMap<>();
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE;
	static final int LENGTH = 4;
	
	public static int solution(int[][] board, int r, int c) {
        for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				if(board[i][j] != 0) {
					if(!list.contains(board[i][j]))  {
						list.add(board[i][j]);
						map.put(board[i][j], new ArrayList<>());
					}
					map.get(board[i][j]).add(new int[] {i,j});
				}
			}
		}
        
        f(board, new boolean[list.size()], new int[list.size()], 0, r, c);
        
        return answer;
    }
	
	static void f(int[][] board, boolean[] visited, int[] seq, int cnt, int r, int c) {
		if(seq.length == cnt) {
			f(board, seq, r, c);
			return;
		}
		
		for (int i = 0; i < seq.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				seq[cnt] = list.get(i);
				f(board, visited, seq, cnt+1, r, c);
				visited[i] = false;
			}
		}
	}
	
	static void f(int[][] board, int[] seq, int r, int c) {
		List<int[]> list = null;
		Data data = null;
		Queue<Data> que = new LinkedList<>();
		que.offer(new Data(r, c, board.clone(), 0, 0));
		
		while(!que.isEmpty()) {
			Data temp = que.poll();			
			list = map.get(seq[temp.idx]);
			
			data = bfs(bfs(temp , list.get(0)), list.get(1));

			if(data.idx == seq.length - 1) {
				answer = Math.min(answer, data.len);
			} else {
				data.idx++;
				que.offer(data);
			}

			data = bfs(bfs(temp , list.get(1)), list.get(0));
			
			if(data.idx == seq.length - 1) {
				answer = Math.min(answer, data.len);
			} else {
				data.idx++;
				que.offer(data);
			}
		}
	}
	
	static Data bfs(Data data, int[] p) {
		Queue<Data> que = new LinkedList<>();
		boolean[][] visited = new boolean[LENGTH][LENGTH];
		
		if(data.x == p[0] && data.y == p[1]) {
			int[][] board = data.board.clone();
			board[data.x][data.y] = 0;
			return new Data(data.x, data.y, board, data.idx, data.len+1);
		}
		que.offer(data); 
		visited[data.x][data.y] = true;
		
		while(!que.isEmpty()) {
			Data temp = que.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];
				
				if(x >= 0 && x < LENGTH && y >= 0 && y < LENGTH && !visited[x][y]) {
					if(x == p[0] && y == p[1]) {
						int[][] board = new int[LENGTH][LENGTH];
						for (int j = 0; j < LENGTH; j++) {
							for (int k = 0; k < LENGTH; k++) {
								board[j][k] = temp.board[j][k];
							}
						}
						board[x][y] = 0;
						return new Data(x, y, board, temp.idx, temp.len+2);
					} 
					
					que.offer(new Data(x, y, temp.board, temp.idx, temp.len+1));
					visited[x][y] = true;
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int x = temp.x;
				int y = temp.y;
				
				while(true) {
					x += dx[i];
					y += dy[i];
					
					if(!(x >= 0 && x < LENGTH && y >= 0 && y < LENGTH)) {
						x -= dx[i];
						y -= dy[i];
						break;
					} else if(temp.board[x][y] != 0) {
						break;
					}
				}
				
				if(!visited[x][y]) {
					if(x == p[0] && y == p[1]) {
						int[][] board = new int[LENGTH][LENGTH];
						for (int j = 0; j < LENGTH; j++) {
							for (int k = 0; k < LENGTH; k++) {
								board[j][k] = temp.board[j][k];
							}
						}
						board[x][y] = 0;
						return new Data(x, y, board, temp.idx, temp.len+2);
					}
					
					que.offer(new Data(x, y, temp.board, temp.idx, temp.len+1));
					visited[x][y] = true;
				}
			}
		}
		
		return data;
	}
}