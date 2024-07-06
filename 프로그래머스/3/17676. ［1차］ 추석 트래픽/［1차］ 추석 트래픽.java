class Solution {
    public static int solution(String[] lines) {
		int answer = 1;
		final int TIME_MAX = 24*60*60*1000;
		int[][] temp = new int[lines.length][2];
		
		for (int i = 0; i < lines.length; i++) {
			String[] times = lines[i].split(" ");
			int t = getSec(times[1]);
			int s = (int)(Double.parseDouble(times[2].substring(0, times[2].length()-1)) * 1000);
			
			temp[i][1] = t;
			temp[i][0] = t - s + 1;
		}
		
		for (int i = 0; i < temp.length; i++) {
			int n = 1;
			for (int j = i+1; j < temp.length; j++) {
				if(temp[i][1] + 999 >= temp[j][0]) n++;
			}
			
			answer = Math.max(answer, n);
		}
		
		return answer;
	}
	
	static int getSec(String time) {
		String[] times = time.split("\\.");
		int t = Integer.parseInt(times[1]);
		times = times[0].split(":");
		t += Integer.parseInt(times[0])*3600*1000
				+ Integer.parseInt(times[1])*60*1000
				+ Integer.parseInt(times[2])*1000;
		
		return t;
	}
	
}