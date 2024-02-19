import java.util.*;

class Solution {
    static Stack<int[]> st = new Stack<>();
	static int answer = 0;
	
	public static int solution(int k, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (k >= dungeons[i][0] && !st.contains(dungeons[i])) {
				st.add(dungeons[i]);
				answer = Math.max(answer, solution(k - dungeons[i][1], dungeons));
			}
		}

		if(!st.isEmpty())
			st.pop();

		return Math.max(answer, st.size() + 1);
	}
}