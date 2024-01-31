class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
		boolean flag = false;
		
        for (int i = 0; i < queries.length; i++) {
        	answer[i] = 1000000;
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				if(queries[i][2] < arr[j] && answer[i] > arr[j]) {
					answer[i] = arr[j];
					flag = true;
				}
			}
			
			if(!flag) {
				answer[i] = -1;
			} else {
				flag = !flag;
			}
		}

		return answer;
    }
}