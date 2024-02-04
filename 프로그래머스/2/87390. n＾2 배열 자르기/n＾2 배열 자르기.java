import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = (int)(left/n); i <= (int)(right/n); i++) {
			for (int j = 0; j < n; j++) {
				if((long)i*n+j >= left && (long)i*n+j <= right) {
					list.add(Math.max(i, j)+1);
				}
			}
		}
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}