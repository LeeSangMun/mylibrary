import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			while(!st.empty() && st.peek() < ch && k > 0) {
				st.pop();
				k--;
			}
			
			st.push(ch);
		}
		
		return st.stream().limit(number.length()-k).map(String::valueOf).collect(Collectors.joining());
    }
}