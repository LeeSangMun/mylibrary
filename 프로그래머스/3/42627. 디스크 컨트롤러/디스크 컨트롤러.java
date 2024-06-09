import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
		Arrays.sort(jobs, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
		pq.offer(jobs[0]);
		int idx = 1;
		int time = jobs[0][0];

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			time += temp[1];
			answer += time - temp[0];
			
			while (idx < jobs.length && jobs[idx][0] <= time) {
				pq.offer(jobs[idx++]);
			}
			
			if(idx < jobs.length && pq.isEmpty()) {
				pq.offer(jobs[idx++]);
				time = pq.peek()[0];
			}
		}

		return answer / jobs.length;
    }
}