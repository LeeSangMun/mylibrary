class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
		int size = w * 2 + 1;
		answer += 1 >= stations[0] - w ? 0 : (stations[0] - w - 1 - 1) / size + 1;

		for (int i = 1; i < stations.length; i++) {
			if (stations[i] - w > stations[i-1] + w + 1)
				answer += (stations[i] - w - (stations[i-1] + w) - 1 - 1) / size + 1;
		}

		if (n > stations[stations.length-1] + w)
			answer += (n - (stations[stations.length-1] + w) - 1) / size + 1;
		
		return answer;
    }
}