import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
		int[][] temp = new int[rows][columns];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i][j] = i * temp[i].length + j + 1;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int p = 0;

			for (int j = queries[i][1] - 1; j <= queries[i][3] - 1; j++) {
				list.add(temp[queries[i][0] - 1][j]);
			}

			for (int j = queries[i][0]; j <= queries[i][2] - 1; j++) {
				list.add(temp[j][queries[i][3] - 1]);
			}

			for (int j = queries[i][3] - 2; j >= queries[i][1] - 1; j--) {
				list.add(temp[queries[i][2] - 1][j]);
			}

			for (int j = queries[i][2] - 2; j >= queries[i][0]; j--) {
				list.add(temp[j][queries[i][1] - 1]);
			}

			answer[i] = Collections.min(list);
			Collections.rotate(list, 1);

			for (int j = queries[i][1] - 1; j <= queries[i][3] - 1; j++) {
				temp[queries[i][0] - 1][j] = list.get(p++);
			}

			for (int j = queries[i][0]; j <= queries[i][2] - 1; j++) {
				temp[j][queries[i][3] - 1] = list.get(p++);
			}

			for (int j = queries[i][3] - 2; j >= queries[i][1] - 1; j--) {
				temp[queries[i][2] - 1][j] = list.get(p++);
			}

			for (int j = queries[i][2] - 2; j >= queries[i][0]; j--) {
				temp[j][queries[i][1] - 1] = list.get(p++);
			}
			
			list.clear();
		}

		return answer;
    }
}