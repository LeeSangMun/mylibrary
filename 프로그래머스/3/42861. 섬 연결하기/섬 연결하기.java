import java.util.*;

class Solution {
    static void union(int[] parent, int a, int b) {
		a = find(parent, a);
		b = find(parent, b);
		
		parent[a] = parent[b] = Math.min(a, b);
	}
	
	static int find(int[] parent, int n) {
		if(parent[n] == n) return n;
		
		return find(parent, parent[n]);
	}
	
	public int solution(int n, int[][] costs) {
		int answer = 0;
		int[] parent = new int[n];
		
		Arrays.sort(costs, (arr1, arr2) -> arr1[2] - arr2[2]);
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < costs.length; i++) {
			if(find(parent, costs[i][0]) != find(parent, costs[i][1])) {
				answer += costs[i][2];
				union(parent, costs[i][0], costs[i][1]);
			}
		}
		
		return answer;
	}
}