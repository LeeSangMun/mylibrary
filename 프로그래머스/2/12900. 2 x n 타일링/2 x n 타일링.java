class Solution {
    public int solution(int n) {
        int term1 = 1, term2 = 2, term3 = 0;
        
        for (int i = 1; i <= n-2; i++) {
			term3 = (term1 + term2) % 1000000007;
			term1 = term2;
			term2 = term3;
		}
        
        if(n == 1) return 1;
        else if(n == 2) return 2;
        
        return term3;
    }
}