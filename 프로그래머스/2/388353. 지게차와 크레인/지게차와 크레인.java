import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < requests.length; i++) {
        	char ch = requests[i].charAt(0);
        	
        	if(requests[i].length() == 1) {
        		for (int j = 0; j < storage.length; j++) {
        			for (int k = 0; k < storage[j].length(); k++) {
        				if(storage[j].charAt(k) == ch) {
        					if(check(storage, requests, j, k)) {
        						list.add(new int[] {j, k});
        					}
        				}
        			}
        		}
        	} else {
        		for (int j = 0; j < storage.length; j++) {
					for (int k = 0; k < storage[j].length(); k++) {
						if(storage[j].charAt(k) == ch)
							list.add(new int[] {j, k});
					}
				}
        	}
			
			for (int j = 0; j < list.size(); j++) {
				int[] temp = list.get(j);
				char[] cArr = storage[temp[0]].toCharArray();
				cArr[temp[1]] = '0';
				storage[temp[0]] = new String(cArr);
				answer++;
			}
			
			list.clear();
		}
        
        return storage.length * storage[0].length() - answer;
    }
	
	static boolean check(String[] storage, String[] requests, int i, int j) {
		if(i == 0 || j == 0 || i == storage.length - 1 || j == storage[i].length() - 1)
			return true;
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {i, j});
		int[] dx = { 1, 0, -1, 0 }; 
		int[] dy = { 0, 1, 0, -1}; 
		boolean[][] flag = new boolean[storage.length][storage[0].length()];
		
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				
				if(x >= 0 && y >= 0 && x < storage.length && y < storage[x].length() && !flag[x][y]) {
					if(storage[x].charAt(y) == '0') {
						if(x == 0 || y == 0 || x == storage.length - 1 || y == storage[x].length() - 1 ) {
							return true;
						}
						flag[x][y] = true;
						que.offer(new int[] {x, y});
					}
				}
			}
		}
		
		return false;
	}
}