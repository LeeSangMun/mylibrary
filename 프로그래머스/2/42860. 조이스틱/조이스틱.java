import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = name.length() - 1;
		Stack<int[]> st = new Stack<>();
		
		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i) == 'A') {
				int[] temp = {i, i};
				for (int j = i+1; j < name.length(); j++) {
					if(name.charAt(j) != 'A') {
						break;
					}
					i = j;
					temp[1]++;
				}
				st.push(temp);
			}
		}
		
		while(!st.isEmpty()) {
			int[] temp = st.pop();
			int len = 0;
			if(temp[0] == 0) {
				len = name.length()-temp[1]-1;
			} else if(temp[1] == name.length() - 1) {
				len = temp[0] -1;
			} else {
				len = Math.min((temp[0]-1)*2 + name.length() - temp[1] - 1, (name.length() - temp[1] - 1)*2 - 1 + temp[0]);
			}
			answer = Math.min(answer, len);
        }
		
		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
		}
		
		return answer;
    }
}