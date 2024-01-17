class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
		boolean flag = false;
		cArr[0] = Character.toUpperCase(cArr[0]);
		
		for (int i=1; i<cArr.length; i++) {
			if(cArr[i] == ' ') {
				flag = true;
				continue;
			} else {
				if(flag) {
					cArr[i] = Character.toUpperCase(cArr[i]);
					flag = !flag;
				} else {
					cArr[i] = Character.toLowerCase(cArr[i]);
				}
			}
		}
		
		return new String(cArr);
    }
}