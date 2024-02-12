class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i : ingredient) {
			sb.append(i);
		}
		
		for (int i = 0; i < sb.length()-3; i++) {
			if(sb.substring(i, i+4).equals("1231")) {
				sb.delete(i, i+4);
				i = Math.max(-1, i-5);
				answer++;
			}
		}

		return answer;
    }
}