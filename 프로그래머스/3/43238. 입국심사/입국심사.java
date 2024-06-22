class Solution {
    public long solution(int n, int[] times) {
        long s = 0;
        long e = 1000000000 * (long)100000;
        
        while(s < e) {
        	long m = (s + e) / 2;
        	
        	if(check(times, n, m)) {
        		e = m;
        	} else {
        		s = m + 1;
        	}
        }
        
        return s;
    }
	
	static boolean check(int[] times, int n, long m) {
		long sum = 0;
		
		for (int i = 0; i < times.length; i++) {
			sum += m / times[i];
		}
		
		return sum >= n ? true : false;
	}
}