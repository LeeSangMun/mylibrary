import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nodes.length; i++) {
			map.put(nodes[i], new ArrayList<>());
		}
        
        for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}
        
        for (int n : map.keySet()) {
        	if(set.contains(n)) continue;
        	
        	Queue<Integer> que = new LinkedList<>();
			int sCnt = 0;
			int dCnt = 0;
			
			set.add(n);
			que.offer(n);
			
			while(!que.isEmpty()) {
				int temp = que.poll();
				
				if(temp % 2 == map.get(temp).size() % 2) sCnt++;
				else dCnt++;
				
				for(int i : map.get(temp)) {
					if(!set.contains(i)) {
						que.offer(i);
						set.add(i);
					}
				}
			}
			
			if(sCnt == 1) answer[0]++;
			if(dCnt == 1) answer[1]++;
		}
        
        return answer;
    }
}