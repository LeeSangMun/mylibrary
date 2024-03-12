import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        Queue<int[]> que = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
        int[][] map = new int[maps.length][maps[0].length()];
        
        int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};
        
        for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(maps[i].charAt(j) == 'X') {
					map[i][j] = -1;
				} else {
					map[i][j] = maps[i].charAt(j) - '0';
				}
			}
		}
        
        for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] != -1) {
					int sum = map[i][j];
					map[i][j] = -1;
					que.offer(new int[] {i, j});
					while(!que.isEmpty()) {
						int[] temp = que.poll();
						for (int k = 0; k < 4; k++) {
							int x = temp[0] + xArr[k];
							int y = temp[1] + yArr[k];
							
							if(x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != -1) {
								sum += map[x][y];
								map[x][y] = -1;
								que.offer(new int[] {x, y});
							}
						}
					}
					list.add(sum);
				}
			}
		}
        
        list.sort(null);
        return list.isEmpty() ? new int[] {-1} : list.stream().mapToInt(Integer::valueOf).toArray();
    }
}