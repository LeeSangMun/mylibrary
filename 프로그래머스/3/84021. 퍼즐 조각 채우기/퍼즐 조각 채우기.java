import java.util.*;

class Data {
	List<int[]> list = new ArrayList<>();
	int minX, minY, maxX, maxY;
	int[][] map;
	
	public Data(int minX, int minY) {
		this.minX = maxX = minX;
		this.minY = maxY = minY;
		list.add(new int[] {minX, minY});
	}
	
	public void makeMap() {
		for (int[] is : list) {
			is[0] -= minX;
			is[1] -= minY;
		}
		
		map = new int[maxX-minX+1][maxY-minY+1];
		
		for (int[] is : list) {
			map[is[0]][is[1]] = 1;
		}
		this.sort();
	}
	
	public void sort() {
		list.sort((arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);
	}

	public boolean check(int[][] map) {
		if(list.size() == 1 || list.size() == 2) 
			return true;
		
		int i = 0; 
		for (i = 0; i < 4; i++) {
			if(map.length != this.map.length || map[0].length != this.map[0].length) {
				this.rotate();
				continue;
			}
			
			boolean flag = false;
			outer:
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					if(this.map[j][k] != map[j][k]) {
						this.rotate();
						flag = true;
						break outer;
					}
				}
			}
			if(!flag) 
				break;
		}
		
		return i == 4 ? false : true;
	}

	public void rotate() {
		int[][] temp = new int[this.map[0].length][this.map.length];
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j] = this.map[this.map.length - 1 - j][i];
			}
		}
		
		this.map = temp;
	}
}

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
		final int SIZE = game_board.length;
		Map<Integer, List<Data>> map = new HashMap<>();
		Queue<int[]> que = new LinkedList<>();
		List<Data> list = null;
		Data data = null;
		boolean[][] visited = new boolean[SIZE][SIZE];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(table[i][j] == 1 && !visited[i][j]) {
					que.offer(new int[] {i, j});
					visited[i][j] = true;
					data = new Data(i, j);
					int n = 1;
					
					while(!que.isEmpty()) {
						int[] temp = que.poll();
						
						for (int k = 0; k < 4; k++) {
							int x = temp[0] + dx[k];
							int y = temp[1] + dy[k];
							
							if(x >= 0 && x < SIZE && y >= 0 && y < SIZE && table[x][y] == 1 && !visited[x][y]) {
								que.offer(new int[] {x, y});
								visited[x][y] = true;
								data.list.add(new int[] {x, y});
								data.minX = Math.min(data.minX, x);
								data.minY = Math.min(data.minY, y);
								data.maxX = Math.max(data.maxX, x);
								data.maxY = Math.max(data.maxY, y);
								n++;
							}
						}
					}
					
					list = map.get(n);
					if(list == null) {
						list = new ArrayList<>();
						map.put(n, list);
					}
					data.makeMap();
					list.add(data);
				}
			}
		}
		
		visited = new boolean[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(game_board[i][j] == 0 && !visited[i][j]) {
					que.offer(new int[] {i, j});
					visited[i][j] = true;
					data = new Data(i, j);
					int n = 1;
					
					while(!que.isEmpty()) {
						int[] temp = que.poll();
						
						for (int k = 0; k < 4; k++) {
							int x = temp[0] + dx[k];
							int y = temp[1] + dy[k];
							
							if(x >= 0 && x < SIZE && y >= 0 && y < SIZE && game_board[x][y] == 0 && !visited[x][y]) {
								que.offer(new int[] {x, y});
								visited[x][y] = true;
								data.list.add(new int[] {x, y});
								data.minX = Math.min(data.minX, x);
								data.minY = Math.min(data.minY, y);
								data.maxX = Math.max(data.maxX, x);
								data.maxY = Math.max(data.maxY, y);
								n++;
							}
						}
					}
					
					data.makeMap();
					
					if(map.containsKey(n) && map.get(n).size() != 0) {
						for (Data d : map.get(n)) {
							if(d.check(data.map)) {
								answer += n;
								map.get(n).remove(d);
								break;
							}
						}
					}
				}
			}
		}
		
		return answer;
    }
}