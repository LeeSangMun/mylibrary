import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
		List<int[]> list = new ArrayList<>();
		int cnt = 0;
		
		for (int pick : picks) {
			cnt += pick;
		}

		for (int i = 0; i < (Math.min(minerals.length, cnt * 5) - 1) / 5 + 1; i++) {
			int[] temp = new int[3];
			for (int j = i*5; j < Math.min(i*5+5, minerals.length); j++) {
				temp[0] += 1;
				if(minerals[j].equals("diamond")) {
					temp[1] += 5;
					temp[2] += 25;
				} else if(minerals[j].equals("iron")) {
					temp[1] += 1;
					temp[2] += 5;
				} else {
					temp[1] += 1;
					temp[2] += 1;
				}
			}
			list.add(temp);
		}
		
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[0] + arr2[1] == arr1[1] + arr2[0] && arr1[0] + arr2[2] == arr1[2] + arr2[0]) {
					return arr1[1] + arr2[2] - (arr1[2] + arr2[1]);
				} else if(arr1[0] + arr2[1] == arr1[1] + arr2[0]) {
					return arr1[0] + arr2[2] - (arr1[2] + arr2[0]);
				} else {
					return arr1[0] + arr2[1] - (arr1[1] + arr2[0]);
				}
			}
		});
		
		for (int[] pick : list) {
			if(picks[0] > 0) {
				answer += pick[0];
				picks[0]--;
			} else if(picks[1] > 0) {
				answer += pick[1];
				picks[1]--;
			} else {
				answer += pick[2];
				picks[2]--;
			}
		}

		return answer;
    }
}