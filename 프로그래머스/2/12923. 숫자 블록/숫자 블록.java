class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];

		int idx = 0;

		for (long i = begin; i <= end; i++) {
			boolean flag = false;
			int n = 0;
			for (long j = 2; j <= (long) Math.sqrt(i); j++) {
				if (i % j == 0) {
					if(i/j > 10000000) {
						n = (int)j;
						continue;
					}
					answer[idx++] = (int) (i / j);
					flag = !flag;
					break;
				}
			}

			if(!flag && n != 0) {
				answer[idx++] = n;
			} else if(!flag) {
				answer[idx++] = 1;
			}
		}

		if (begin == 1)
			answer[0] = 0;

		return answer;
    }
}