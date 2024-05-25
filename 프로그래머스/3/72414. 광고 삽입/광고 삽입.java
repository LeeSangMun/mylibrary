class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int[] temp =  new int[getMin(play_time)+2];

        for (int i = 0; i < logs.length; i++) {
        	String[] times = logs[i].split("-");
			temp[getMin(times[0])]++;
			temp[getMin(times[1])]--;
		}
        
        for (int i = 0; i < temp.length-1; i++) {
			temp[i+1] += temp[i];
		}        
        
        int advTime = getMin(adv_time);
        long sum = 0;
        int idx = 0;
        
        for (int i = 0; i < advTime; i++) {
			sum += temp[i];
		}
        
        long max = sum;
        for (int i = advTime; i < temp.length; i++) {
			sum += temp[i] - temp[i-advTime];
			
			if(max < sum) {
				max = sum;
				idx = i - advTime + 1;
			}
		}
        
        return format(idx);
    }
	
	static String format(int time) {
		int hour = time/60/60;
		time -= hour*60*60;
		int min = time/60;
		time -= min*60;
		int sec = time;
		
		return String.format("%02d:%02d:%02d", hour, min, sec);
	}
	
	static int getMin(String time) {
		String[] temp = time.split(":");
		
		return Integer.parseInt(temp[0])*60*60 + Integer.parseInt(temp[1])*60 + Integer.parseInt(temp[2]);
	}
}