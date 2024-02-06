class Solution {
    public int solution(String s) {
        int answer = 0;
		char[] cArr = s.toCharArray();
		char temp = s.charAt(0);
		int cnt = 0;

		for (int i = 0; i < cArr.length; i++) { 
			if (cArr[i] != temp) {
				if (--cnt == 0) {
					answer++;
					if(i < cArr.length-1) {						
						temp = cArr[i + 1];
					}
					cnt = 0;
				}
				continue;
			}
			cnt++;
		}

		return answer + (cnt != 0 ? 1 : 0);
    }
}