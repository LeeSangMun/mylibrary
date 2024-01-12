class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
		int l = 10, r = 11;
		int lLen, rLen;
		int[][] p = {
				{3, 1}, {0, 0}, {0, 1}
				, {0, 2} , {1, 0}, {1, 1}
				, {1, 2} , {2, 0}, {2, 1}
				, {2, 2} , {3, 0}, {3, 2}
		};
		String h = String.valueOf(Character.toUpperCase(hand.charAt(0)));
		
		for (int num : numbers) {
			if(num == 1 || num == 4 || num == 7) {
				l = num;
				sb.append("L");
			} else if(num == 3 || num == 6 || num == 9) {
				r = num;
				sb.append("R");
			} else {
				lLen = Math.abs(p[num][0]-p[l][0]) + Math.abs(p[num][1]-p[l][1]);
				rLen = Math.abs(p[num][0]-p[r][0]) + Math.abs(p[num][1]-p[r][1]);
				
				if(lLen > rLen) {
					r = num;
					sb.append("R");
				} else if(lLen < rLen) {
					l = num;
					sb.append("L");
				} else if(h.equals("L")) {
					l = num;
					sb.append(h);
				} else if(h.equals("R")) {
					r = num;
					sb.append(h);
				}
			}
		}
		
		return sb.toString();
    }
}