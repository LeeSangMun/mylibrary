class Solution {
    public long solution(int w, int h) {
        int n = 1;
		long num = (long)w * h;

		if (w == h) return (long)w * w - w;
		
		boolean flag = true;
		
		while(flag) {
			flag = false;
			for (int i = 2; i <= Math.min(w, h); i++) {
				if(w % i == 0 && h % i == 0) {
					w /= i;
					h /= i;
					flag = true;
					n *= i;
					break;
				}
			}
		}
		
		return num - (w + h - 1) * n;
    }
}