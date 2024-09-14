import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int[][] parks = new int[park.length][park[0].length];
        
        for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length; j++) {
				parks[i][j] = park[i][j].equals("-1") ? 1 : 0;
			}
		}
        
        for (int i = 1; i < parks.length; i++) {
			for (int j = 1; j < parks[i].length; j++) {
				if(parks[i][j] != 0) {
                    parks[i][j] = Math.min(Math.min(parks[i-1][j], parks[i][j-1]), parks[i-1][j-1]) + 1;
                    answer = Math.max(answer, parks[i][j]);
                }
			}
		}
        
        Arrays.sort(mats);
        
        for (int i = mats.length - 1; i >= 0; i--) {
			if(mats[i] <= answer) {
				return mats[i];
			}
		}
        
        return -1;
    }
}