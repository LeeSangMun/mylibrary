class Solution {
    public int solution(int[] a) {
        int answer = 1;
        int min = 0;
        int minIdx = 0;
        
        for (int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
				minIdx = i;
			}
		}
        
        int temp = 1000000000;
        
        for (int i = 0; i < minIdx; i++) {
			if(a[i] < temp) {
				temp = a[i];
				answer++;
			}
		}
        
        temp = 1000000000;
        for (int i = a.length - 1; i > minIdx; i--) {
			if(a[i] < temp) {
				temp = a[i];
				answer++;
			}
		}
        
        return answer;
    }
}