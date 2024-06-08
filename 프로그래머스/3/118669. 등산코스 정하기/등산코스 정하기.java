import java.util.*;

class Solution {
    static int[] answer = {50000, 10000000};
	
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		Queue<int[]> que = new LinkedList<>();
		Map<Integer, List<int[]>> map = new HashMap<>();
		List<int[]> list = null;
		boolean[] summit = new boolean[n];
		boolean[] gate = new boolean[n];
		
		for (int i = 0; i < paths.length; i++) {
			list = map.get(paths[i][0]);
			if (list == null) {
				list = new ArrayList<>();
				map.put(paths[i][0], list);
			}
			list.add(new int[] { paths[i][1], paths[i][2] });

			list = map.get(paths[i][1]);
			if (list == null) {
				list = new ArrayList<>();
				map.put(paths[i][1], list);
			}
			list.add(new int[] { paths[i][0], paths[i][2] });
		}
		
		for (int i = 0; i < summits.length; i++) {
			summit[summits[i] - 1] = true;
		}
		
		for (int i = 0; i < gates.length; i++) {
			gate[gates[i] - 1] = true;
		}
		
		int[] weight = new int[n];
		for (int i = 0; i < gates.length; i++) {
			que.offer(new int[] {gates[i], 0});
			weight[gates[i] - 1] = -1;
			
			while(!que.isEmpty()) {
				int[] temp = que.poll();
				
				if(summit[temp[0] - 1]) {
					if(answer[1] > temp[1]) {
						answer[0] = temp[0];
						answer[1] = temp[1];
					} else if(answer[1] == temp[1]) {
						answer[0] = Math.min(answer[0], temp[0]);
					}
					
					continue;
				} else if(answer[1] < temp[1]) {
					continue;
				}
				
				for (int[] arr : map.get(temp[0])) {
					if(Math.max(temp[1], arr[1]) < weight[arr[0] - 1] || weight[arr[0] - 1] == 0) {
						que.offer(new int[] {arr[0], Math.max(temp[1], arr[1])});
						weight[arr[0] - 1] = Math.max(temp[1], arr[1]);
					}
				}
			}
		}
		
		return answer;
	}
}