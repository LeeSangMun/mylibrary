import java.util.*;

class Solution {
    public int solution(int[][] board) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board.length; j++) {
        		set.add(i+""+j);
			}
		}
        
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					for (int i2 = i-1; i2 <= i+1; i2++) {
						for (int j2 = j-1; j2 <= j+1; j2++) {
							set.remove(i2 + "" + j2);
						}
					}
				} 
			}
        }
        
        return set.size();
    }
}