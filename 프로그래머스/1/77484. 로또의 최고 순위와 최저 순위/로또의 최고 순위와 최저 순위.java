class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int n = 0, z = 0;
        for (int lotto : lottos) {
			if(lotto == 0) {
				z++;
				continue;
			}
			
			for (int num : win_nums) {
				if(lotto == num) {
					n++;
					break;
				}
			}
		}
        
        return new int[] {7-(n+z) == 7 ? 6 : 7-(n+z), 7-n == 7 ? 6 : 7-n};
    }
}