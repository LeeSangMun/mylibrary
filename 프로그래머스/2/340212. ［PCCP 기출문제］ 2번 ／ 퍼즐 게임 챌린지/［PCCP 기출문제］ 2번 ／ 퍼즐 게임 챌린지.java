class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long s = 1,e = 1000000000000000L;
        
        while(s < e) {
        	long m = (s + e) / 2;
        	
        	if(check(m, diffs, times, limit)) {
        		e = m;
        	} else {
        		s = m + 1;
        	}
        }
        
        return (int)s;
    }
	
	static boolean check(long n, int[] diffs, int[] times, long limit) {
		long sum = times[0];
		
		for (int i = 1; i < diffs.length; i++) {
			if(diffs[i] > n) {
				sum += (diffs[i] - n) * (times[i] + times[i-1]) + times[i];
			} else {
				sum += times[i];
			}
			
			if(sum > limit) return false;
		}
		
		return true;
	}
}