import java.util.*;

class Data {
	List<Integer> list = new ArrayList<>();
	int in;
	int out;
}

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Data> map = new HashMap<>();
        Data data = null;
        int total = 0;
        
        for (int i = 0; i < edges.length; i++) {
        	data = map.getOrDefault(edges[i][0], new Data());
        	data.list.add(edges[i][1]);
        	data.out++;
			map.put(edges[i][0], data);
			data = map.getOrDefault(edges[i][1], new Data());
			data.in++;
			map.put(edges[i][1], data);
		}
        
        for (int key : map.keySet()) {
			Data d = map.get(key);
			if(d.out >= 2 && d.in == 0) {
				answer[0] = key;
				total = d.list.size();
				for (int i : d.list) {
					map.get(i).in--;
				}
				break;
			}
		}
        
        map.remove(answer[0]);
        
        for (Data d : map.values()) {
			if(d.out == 2 && d.in == 2) {
				answer[3]++;
			} else if((d.out == d.in && d.in == 0) || (d.in == 0 && d.out != 0)) {
				answer[2]++;
			}
		}
        answer[1] = total - answer[3] - answer[2];
        
        return answer;
    }
}