import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Map<String, List<Integer>> map = new HashMap<>();
		boolean[] flag = new boolean[4];
		
		for (int i = 0; i < info.length; i++) {
			int idx = info[i].lastIndexOf(" ");
			String[] temp = info[i].substring(0, idx).split(" ");
			int score = Integer.parseInt(info[i].substring(idx + 1));
			f(map, temp, score, flag, 0);
		}
		
		for (List<Integer> list : map.values()) {
			Collections.sort(list);
		}
		
		String pattern = " and ";
		
		for (int i = 0; i < query.length; i++) {
			String[] temp = query[i].replaceAll(pattern, "").split(" ");
			Integer score = Integer.parseInt(temp[1]);

			if(!map.containsKey(temp[0])) {
				answer[i] = 0;
				continue;
			}
			
			List<Integer> list = map.get(temp[0]);
			answer[i] = search(list, score);
		}
		
		return answer;
	}
	
	static void f(Map<String, List<Integer>> map, String[] temp, int score, boolean[] flag, int j) {
		String str = "";
		for (int i = 0; i < temp.length; i++) {
			if(flag[i]) {
				str += "-";
			} else {
				str += temp[i];
			}
		}
		
		List<Integer> list = map.get(str);
		if(list == null) {
			list = new ArrayList<>();
			map.put(str, list);
		}
		list.add(score);
		
		for (int i = j; i < flag.length; i++) {
			if(!flag[i]) {
				flag[i] = true;
				f(map, temp, score, flag, i+1);
				flag[i] = false;
			}
		}
	}
	
	static int search(List<Integer> list, Integer score) {
		int s = 0, e = list.size() - 1;
		
		while(s <= e) {
			int m = (s + e)/2;
			if(list.get(m) < score) {
				s = m + 1;
			}  else {
				e = m - 1;
			}
		}
		
		return list.size() - s;
	}
}