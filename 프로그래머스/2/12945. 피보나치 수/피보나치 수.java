class Solution {
    public int solution(int n) {
        int term1 = 0, term2 = 1, term3 = 0;
        
        for (int i = 1; i < n; i++) {
        	term3 = (term1 + term2)%1234567;
        	term1 = term2;
        	term2 = term3;
		}
        
        return term3;
    }
}