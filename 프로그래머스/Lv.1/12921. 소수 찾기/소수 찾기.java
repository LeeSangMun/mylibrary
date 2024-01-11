class Solution {
    public int solution(int n) {
        int answer = 1;
        
        outer:for (int i = 3; i <= n; i+=2) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j==0) continue outer;
			}
			answer++;
		}
        
        return answer;
    }
}