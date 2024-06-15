import java.util.*;

class Solution {
    static int answer = 0;
	static ArrayList<Integer>[] map;
	
	public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        map = new ArrayList[info.length];
        
        for (int i = 0; i < map.length; i++) {
        	map[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < edges.length; i++) {
        	map[edges[i][0]].add(edges[i][1]);
			map[edges[i][1]].add(edges[i][0]);
		}
        
        visited[0] = true;
        f(map[0], info, visited, 0, 0, 1);
        
        return answer;
    }
	
	static void f(ArrayList<Integer> list, int[] info, boolean[] visited, int n, int wolf, int sheep) {
		if(wolf >= sheep) return;
		
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			if(!visited[num]) {
				ArrayList<Integer> temp = new ArrayList<>(list);
				temp.addAll(map[num]);
				visited[num] = true;
				answer = Math.max(answer, sheep + (info[num] == 0 ? 1 : 0));
				
				f(temp, info, visited, num, wolf + info[num], sheep + (info[num] == 0 ? 1 : 0));
				visited[num] = false;
			}
		}
	}
}