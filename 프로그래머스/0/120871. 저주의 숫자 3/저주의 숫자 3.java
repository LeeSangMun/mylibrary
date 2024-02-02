class Solution {
    public int solution(int n) {
        for (int i = 3; i <= n; i++) {
			if(i%3 == 0 || String.valueOf(i).contains("3")) {
				n++;
			}
		}
        
        return n;
    }
}