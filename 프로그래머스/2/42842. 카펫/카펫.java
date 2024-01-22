class Solution {
    public int[] solution(int brown, int yellow) {
        int hap = brown + yellow;
		int i = 1, x, y;
		while(true) {
			x = brown/2 - i;
			y = hap / x;
			if(hap%x == 0 && x*2+(y-2)*2 == brown) break;
			i++;
		}
		
		return new int[] {x, y};
    }
}