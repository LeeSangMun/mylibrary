class Solution {
	public int solution(int n, int[] money) {
		int[] temp = new int[n+1];

		for (int i = 0; i < money.length; i++) {
			temp[money[i]]++;
			for (int j = 1; j <= n; j++) {
				if(j - money[i] >= 0) {
					temp[j] += temp[j-money[i]] % 1000000007;
				}
			}
		}
			
		return temp[n];
	}
}