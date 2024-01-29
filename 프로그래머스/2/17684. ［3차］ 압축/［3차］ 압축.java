import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String str = "";
        int idx = 0;
        
        for (int i = 0; i < 26; i++) {
			list.add(String.valueOf((char)('A'+i)));
		}
        
        for (int i = 0; i < msg.length(); i++) {
        	str = "";
        	int j;
			for (j = i; j < msg.length(); j++) {
				str += msg.charAt(j);
				if(list.contains(str)) {
					idx = list.indexOf(str)+1;
				} else {
					list.add(str);
					i = j-1;
					break;
				}
			}
			answer.add(idx);
			if(j == msg.length()) break;
		}
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}