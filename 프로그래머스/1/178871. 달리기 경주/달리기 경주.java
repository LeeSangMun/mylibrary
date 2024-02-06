import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>(); 
		int idx;
		String p;
		
		for (int i = 0; i < players.length; i++) {
			map.put(players[i], i);
			list.add(players[i]); 
		}
	
		for (String player : callings) { 
			idx = map.get(player);
			p = list.get(idx-1);
			
			map.put(player, map.get(player) - 1);
			map.put(p, map.get(p) + 1);
			
			Collections.swap(list, idx, idx-1);
		}
		
		return list.toArray(String[]::new);
    }
}