import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] str;
		Map<String, String> map = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {
			if(!record[i].startsWith("Leave")) {
				str = record[i].split(" ");
				map.put(str[1], str[2]);
			}
		}

		for (String s : record) {
			if(!s.startsWith("Change")) {
				str = s.split(" ");
				if(str[0].equals("Enter")) {
					list.add(map.get(str[1]) + "님이 들어왔습니다.");
				} else {
					list.add(map.get(str[1]) + "님이 나갔습니다.");
				}
				
			}
		}
		
		return list.toArray(String[]::new);
    }
}