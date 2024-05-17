import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		Queue<int[]> que = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, Integer> tMap = new LinkedHashMap<>();
		List<Integer> list = null;

		for (int i = 0; i < sources.length; i++) {
			tMap.put(sources[i], -1);
		}

		for (int i = 0; i < roads.length; i++) {
			list = map.get(roads[i][0]);
			if (list == null) {
				list = new ArrayList<>();
				map.put(roads[i][0], list);
			}
			list.add(roads[i][1]);

			list = map.get(roads[i][1]);
			if (list == null) {
				list = new ArrayList<>();
				map.put(roads[i][1], list);
			}
			list.add(roads[i][0]);
		}

		que.offer(new int[] { destination, 0 });
		
		if (tMap.containsKey(destination))
			tMap.put(destination, 0);

		while (!que.isEmpty()) {
			int[] temp = que.poll();

			list = map.get(temp[0]);

			if (list == null)
				continue;

			for (int i : list) {
				if (tMap.containsKey(i)) {
					tMap.put(i, tMap.get(i) != -1 ? Math.min(tMap.get(i), temp[1] + 1) : temp[1] + 1);
				}
				que.offer(new int[] { i, temp[1] + 1 });
			}

			map.put(temp[0], null);
		}

		return tMap.values().stream().mapToInt(Integer::valueOf).toArray();
	}
}