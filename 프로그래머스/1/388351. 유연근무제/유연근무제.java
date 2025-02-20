class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        
        for (int i = 0; i < timelogs.length; i++) {
			int t = (schedules[i] / 100) * 60 + schedules[i] % 100 + 10;
			
			for (int j = 0; j < timelogs[i].length; j++) {
				if((startday + j - 1) % 7 >= 5)
					continue;
				
				if(t < (timelogs[i][j] / 100) * 60 + timelogs[i][j] % 100) {
					answer--;
					break;
				}
			}
		}
        
        return answer;
    }
}