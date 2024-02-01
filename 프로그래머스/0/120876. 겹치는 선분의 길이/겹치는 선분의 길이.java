import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] temp = new int[2];
        
        for (int i = 0; i < lines.length; i++) {
        	temp[0] = Math.max(lines[i][0], lines[(i+1)%lines.length][0]);
            temp[1] = Math.min(lines[i][1], lines[(i+1)%lines.length][1]);
            
            if(temp[0] < temp[1]) {
            	for (int j = temp[0]+1; j <= temp[1]; j++) {
            		if(set.add(j)) answer++;
    			}
            }
		}
        
        return answer;
    }
}