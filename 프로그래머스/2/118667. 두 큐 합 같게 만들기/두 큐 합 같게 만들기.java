import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long s1 = 0, s2 = 0;
        Integer n;
        Queue<Integer> que1 = new LinkedList<>(), que2 = new LinkedList<>();
        
        for (int i = 0; i < queue2.length; i++) {
			que1.add(queue1[i]);
			que2.add(queue2[i]);
			s1 += queue1[i];
			s2 += queue2[i];
		}
        
        while(answer <= queue1.length*3) {
        	if(s1 > s2) {
        		n = que1.poll();
        		que2.offer(n);
        		s1 -= n;
        		s2 += n;
        	} else if(s1 < s2) {
        		n = que2.poll();
        		que1.offer(n);
        		s1 += n;
        		s2 -= n;
        	} else {
        		break;
        	}
        	answer++;
        }
        
        return s1 == s2 ? answer : -1;
    }
}