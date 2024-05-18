import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
		Map<String, String> e = new HashMap<>();
		Map<String, Integer> s = new HashMap<>();
		
		for (int i = 0; i < enroll.length; i++) {
			e.put(enroll[i], referral[i]);
		}
		
		for (int i = 0; i < seller.length; i++) {
			String next = seller[i];
			amount[i] *= 100;
			
			while(next != null) {
				if((int)(amount[i] * 0.1) == 0) {
					s.put(next, s.getOrDefault(next, 0) + amount[i]);
					break;
				} else {
					s.put(next, s.getOrDefault(next, 0) + amount[i] - (int)(amount[i] * 0.1));
				}
				
				amount[i] *= 0.1;
				next = e.get(next);
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			Integer n = s.get(enroll[i]);
			answer[i] = n == null ? 0 : n;
		}
		
		return answer;
    }
}