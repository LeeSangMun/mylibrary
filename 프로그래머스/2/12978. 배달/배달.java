import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
		int[] n = new int[N];
		Queue<int[]> que = new LinkedList<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<int[]> list = null;
        
        Arrays.fill(n, Integer.MAX_VALUE);
        n[0] = 0;
        
        for (int i = 0; i < road.length; i++) {
			list = map.get(road[i][0]);
			if(list == null) {
				list = new ArrayList<>();
				map.put(road[i][0], list);
			}
			list.add(new int[] {road[i][1], road[i][2]});
			
			list = map.get(road[i][1]);
			if(list == null) {
				list = new ArrayList<>();
				map.put(road[i][1], list);
			}
			list.add(new int[] {road[i][0], road[i][2]});
		}
        
        que.offer(new int[] {1, 0});
        
        while(!que.isEmpty()) {
        	int[] temp = que.poll();
        	
        	if(n[temp[0]-1] < temp[1]) 
        		continue;
        	
        	list = map.get(temp[0]);
        	for (int[] is : list) {
        		if(n[is[0]-1] > is[1] + temp[1]) {
        			n[is[0]-1] = is[1] + temp[1];
        			que.offer(new int[] {is[0], is[1] + temp[1]});
        		}
			}
        }
        
        for (int i = 0; i < n.length; i++) {
			if(n[i] <= K)
				answer++;
		}
        
        return answer;
    }
}