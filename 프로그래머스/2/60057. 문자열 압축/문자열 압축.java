import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> st = new Stack<>();
		PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparing(String::length));
		int len = s.length();
		int cnt = 0;
		String temp = "";
		
		if(len == 1)
			return 1;
		
		for (int i = 1; i <= len / 2; i++) {
			temp = "";
			st.clear();
			for (int j = 0; j < Math.ceil((double) len / i); j++) {
				if (st.empty()) {
					st.push(s.substring(i * j, Math.min(i * j + i, len)));
				} else {
					if (st.peek().equals(s.substring(i * j, Math.min(i * j + i, len)))) {
						cnt++;
					} else {
						if (cnt == 0) {
							temp += st.peek();
						} else {
							temp += (cnt + 1) + st.peek();
						}
						st.push(s.substring(i * j, Math.min(i * j + i, len)));

						cnt = 0;
					}
				}
			}
			
			if (cnt == 0) {
				temp += st.peek();
			} else {
				temp += (cnt + 1) + st.peek();
				cnt = 0;
			}
			pq.offer(temp);
		}

		return pq.poll().length();
    }
}