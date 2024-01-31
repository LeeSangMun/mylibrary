import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
		Arrays.sort(array);
		int s = 99;
				
		for (int i = 0; i < array.length; i++) {
			if(Math.abs(array[i] - n) < s) {
				answer = array[i]; 
				s = Math.abs(array[i] - n);
			}
		}
		
        return answer;
    }
}