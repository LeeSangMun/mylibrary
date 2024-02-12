import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for (String s : X.split("")) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		
		for (String s : Y.split("")) {
			if(map.getOrDefault(s, 0) != 0) {
				list.add(s);
				map.put(s, map.get(s) - 1);
			}
			
		}
		if(list.isEmpty()) {
			return "-1";
		} else if(Collections.max(list).equals("0")) {
			return "0";
		}
		
		list.sort(Comparator.reverseOrder());
		String answer = list.stream().collect(Collectors.joining());
		
		
		return answer;
    }
}