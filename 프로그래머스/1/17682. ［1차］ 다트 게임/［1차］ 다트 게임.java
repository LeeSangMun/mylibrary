class Solution {
    public int solution(String dartResult) {
        int answer = 0;
		int temp1 = 0, temp2 = 0;
		String num = "";

		for (char ch : dartResult.toCharArray()) {
			if (Character.isDigit(ch)) {
				if (temp2 != 0) {
					answer += temp1;
					temp1 = temp2;
					temp2 = 0;
					num = "";
				}
				num += ch;
			} else if (ch == 'S') {
				temp2 += Integer.parseInt(num);
			} else if (ch == 'D') {
				temp2 += Math.pow(Integer.parseInt(num), 2);
			} else if (ch == 'T') {
				temp2 += Math.pow(Integer.parseInt(num), 3);
			} else if (ch == '*') {
				temp1 *= 2;
				temp2 *= 2;
			} else if (ch == '#') {
				temp2 *= -1;
			}
		}

		return answer + temp2 + temp1;
    }
}