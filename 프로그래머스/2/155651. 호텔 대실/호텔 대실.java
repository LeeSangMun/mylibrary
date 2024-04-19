import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (arr1, arr2) -> arr1[0].compareTo(arr2[0]));
        
        pq.offer(getMin(book_time[0][1], true));
        
        for (int i = 1; i < book_time.length; i++) {
			while(!pq.isEmpty()) {
				int temp = pq.poll();
				if(temp > getMin(book_time[i][0], false)) {
					pq.offer(temp);
					pq.offer(getMin(book_time[i][1], true));
					answer = Math.max(answer, pq.size());
					break;
				}
			}
		}
        
        return answer == 0 ? 1 : answer;
    }
	
	static int getMin(String time, boolean flag) {
		String[] temp = time.split(":");
		
		return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]) + (flag ? 10 : 0);
	}
}