import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> record = new HashMap<>();
        Map<String, Integer> fee = new TreeMap<>();
        String[] temp;
        String[] time;
        
        for (String str : records) {
        	temp = str.split(" ");
        	if(temp[2].equals("IN")) {
        		time = temp[0].split(":");
        		record.put(temp[1], Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
        	} else {
        		time = temp[0].split(":");
        		fee.put(temp[1], fee.getOrDefault(temp[1], 0) + Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]) - record.get(temp[1]));
        		record.remove(temp[1]);
        	}
		}
        
        for (String str : record.keySet()) {
			fee.put(str, fee.getOrDefault(str, 0) + 1439 - record.get(str));
		}
        
        for (String str : fee.keySet()) {
			fee.put(str, fee.get(str) <= fees[0] ? fees[1] : fees[1] + (int)Math.ceil((double)(fee.get(str) - fees[0])/fees[2])*fees[3]);
		}
        
        return fee.values().stream().mapToInt(Integer::valueOf).toArray();
    }
}