import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Stack<int[]> st = new Stack<>();
        Arrays.sort(targets, (arr1, arr2) -> arr1[1] - arr2[1]);        
        st.push(targets[0]);
        
        for (int i = 1; i < targets.length; i++) {
        	int temp[] = st.peek();
        	if((temp[1] > targets[i][0] && temp[1] <= targets[i][1])) {
        		continue;
        	}
			
			st.add(targets[i]);
		}
        
        return st.size();
    }
}