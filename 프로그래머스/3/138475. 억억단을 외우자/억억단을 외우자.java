import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] cnt = new int[e+1];
        int[] temp = new int[e+1];
        
        for (int i = 1; i < cnt.length; i++) {
			for (int j = i; j <= e; j += i) {
				cnt[j]++;
			}
		}

        int max = 0;
        int idx = cnt.length - 1;
        
        for (int i = e; i >= 1; i--) {
			if(max <= cnt[i]) {
				max = cnt[i];
				temp[i] = idx = i;
			} else {
				temp[i] = idx;
			}
		}
        
        for (int i = 0; i < starts.length; i++) {
			answer[i] = temp[starts[i]];
		}
        
        return answer;
    }
}