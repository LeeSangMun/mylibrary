import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = 1;
        int sum = 0;
        
        while(n <= elements.length) {
        	for (int i = 0; i < elements.length; i++) {
				for (int j = i; j < i+n; j++) {
					sum += elements[j%elements.length];
				}
				set.add(sum);
				sum = 0;
			}
        	
        	n++;
        }
         
        return set.size();
    }
}