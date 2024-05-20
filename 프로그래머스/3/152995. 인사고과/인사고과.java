import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        List<int[]> list = new ArrayList<>();
        int score = scores[0][0] + scores[0][1];
        
        for (int i = 1; i < scores.length; i++) {
			if(scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
				return -1;
			} else if(score < scores[i][0] + scores[i][1]) {
				int j = 0;
				
				for (j = list.size() - 1; j >= 0; j--) {
					int[] temp = list.get(j);
					if(temp[0] > scores[i][0] && temp[1] > scores[i][1]) {
						break;
					} else if(temp[0] < scores[i][0] && temp[1] < scores[i][1]) {
						list.remove(j);
					} 
				}
				
				if(j == -1) list.add(scores[i]);
			}
		}
        
        return list.size() + 1;
    }
}