class Solution {
    public int[] solution(int target) {
        int[][] temp = new int[target + 1][2];

		for (int i = 1; i <= target; i++) {
			int total = 0;
			int sb = 0;
			int[] t = { Integer.MAX_VALUE, 0 };

			for (int j = 3; j <= 60; j += 3) {
				if (i < j)
					break;

				total = temp[i - j][0] + 1;
				sb = temp[i - j][1];
				
				if(t[0] > total) {
					t[0] = total;
					t[1] = sb;
				} else if(t[0] == total && t[1] < sb) {
					t[1] = sb;
				}
			}
			
			for (int j = 2; j <= 40; j += 2) {
				if (i < j)
					break;

				total = temp[i - j][0] + 1;
				sb = temp[i - j][1];
				
				if(t[0] > total) {
					t[0] = total;
					t[1] = sb;
				} else if(t[0] == total && t[1] < sb) {
					t[1] = sb;
				}
			}
			
			for (int j = 1; j <= 20; j++) {
				if (i < j)
					break;

				total = temp[i - j][0] + 1;
				sb = temp[i - j][1] + 1;
				
				if(t[0] > total) {
					t[0] = total;
					t[1] = sb;
				} else if(t[0] == total && t[1] < sb) {
					t[1] = sb;
				}
			}
			
			for (int j = 50; j <= target; j += 50) {
				if (i < j)
					break;

				total = temp[i - j][0] + j/50;
				sb = temp[i - j][1] + j/50;
				
				if(t[0] > total) {
					t[0] = total;
					t[1] = sb;
				} else if(t[0] == total && t[1] < sb) {
					t[1] = sb;
				}
			}
			
			temp[i] = t;
		}

		return temp[target];
    }
}