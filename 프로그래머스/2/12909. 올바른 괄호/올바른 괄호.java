import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
        	if(ch == '(') {
        		st.push(ch);
        	} else if(ch == ')') {
        		try {
        			st.pop();
        		} catch(Exception e) {
        			return false;
        		}
			}
		}

        return st.empty();
    }
}