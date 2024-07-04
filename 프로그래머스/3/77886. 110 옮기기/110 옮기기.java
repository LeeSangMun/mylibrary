class Solution {
    static final String str = "110";
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]);
			int idx = 0;
			int cnt = 0;

			while ((idx = sb.indexOf("110", Math.max(0, idx - 2))) != -1) {
				sb.delete(idx, idx + "110".length());
				cnt++;
			}

			if((idx = sb.indexOf("11")) != -1) {
				for (int j = 0; j < cnt; j++) {
					sb.insert(idx, str);
				}
			} else if ((idx = sb.lastIndexOf("0")) != -1) {
				for (int j = 0; j < cnt; j++) {
					sb.insert(idx + 1, str);
				}
			} else {
				for (int j = 0; j < cnt; j++) {
					sb.insert(0, str);
				}
			}

			answer[i] = sb.toString();
			sb.setLength(0);
		}

		return answer;
    }
}