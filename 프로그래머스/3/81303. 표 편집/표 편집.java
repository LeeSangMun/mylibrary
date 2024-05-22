import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        
        sb.append("O".repeat(n));
        
        for (int i = 0; i < cmd.length; i++) {
        	char ch = cmd[i].charAt(0);
        	
			if(ch == 'U') {
				k -= Integer.parseInt(cmd[i].substring(2));
			} else if(ch == 'D') {
				k += Integer.parseInt(cmd[i].substring(2));
			} else if(ch == 'C') {
				st.push(k);
				sb.deleteCharAt(k);
				
				k = Math.min(k, sb.length() - 1);
			} else {
				if(st.pop() <= k) k++;
				
				sb.append('O');
			}
		}
        
        while(!st.isEmpty()) {
        	sb.insert(st.pop().intValue(), 'X');
        }
        
        return sb.toString();
    }
}