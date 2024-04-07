import java.util.*;

class Solution {
    static int answer = 0;
	static List<int[]> list = new LinkedList<>();

	public int solution(int n) {
        boolean[] flag = new boolean[n];
        
        for (int i = 0; i < n; i++) {
        	flag[i] = true;
        	list.add(new int[] {0, i});
			f(i, 1, flag);
			flag[i] = false;
			list.remove(list.size() - 1);
		}
        
        return answer;
    }
	
	static void f(int i, int cnt, boolean[] flag) {
		if(cnt == flag.length) {
			answer++;
			return;
		}
			
		for (int j = 0; j < flag.length; j++) {
			if(!flag[j] && check(cnt, j)) {
				flag[j] = true;
				list.add(new int[] {cnt, j});
				f(j, cnt+1, flag);
				flag[j] = false;
				list.remove(list.size() - 1);
			}
		}
	}
	
	static boolean check(int cnt, int j) {
		for (int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			if(cnt - j == temp[0] - temp[1] || cnt + j == temp[0] + temp[1])
				return false;
		}
		
		return true;
	}
}