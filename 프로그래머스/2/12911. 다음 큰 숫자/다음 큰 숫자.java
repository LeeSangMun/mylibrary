class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n).replace("0", "");

		while (true) {
			if (s.equals(Integer.toBinaryString(++n).replace("0", ""))) {
				break;
			}
		}

		return n;
    }
}