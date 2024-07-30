import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
		PriorityQueue<Integer>[] pq = new PriorityQueue[k];
		int[] mentors = new int[k];
		int[] times = new int[k];
		Arrays.fill(mentors, 1);
		n -= mentors.length;

		for (int i = 0; i < pq.length; i++) {
			pq[i] = new PriorityQueue<>();
		}
		
		int[] temp = mentors.clone();
		for (int i = 0; i < reqs.length; i++) {
			if(temp[reqs[i][2] - 1] > 0) {
				temp[reqs[i][2] - 1]--;
				pq[reqs[i][2]-1].offer(reqs[i][0] + reqs[i][1]);
			} else {
				if(pq[reqs[i][2]-1].peek() > reqs[i][0]) {
						times[reqs[i][2]-1] += pq[reqs[i][2]-1].peek() - reqs[i][0];
						pq[reqs[i][2]-1].offer(pq[reqs[i][2]-1].poll() + reqs[i][1]);
					} else {
						pq[reqs[i][2]-1].poll();
						pq[reqs[i][2]-1].offer(reqs[i][0] + reqs[i][1]);
					}
			}
		}

		while(n > 0) {
			for (int i = 0; i < pq.length; i++) {
				pq[i].clear();
			}
			
			temp = mentors.clone();
			int[] timeTemp = new int[k];
			int max = 0;
			int idx = 0;
			
			for (int i = 0; i < temp.length; i++) {
				temp[i]++;
			}
			
			for (int i = 0; i < reqs.length; i++) {
				if(temp[reqs[i][2] - 1] > 0) {
					temp[reqs[i][2] - 1]--;
					pq[reqs[i][2]-1].offer(reqs[i][0] + reqs[i][1]);
				} else {
					if(pq[reqs[i][2]-1].peek() > reqs[i][0]) {
						timeTemp[reqs[i][2]-1] += pq[reqs[i][2]-1].peek() - reqs[i][0];
						pq[reqs[i][2]-1].offer(pq[reqs[i][2]-1].poll() + reqs[i][1]);
					} else {
						pq[reqs[i][2]-1].poll();
						pq[reqs[i][2]-1].offer(reqs[i][0] + reqs[i][1]);
					}
				}
			}
			
			for (int i = 0; i < timeTemp.length; i++) {
				if(max < times[i] - timeTemp[i]) {
					max = times[i] - timeTemp[i];
					idx = i;
				}
			}
			
			n--;
			mentors[idx]++;
			times[idx] = timeTemp[idx];
		}
		
		for (int i = 0; i < pq.length; i++) {
			pq[i].clear();
		}
		
		for (int i = 0; i < reqs.length; i++) {
			if(mentors[reqs[i][2] - 1] > 0) {
				mentors[reqs[i][2] - 1]--;
				pq[reqs[i][2]-1].offer(reqs[i][0] + reqs[i][1]);
			} else {
				if(pq[reqs[i][2]-1].peek() > reqs[i][0]) {
					answer += pq[reqs[i][2]-1].peek() - reqs[i][0];
					pq[reqs[i][2]-1].offer(pq[reqs[i][2]-1].poll() + reqs[i][1]);
				} else {
					pq[reqs[i][2]-1].poll();
					pq[reqs[i][2]-1].offer(reqs[i][0] + reqs[i][1]);
				}
			}
		}

		return answer;
    }
}