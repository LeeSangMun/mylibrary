import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        List<int[]> list = Arrays.asList(data);
        list.sort((arr1, arr2) -> {
        	if(arr1[col-1] == arr2[col-1]) {
        		return arr2[0] - arr1[0];
        	} else {
        		return arr1[col-1] - arr2[col-1];
        	}
        });
        for (int i = row_begin; i <= row_end; i++) {
        	final int j = i;
			int[] arr = list.get(i-1);
			answer ^= Arrays.stream(arr).map(a -> a % j).sum();
		}
        
        return answer;
    }
}