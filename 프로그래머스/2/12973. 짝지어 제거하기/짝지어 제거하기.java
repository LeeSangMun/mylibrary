import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        st.push(' ');
        
        for (Character ch : s.toCharArray()) {
			if(st.peek() == ch) {
				st.pop();
			} else {
				st.push(ch);
			}
		}
       
        return st.size() == 1 ? 1 : 0;
    }
}