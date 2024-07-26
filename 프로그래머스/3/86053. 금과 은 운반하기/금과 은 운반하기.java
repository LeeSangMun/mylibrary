class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long start = 0, end = 400000000000000L;
        
        while(start < end) {
        	long m = (start + end) / 2;
        	
        	if(f(a, b, g, s, w, t, m)) end = m;
        	else start = m + 1;
        }
        
        return end;
    }
	
	static boolean f(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
		long total = 0, gTotal = 0, sTotal = 0;
		
		for (int i = 0; i < t.length; i++) {
			long n = (time + t[i]) / (t[i]*2);			
			long sum = Math.min(n * w[i], g[i] + s[i]);
			total += sum;
			gTotal += Math.min(sum, g[i]);
			sTotal += Math.min(sum, s[i]);
		}
		
		if(total >= a + b && gTotal >= a && sTotal >= b) return true;
		
		return false;
	}
}