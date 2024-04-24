import java.util.*;

class Solution {
    static TreeSet<int[]> set = new TreeSet<>((arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);
	
	public int[] solution(int[][] users, int[] emoticons) {
		boolean[] flag = new boolean[emoticons.length];
		int[] per = new int[emoticons.length];
		
		f(users, emoticons, flag, per, 0, 0);
		
		return set.last();
	}
	
	static void f(int[][] users, int[] emoticons, boolean[] flag, int[] per, int len, int idx) {
		for (int i = idx; i < flag.length; i++) {
			if (!flag[i]) {
				flag[i] = true;
				for (int j = 10; j <= 40; j+=10) {
					per[i] = j;
					f(users, emoticons, flag, per, len + 1, i+1);
				}
				flag[i] = false;
			}
		}
		
		if(len != emoticons.length)
			return;
		
		int[] temp = {0, 0};
		
		for (int i = 0; i < users.length; i++) {
			int sum = 0;
			int j = 0;
			for (j = 0; j < per.length; j++) {
				if(users[i][0] <= per[j]) {
					sum += emoticons[j] * (100-per[j]) / 100;
					if(sum >= users[i][1]) {
						temp[0]++;
						break;
					}
				}
			}
			
			if(j == per.length)
				temp[1] += sum;
		}
		
		set.add(temp);
	}
}