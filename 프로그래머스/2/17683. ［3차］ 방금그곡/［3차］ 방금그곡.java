import java.util.*;

class Solution {
    public static String solution(String m, String[] musicinfos) {
		Map<String, Integer> map = new LinkedHashMap<>();
		String[] temp;
		StringBuilder sb = new StringBuilder();
		
		for (String musicinfo : musicinfos) {
			temp = musicinfo.split(",");
			int time = getMin(temp[1], 0) - getMin(temp[0], 1);
			int len = temp[3].replace("#", "").length();
			int j = 0;
			sb.setLength(0);
			
			if(time >= len)  {
				sb.append(temp[3].repeat(time/len));
			}
			
			for (int i = 0; i < time%len; i++) {
				sb.append(temp[3].charAt(j++));
				if(temp[3].charAt(j) == '#') {
					sb.append(temp[3].charAt(j++));
				}
			}
			
			int idx = 0;
			
			while((idx = sb.indexOf(m, idx)) != -1) {
				if(sb.charAt(idx + m.length() - 1) == '#') {
					map.put(temp[2], time);
					break;
				} else if(m.charAt(m.length()-1) != '#') {
					if(idx + m.length() < sb.length() && sb.charAt(idx + m.length()) != '#') {
						map.put(temp[2], time);
						break;
					} else if(idx + m.length() >= sb.length()) {
						map.put(temp[2], time);
						break;
					}
				}
				idx += 1;
			}
		}
		
		if(map.size() == 0)
			return "(None)";
		
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get().getKey();
	}
	
	static int getMin(String time, int flag) {
		String[] temp = time.split(":");
		
		if("00:00".equals(time) && flag == 2)
			return 1440;
		
		return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
	}
}