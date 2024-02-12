import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] arr = new int[friends.length + 1][friends.length+1];
		int[] cntArr = new int[friends.length];
		Map<String, Integer> map = new HashMap<>();
		String[] str;
		
		for (int i = 0; i < friends.length; i++) {
			map.put(friends[i], i);
		}
		
		for (int i = 0; i < gifts.length; i++) {
			str = gifts[i].split(" ");
			arr[map.get(str[0])][map.get(str[1])]++; 
			arr[map.get(str[0])][arr[0].length-1]++;
			arr[arr.length-1][map.get(str[1])]++;
		}
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr[i].length-1; j++) {
				if(i == j) continue;
				
				if(arr[i][j] > arr[j][i]) {
					cntArr[i]++;
				} else if(arr[i][j] < arr[j][i]) {
					cntArr[j]++;
				} else {
					int u1 = arr[i][arr[i].length-1] - arr[arr.length-1][i];
					int u2 = arr[j][arr[j].length-1] - arr[arr.length-1][j];
					if(u1 - u2 > 0) {
						cntArr[i]++;
					} else if(u1 - u2 < 0) {
						cntArr[j]++;
					}
				}
			}
		}
		
		return Arrays.stream(cntArr).max().getAsInt();
    }
}