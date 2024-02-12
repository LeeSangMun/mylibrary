import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>();
		Map<String, Integer> reportMap = new HashMap<>();
		Map<String, String> reportId = new HashMap<>();
		Map<String, Integer> id = new LinkedHashMap<>();
		String[] str;

		for (String s : id_list) {
			id.put(s, 0);
		}

		for (String s : report) {
			if (set.add(s)) {
				str = s.split(" ");
				reportMap.put(str[1], reportMap.getOrDefault(str[1], 0) + 1);
				reportId.put(str[1], reportId.getOrDefault(str[1], "") + " " + str[0]);
			}
		}
		
		for (String idList : reportMap.keySet()) {
			if (reportMap.get(idList) >= k) {
				for (String s : reportId.get(idList).trim().split(" ")) {
					id.put(s, id.get(s) + 1);
				}
			}
		}

		return id.values().stream().mapToInt(Integer::valueOf).toArray();
    }
}