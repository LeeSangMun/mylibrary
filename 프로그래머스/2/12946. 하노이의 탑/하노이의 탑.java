import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
	
	public int[][] solution(int n) {
		hanoi(n, 1, 2, 3);
        return list.toArray(int[][]::new);
    }
	
	static void hanoi(int n, int from, int temp, int to) {
		if(n == 1) {
			list.add(new int[] {from, to});
			return;
		}
		
		hanoi(n-1, from, to, temp);
		list.add(new int[] {from, to});
		hanoi(n-1, temp, from, to);
	}
}