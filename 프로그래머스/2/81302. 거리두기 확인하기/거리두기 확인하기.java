import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
		Arrays.fill(answer, 1);
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < places.length; i++) {
			list.clear();
			for (int j = 0; j < places[i].length; j++) {
				for (int k = 0; k < places[i][j].length(); k++) {
					if (places[i][j].charAt(k) == 'P')
						list.add(new int[] { j, k });
				}
			}
			outer: for (int j = 0; j < list.size() - 1; j++) {
				for (int k = j + 1; k < list.size(); k++) {
					int[] p1 = list.get(j);
					int[] p2 = list.get(k);
					int d = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

					if (d == 1) {
						answer[i] = 0;
					} else if (d <= 2) {
						for (int l = Math.min(p1[0], p2[0]); l <= Math.max(p1[0], p2[0]); l++) {
							for (int l2 = Math.min(p1[1], p2[1]); l2 <= Math.max(p1[1], p2[1]); l2++) {
								if (places[i][l].charAt(l2) == 'O') {
									answer[i] = 0;
									break outer;
								}
							}
						}
					}
				}
			}
		}

		return answer;
    }
}