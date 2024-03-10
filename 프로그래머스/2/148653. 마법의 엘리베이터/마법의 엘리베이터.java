import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
		Queue<Integer> que = new LinkedList<>();
		
		while(storey != 0) {
			que.offer(storey%10);
			storey /= 10;
		}
		
		int a = que.poll();
		
		while(!que.isEmpty()) {
			int b = que.poll();
			if(b >= 5) {
				if(a >= 5) {
					answer += 10 - a;
					b++;
				} else {
					answer += a;
				}
			} else {
				if(a >= 6) {
					answer += 10 - a;
					b++;
				} else {
					answer += a;
				}
			}
			a = b;
		}
		
		if(a >= 6) {
			answer += 10 - a + 1;
		} else {
			answer += a;
		}
		
		
		return answer;
    }
}