import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double, Integer> map = new TreeMap<>();
        
        for (int weight : weights) {
			map.put((double)weight, map.getOrDefault((double)weight, 0) + 1);
		}
        
        Iterator<Double> it = map.keySet().iterator();
        while(it.hasNext()) {
        	double weight = it.next();
        	long cnt = map.get(weight);
        	if(map.containsKey(weight) && cnt >= 2) {
				answer += (cnt-1)*cnt/2;
			} 
			if(map.containsKey(weight*2)) {
				answer += cnt * map.get(weight*2);
			}
			
			if(map.containsKey(weight/2*3)) {
				answer += cnt * map.get(weight/2*3);
			}
			
			if(map.containsKey(weight/3*4)) {
				answer += cnt * map.get(weight/3*4);
			}
			
			it.remove();
        }
        
        return answer;
    }
}