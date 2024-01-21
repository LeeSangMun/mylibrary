class Solution {
    public int solution(int n) {
        int answer = 1;
        int a;
        int sum = 0;
        
        for (int i = 1; i <= n/2; i++) {
			a = i;
			sum = 0;
			while(sum <= n) {
				sum += a++; 
				if(sum == n) {
					answer++;
					break;
				}
			}
		}
        
        return answer;
    }
}