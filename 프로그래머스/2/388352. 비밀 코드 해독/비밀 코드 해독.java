import java.util.*;

class Solution {
    static int answer = 0;
	
	public int solution(int n, int[][] q, int[] ans) {
        f(n, q, ans, 1, new ArrayList<>());
        
        return answer;
    }
	
	static void f(int n, int[][] q, int[] ans, int idx, List<Integer> list) {
		if(list.size() == 5) {
			for (int i = 0; i < q.length; i++) {
				int cnt = 0;
				
				for (int j = 0; j < q[i].length; j++) {
					if(list.contains(q[i][j])) {
						cnt++;
					}
				}
				
				if(cnt != ans[i])
					return;
			}
            
            answer++;
			
			return;
		}
		
		for (int i = idx; i <= n; i++) {
			list.add(i);
			f(n, q, ans, i + 1, list);
			list.remove(list.size() - 1);
		}
	}
}