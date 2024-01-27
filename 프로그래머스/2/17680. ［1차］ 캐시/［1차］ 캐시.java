import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0; 
        Deque<String> que = new LinkedList<>();
        
        if(cacheSize == 0) return cities.length*5;
        
        for (String citie : cities) {
        	citie = citie.toLowerCase();
			if(que.size() < cacheSize) {
				if(que.contains(citie)) {
					que.remove(citie);
					que.offerLast(citie);
					answer++;
                    continue;
				}
				que.offerLast(citie);
				answer += 5;
			} else if(que.contains(citie)) {
				que.remove(citie);
				que.offerLast(citie);
				answer++;
			} else {
				que.pollFirst();
				que.offerLast(citie);
				answer += 5;
			}
		}

        return answer;
    }
}