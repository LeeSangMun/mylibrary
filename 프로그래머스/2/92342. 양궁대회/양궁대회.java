import java.util.*;

class Solution {
    static int[] answer = new int[12];

	public int[] solution(int n, int[] info) {
		int[] temp = new int[info.length];

		f(n, info, temp);
		return answer[11] == 0 ? new int[] {-1} : Arrays.copyOf(answer, 11);
	}

	static void f(int n, int[] info, int[] temp) {
		if (n == 0) {
			int sum = 0;

			for (int i = 0; i < info.length; i++) {
				if (info[i] == 0 && temp[i] == 0) {
					continue;
				} else if (info[i] >= temp[i]) {
					sum += 10 - i;
				} else {
					sum -= 10 - i;
				}
			}
			
			if (sum < answer[11]) {
				System.arraycopy(temp, 0, answer, 0, temp.length);
				answer[11] = sum;
			} else if(sum == answer[11]) {
				for (int i = temp.length-1; i >= 0; i--) {
					if(answer[i] == temp[i]) {
						continue;
					} else if(answer[i] < temp[i]) {
						System.arraycopy(temp, 0, answer, 0, temp.length);
						answer[11] = sum;
					}
					break;
				}
			}

			return;
		}

		for (int i = 10; i >= 0; i--) {
			if (temp[i] > info[i])
				return;
			temp[i]++;
			f(n - 1, info, temp);
			temp[i]--;
		}
	}
}