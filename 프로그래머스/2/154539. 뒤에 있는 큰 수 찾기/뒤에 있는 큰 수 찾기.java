import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> st = new Stack<>();
		
		for (int i = 0; i < numbers.length; i++) {
			if(st.isEmpty()) {
				st.add(new int[] {numbers[i], i});
				continue;
			}
			
			while(!st.isEmpty()) {
				int[] temp = st.peek();
				if(temp[0] < numbers[i]) {
					st.pop();
					numbers[temp[1]] = numbers[i];
				} else {
					break;
				}
			}
			st.add(new int[] {numbers[i], i});
		}
		
		while(!st.isEmpty()) {
			int[] temp = st.pop();
			numbers[temp[1]] = -1;
		}
		
		return numbers;
    }
}