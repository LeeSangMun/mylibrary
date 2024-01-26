import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>();

		for (Integer i : scoville) {
			que.add(i);
		}

		while (que.peek() < K) {
			if (que.size() < 2)
				return -1;

			que.add(que.poll() + que.poll()*2);
			answer++;
		}

		return answer;
    }
}