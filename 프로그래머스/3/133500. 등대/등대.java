import java.util.*;

class Solution {
    static List<Integer>[] list;

	public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        list = new ArrayList[n];
        boolean[] visited = new boolean[n];
        boolean[] flag = new boolean[n];
        
        for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < lighthouse.length; i++) {
			list[lighthouse[i][0]-1].add(lighthouse[i][1]-1);
			list[lighthouse[i][1]-1].add(lighthouse[i][0]-1);
		}
        
        f(visited, flag, 0);
        
        for (int i = 0; i < flag.length; i++) {
			if(flag[i])
				answer++;
		}
        
        return answer;
    }
	
	static boolean f(boolean[] visited, boolean[] flag, int n) {
		boolean temp = false;
		
		for (int i : list[n]) {
			if(!visited[i]) {
				visited[i] = true;
				if(!f(visited, flag, i)) {
					flag[n] = true;
				}
			}
		}
		
		return flag[n];
	}
}