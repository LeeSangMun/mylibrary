import java.util.*;

class Data{
	int x;
	int y;
	char dir;
	public Data(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

class Solution {
    public int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        Queue<Data> que = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length()][4];
        int w = grid[0].length(), h = grid.length;
        
        map.put('U', 0);
        map.put('D', 1);
        map.put('L', 2);
        map.put('R', 3);
        
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				for (char key : map.keySet()) {
					if(!visited[i][j][map.get(key)]) {
						que.offer(new Data(i, j, key));
						visited[i][j][map.get(key)] = true;
						int n = 1;
						while(!que.isEmpty()) {
							Data temp = que.poll();
							
							if(temp.dir == 'U') {
								temp.x = (temp.x - 1 + h) % h;
								temp.dir = grid[temp.x].charAt(temp.y) == 'L' ? 'L' 
										: (grid[temp.x].charAt(temp.y) == 'R' ? 'R' : 'U');
							} else if(temp.dir == 'D') {
								temp.x = (temp.x + 1 + h) % h;
								temp.dir = grid[temp.x].charAt(temp.y) == 'L' ? 'R' 
										: (grid[temp.x].charAt(temp.y) == 'R' ? 'L' : 'D');
							} else if(temp.dir == 'L') {
								temp.y = (temp.y - 1 + w) % w;
								temp.dir = grid[temp.x].charAt(temp.y) == 'L' ? 'D' 
										: (grid[temp.x].charAt(temp.y) == 'R' ? 'U' : 'L');
							} else {
								temp.y = (temp.y + 1 + w) % w;
								temp.dir = grid[temp.x].charAt(temp.y) == 'L' ? 'U' 
										: (grid[temp.x].charAt(temp.y) == 'R' ? 'D' : 'R');
							}
							
							if(!visited[temp.x][temp.y][map.get(temp.dir)]) {
								que.offer(temp);
								visited[temp.x][temp.y][map.get(temp.dir)] = true;
								n++;
							}
						}
						list.add(n);
					}
				}
			}
		}
        
        return list.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }
}