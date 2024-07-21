import java.util.*;

class Solution {
    static int[] answer;
	static int max;
	static int Awin, Bwin;
	static int[][] newDice;

	public int[] solution(int[][] dice) {
		newDice = dice;
		boolean[] visited = new boolean[dice.length];
		visited[0] = true;

		f(1, visited, 1);

		for (int i = 0; i < answer.length; i++) {
			answer[i]++;
		}

		return answer;
	}
	
	static void f(int start, boolean[] visited, int cnt) {
		if (newDice.length / 2 == cnt) {
			int[] A = new int[newDice.length / 2];
			int[] B = new int[newDice.length / 2];
			int AIdx = 0, BIdx = 0;

			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					A[AIdx++] = i;
				else
					B[BIdx++] = i;
			}
			
			TreeMap<Integer, Integer> aMap = new TreeMap<>();
			TreeMap<Integer, Integer> bMap = new TreeMap<>();

			dfs(A, 0, 0, new boolean[newDice.length][6], aMap);
			dfs(B, 0, 0, new boolean[newDice.length][6], bMap);
			compare(aMap, bMap, A, B);

			return;
		}

		for (int i = start; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				f(i + 1, visited, cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	static void dfs(int[] A, int idx, int sum, boolean[][] visited, TreeMap<Integer, Integer> map) {
		if (idx == A.length) {
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			return;
		}

		for (int i = 0; i < newDice[A[idx]].length; i++) {
			if (!visited[A[idx]][i]) {
				visited[A[idx]][i] = true;
				dfs(A, idx + 1, sum + newDice[A[idx]][i], visited, map);
				visited[A[idx]][i] = false;
			}
		}
	}

	static void compare(TreeMap<Integer, Integer> aMap, TreeMap<Integer, Integer> bMap, int[] A, int[] B) {
		Awin = 0;
		Bwin = 0;
		
		for (int key : aMap.keySet()) {
			for (int n : bMap.headMap(key).values()) {
				Awin += n * aMap.get(key);
			}
		}

		for (int key : bMap.keySet()) {
			for (int n : aMap.headMap(key).values()) {
				Bwin += n * bMap.get(key);
			}
		}

		if(max < Awin) {
			max = Awin;
			answer = A;
		}
		
		if(max < Bwin) {
			max = Bwin;
			answer = B;
		}
	}
}