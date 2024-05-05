import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Stack<int[]> st = new Stack<>();
        
        Arrays.sort(routes, (arr1, arr2) -> arr1[1] - arr2[1]);
        st.push(routes[0]);
        
        for (int i = 1; i < routes.length; i++) {
			int[] temp = st.peek();
			if(routes[i][0] <= temp[1]) 
				continue;
			
			st.push(routes[i]);
		}
        
        return st.size();
    }
}