import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        List<int[]> list = new ArrayList<>();

		

		for (int i = 0; i < arr.length; i += 2) {
			for (int j = 0; j < arr.length; j += 2) {
				int[] temp = new int[3];
				temp[arr[i][j]]++;
				temp[arr[i + 1][j]]++;
				temp[arr[i][j + 1]]++;
				temp[arr[i + 1][j + 1]]++;
				if (temp[0] == 4) {
					temp[0] = 1;
					temp[2] = 0;
				} else if (temp[1] == 4) {
					temp[1] = 1;
					temp[2] = 1;
				} else {
					temp[2] = -1;
				}
				list.add(temp);
			}
		}

		while (list.size() != 1) {
			List<int[]> listTemp = new ArrayList<>();
			int len = list.size() / 4;
			int w = (int) Math.sqrt(list.size());

			for (int i = 0; i < len; i++) {
				int[] temp = new int[3];
				int idx = (i / (int) Math.sqrt(len)) * (w * 2) + (i % (int) Math.sqrt(len)) * 2;
				int[] temp1 = list.get(idx);
				int[] temp2 = list.get(idx + 1);
				int[] temp3 = list.get(idx + w);
				int[] temp4 = list.get(idx + w + 1);

				if (temp1[2] != -1 && temp1[2] == temp2[2] && temp1[2] == temp3[2] && temp1[2] == temp4[2]) {
					temp[temp1[2]] = 1;
					temp[2] = temp1[2];
				} else {
					temp[0] += temp1[0] + temp2[0] + temp3[0] + temp4[0];
					temp[1] += temp1[1] + temp2[1] + temp3[1] + temp4[1];
					temp[2] = -1;
				}
				listTemp.add(temp);
			}
			list = listTemp;
		}
		
		int[] temp = list.get(0);

		return new int[] { temp[0], temp[1] };
    }
}