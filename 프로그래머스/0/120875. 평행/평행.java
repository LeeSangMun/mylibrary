class Solution {
    public int solution(int[][] dots) {      
        double[] n = new double[2];
		
		for (int i = 0; i < 3; i++) {
			n[0] = (double)(dots[i][1] - dots[3][1])/(dots[i][0] - dots[3][0]);
			n[1] = (double)(dots[(i+2)%3][1] - dots[(i+1)%3][1])/(dots[(i+2)%3][0] - dots[(i+1)%3][0]);
			
			if(n[0] == n[1]) return 1;
		}
		
        return 0;
    }
}