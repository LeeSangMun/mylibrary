import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
		Deque<int[]> dq = new LinkedList<>();

		for (int i = 0; i < stones.length; i++) {
			while (!dq.isEmpty() && dq.peekLast()[0] < stones[i])
				dq.pollLast();

			while (!dq.isEmpty() && i - dq.peekFirst()[1] >= k)
				dq.pollFirst();

			dq.offer(new int[] { stones[i], i });

			if (k - 1 <= i)
				answer = Math.min(answer, dq.peekFirst()[0]);
		}

		return answer;
    }
}