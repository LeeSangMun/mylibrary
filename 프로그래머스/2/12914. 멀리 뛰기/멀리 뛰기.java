class Solution {
    public long solution(int n) {
        long answer = 0;
        long term1 = 1, term2 = 2;
        
        if(n == 1) return term1;
        else if(n == 2) return term2;
        
        for (int i = 0; i < n-2; i++) {
			answer = (term1 + term2) % 1234567;
			term1 = term2;
			term2 = answer;
		}
        
        return answer;
    }
}