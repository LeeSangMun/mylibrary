class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
		n -= cores.length;
		long s = 0, e = 10000 * 50000;

		while (s < e) {
			long m = (s + e) / 2;

			if (check(n, cores, m)) {
				e = m;
			} else {
				s = m + 1;
			}
		}

		for (int i = 0; i < cores.length; i++) {
			n -= (s - 1) / cores[i];
		}

		for (int i = 0; i < cores.length; i++) {
			if(s % cores[i] == 0) n--;
			
			if(n == 0) {
				answer = i+1;
				break;
			}
		}

		return answer;
    }
	
	static boolean check(int n, int[] cores, long m) {
		long sum = 0;
		
		for (int i = 0; i < cores.length; i++) {
			sum += m / cores[i];
		}
		
		return sum >= n;
	}
}