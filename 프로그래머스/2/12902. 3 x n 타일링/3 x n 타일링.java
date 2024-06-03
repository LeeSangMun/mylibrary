class Solution {
    public int solution(int n) {
        long[] temp = new long[n+1];
        temp[2] = 3;
        temp[4] = 11;
        
        for (int i = 6; i <= n; i+=2) {
			temp[i] = (temp[i-2]*4 - temp[i-4] + 1000000007)%1000000007;
		}
        
        return (int)temp[n];
    }
}