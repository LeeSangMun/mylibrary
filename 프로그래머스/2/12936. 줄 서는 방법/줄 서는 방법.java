import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();
		long sum = 1;
		
		for (int i = 1; i <= n; i++) {
			sum *= i;
			list.add(i);
		}
		
		long m = sum/n;
		int i = 0;
		
		while(k != 0) {
			answer[i] = list.get((int)((k-1)/m));
			list.remove(Integer.valueOf(answer[i]));
			i++;
			if(list.isEmpty()) 
				break;
			k = (k-1) % m + 1;
			m = m / list.size();
		}
		
		for (Integer num : list) {
			answer[i++] = num;
		}
		
		return answer;
    }
}