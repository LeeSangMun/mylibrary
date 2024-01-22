class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
			for (int j = Math.max(answer, arr[i]); j <= answer*arr[i]; j++) {
				if(j%answer == 0 && j%arr[i] == 0) {
					answer = j;
					break;
				}
			}
		}
        
        return answer;
    }
}