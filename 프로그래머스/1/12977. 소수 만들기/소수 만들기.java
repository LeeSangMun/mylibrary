class Solution {
    public int solution(int[] nums) {
        int answer = 0;
		int n = 0;
		boolean flag = false;

		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i+1; j < nums.length-1; j++) {
				for (int k = j+1; k < nums.length; k++) {
					n = nums[i] + nums[j] + nums[k];
					if(n%2 == 1) {						
						for (int l = 2; l <= n/2; l++) {
							if(n%l == 0) {
								flag = true;
								break;
							}
						}
						if(!flag) {
							answer++;
						} else {
							flag = !flag;
						}
					}
				}
			}
		}

		return answer;
    }
}