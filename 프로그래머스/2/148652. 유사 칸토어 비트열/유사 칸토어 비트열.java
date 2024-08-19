class Solution {
    public int solution(int n, long l, long r) {
		return f(n, r) - f(n, l - 1);
	}
	
	static int f(int n, long end) {
		int cnt = 0;
		
		while(n != 0) {
			long k = (long)Math.pow(5, (n-1));
			long m = end / k;
			
			if(m == 2) {
				cnt += (int)Math.pow(4, (n-1)) * m;
				break;
			}
			
			end %= k;
			m = m >= 3 ? m - 1 : m;
			cnt += (int)Math.pow(4, (n-1)) * m;
			
			n--;
		}
		
		return cnt;
	}
}