import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
		int idx = 0;
		
		while(n != 0) {
			if(s < n) return new int[] {-1};
			
			answer[idx++] = s/n;
			s -= s/n;
			n--;
		}
		
		Arrays.sort(answer);
		
        return answer;
    }
}