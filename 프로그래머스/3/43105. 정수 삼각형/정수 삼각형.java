import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[] temp = triangle[0].clone();
        int[] temp2 = null;
        
        for (int i = 0; i < triangle.length-1; i++) {
        	temp2 = new int[triangle[i+1].length];
        	for (int j = 0; j < temp.length; j++) {
				for (int k = j; k <= j+1; k++) {
					temp2[k] = Math.max(temp2[k], temp[j] + triangle[i+1][k]);
				}
			}
			temp = temp2;
		}
        
        return Arrays.stream(temp2).max().getAsInt();
    }
}