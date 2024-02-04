import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
		Stack<Character> st = new Stack<>();
		int idx = 0;
		int l = s.length();
		
		while(idx < l) {
			boolean flag = false;
			for (int i = idx; i < idx + l; i++) {
				char ch = s.charAt(i%l);
				if("([{".indexOf(ch) != -1) {
					st.push(ch);
				} else if(st.isEmpty()) {
					flag = true;
					break;
				} else if(ch == ')') {
					if(st.pop() != '(') {
						flag = true;
						break;
					}
				} else if(ch == ']') {
					if(st.pop() != '[') {
						flag = true;
						break;
					}
				} else if(ch == '}') {
					if(st.pop() != '{') {
						flag = true;
						break;
					}
				}
			}
			
			if(!flag && st.isEmpty()) {
				answer++;
			}
			st.clear();
			idx++;
		}

		return answer;
    }
}