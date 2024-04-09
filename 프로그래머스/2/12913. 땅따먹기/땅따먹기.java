import java.util.*;

class Solution {
    static int solution(int[][] land) {
		int[] temp = land[0];
		int[] answer = new int[4];
		int idx = 1;

		while(idx < land.length) {
			for (int i = 0; i < land[0].length; i++) {
				for (int j = 0; j < temp.length; j++) {
					if(i != j) {
						answer[j] = Math.max(land[idx][j] + temp[i], answer[j]);
					}
				}
			}
			temp = Arrays.copyOf(answer, answer.length);
			idx++;
		}
		
		return Arrays.stream(answer).max().getAsInt();
    }
}