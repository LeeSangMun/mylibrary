import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] answer = new int[n][n];
        List<Integer> list = new ArrayList<>();
        
        int x = 0, y = 0;
        int i = 1;
        
        while(n > 0) {
        	for (int j = 0; j < n; j++) {
				answer[x++][y] = i++;
			}
        	
        	x--;
        	y++;
        	
        	for (int j = 0; j < n-1; j++) {
				answer[x][y++] = i++;
			}
        	
        	y--;
        	
        	for (int j = 0; j < n-2; j++) {
				answer[--x][--y] = i++;
			}
        	
        	x++;
        	
        	n -= 3;
        }
        
        for (int j = 0; j < answer.length; j++) {
			for (int k = 0; k < answer.length; k++) {
				if(answer[j][k] != 0) 
					list.add(answer[j][k]);
			}
		}
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}