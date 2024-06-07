import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 9;
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {N, 1});

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			
			if(temp[0] == number) {
				answer = Math.min(answer, temp[1]);
				continue;
			} else if(temp[0] == 0) {
				continue;
			}
			
			for (int i = N, cnt = 1; cnt <= 8; i = i*10+N, cnt++) {
				if(cnt + temp[1] > 8) break;
				
				que.offer(new int[] {i + temp[0], cnt + temp[1]});
				que.offer(new int[] {i - temp[0], cnt + temp[1]});
				que.offer(new int[] {i * temp[0], cnt + temp[1]});
				que.offer(new int[] {i / temp[0], cnt + temp[1]});
				que.offer(new int[] {temp[0] - i, cnt + temp[1]});
				que.offer(new int[] {temp[0] / i, cnt + temp[1]});
			}
		}
		
		for (int i = N, cnt = 1; cnt <= 8; i = i*10+N, cnt++) {
			if(number == i) {
				answer = cnt;
				break;
			}
		}

		return answer != 9 ? answer : -1;
    }
}