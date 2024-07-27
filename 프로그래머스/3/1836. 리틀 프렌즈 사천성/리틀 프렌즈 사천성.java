import java.util.*;

class Solution {
    public String solution(int m, int n, String[] board) {
        String answer = "";
        List<String> list = new ArrayList<>();
        Map<String, int[]> map = new HashMap<>();

        boolean flag = true;
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char ch = board[i].charAt(j);
				String s = String.valueOf(ch);
				if(Character.isAlphabetic(ch) && !list.contains(s)) {
					list.add(s);
					map.put(s, new int[] {i, j});
				}
			}
		}
        list.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        
        while(list.size() != 0 && flag) {
        	flag = false;
        	for (int i = list.size() - 1; i >= 0; i--) {
				String s = list.get(i);
				int[] p = map.get(s);
				if(bfs(m, n, p, list, board, s)) {
					answer += s;
					flag = true;
					break;
				}
			}
        }
        
        return answer.length() != map.size() ? "IMPOSSIBLE" : answer;
    }
	
	static boolean bfs(int m, int n, int[] p, List<String> list, String[] board, String s) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] dir = {0, 1, 2, 3};
		
		que.offer(new int[] {p[0], p[1], -1, 0});
		visited[p[0]][p[1]] = true;
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			
			for (int j = 0; j < 4; j++) {
				int x = temp[0] + dx[j];
				int y = temp[1] + dy[j];
				int r = temp[2] == -1 ? temp[3] : (temp[2] != dir[j] ? temp[3] + 1 : temp[3]);
				int d = dir[j];
				
				if(x >= 0 && x < m && y >= 0 && y < n) {
					char ch = board[x].charAt(y);
					if(ch != '*' && r < 2 && !visited[x][y]) {
						if(s.equals(String.valueOf(ch))) {
							list.remove(s);
							board[p[0]] = board[p[0]].replace(ch, '.');
							board[x] = board[x].replace(ch, '.');
							return true;
						} else if(ch == '.') {
							que.offer(new int[] {x, y, d, r});
							visited[p[0]][p[1]] = true;
						}
					}
				}
			}
		}
		
		return false;
	}
}