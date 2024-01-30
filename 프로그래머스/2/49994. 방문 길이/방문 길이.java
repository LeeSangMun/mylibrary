import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] pos = {0, 0};
        String str = pos[0] + "" + pos[1];
        Set<String> set = new HashSet<>();
        
        for (char ch : dirs.toCharArray()) {
        	str = pos[0] + "" + pos[1];
			if(ch == 'U') {
				pos[1]++;
				if(pos[1] > 5) {
					pos[1] = 5;
					continue;
				}
			} else if(ch == 'L') {
				pos[0]--;
				if(pos[0] < -5) {
					pos[0] = -5;
					continue;
				}
			} else if(ch == 'R') {
				pos[0]++;
				if(pos[0] > 5) {
					pos[0] = 5;
					continue;
				}
			} else {
				pos[1]--;
				if(pos[1] < -5) {
					pos[1] = -5;
					continue;
				}
			}
			if(set.add(str + pos[0] + pos[1]) && set.add(pos[0] + "" + pos[1] + str)) {
				answer++;
			}
		}
        
        return answer;
    }
}