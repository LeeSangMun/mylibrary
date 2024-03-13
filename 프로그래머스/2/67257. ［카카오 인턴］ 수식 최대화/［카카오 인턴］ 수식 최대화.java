import java.util.*;

class Solution {
    public static long solution(String expression) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(calc(expression, new String[] {"+", "-", "*"}));
        pq.add(calc(expression, new String[] {"+", "*", "-"}));
        pq.add(calc(expression, new String[] {"-", "+", "*"}));
        pq.add(calc(expression, new String[] {"-", "*", "+"}));
        pq.add(calc(expression, new String[] {"*", "+", "-"}));
        pq.add(calc(expression, new String[] {"*", "-", "+"}));
        
        return pq.poll();
    }
	
	static long calc(String expression, String[] exp) {
		Deque<String> dq = new LinkedList<>();
		StringTokenizer stk = new StringTokenizer(expression, "*+-", true);
		
		while(stk.hasMoreTokens()) {
			dq.offerLast(stk.nextToken());
		}
        
        for (int i = 0; i < exp.length; i++) {
        	int size = dq.size();
        	for (int j = 0; j < size; j++) {
        		String temp = dq.pollFirst();
        		if(temp.equals(exp[i]) && exp[i].equals("*")) {
        			dq.offerLast(String.valueOf(Long.parseLong(dq.pollLast()) * Long.parseLong(dq.pollFirst())));
        			j++;
        		} else if(temp.equals(exp[i]) && exp[i].equals("+")) {
        			dq.offerLast(String.valueOf(Long.parseLong(dq.pollLast()) + Long.parseLong(dq.pollFirst())));
        			j++;
        		} else if(temp.equals(exp[i]) && exp[i].equals("-")) {
        			dq.offerLast(String.valueOf(Long.parseLong(dq.pollLast()) - Long.parseLong(dq.pollFirst())));
        			j++;
        		} else {
        			dq.offerLast(temp);
        		}
			}
        }
        
		return Math.abs(Long.parseLong(dq.poll()));
	}
}