import java.util.*;

class Solution {
    static List<Integer>[] map;
	static long answer = 0;
	static long cnt = 0;
	static boolean[] flag;
	static int[] temp;
	
	public static long solution(int[] a, int[][] edges) {
        flag = new boolean[a.length];
        map = new ArrayList[a.length];
        temp = a;
        
        for (int i = 0; i < map.length; i++) {
			map[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < edges.length; i++) {
        	map[edges[i][0]].add(edges[i][1]);
        	map[edges[i][1]].add(edges[i][0]);
		}
        
        f(0);
        
        return answer != 0 ? -1 : cnt;
    }
	
	static long f(int n) {
		long sum = temp[n];
		flag[n] = true;
		
		for (int i = 0; i < map[n].size(); i++) {
			int num = map[n].get(i);
			
			if(!flag[num]) {
				sum += f(num);
			}
		}
		
		cnt += Math.abs(sum);
		answer += temp[n];
		
		return sum;
	}
}