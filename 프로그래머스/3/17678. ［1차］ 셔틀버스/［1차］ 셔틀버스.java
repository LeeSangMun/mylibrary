import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
		int busCnt = 1;
		int time = getSec("09:00");
		int idx = 0;
		
		while(busCnt <= n) {
			int cnt = 0;
			
			while(m > cnt) {
				if(idx >= timetable.length || time < getSec(timetable[idx])) break;
				cnt++;
				idx++;
			}
			if(busCnt == n && cnt == m) return getStringTime(getSec(timetable[idx-1])-1);
			
			busCnt++;
			time += t;
		}
		
		return getStringTime(time - t);
    }
    
    public static int getSec(String timetable) {
		String[] temp = timetable.split(":");
		return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
	}

	public static String getStringTime(int time) {
		LocalTime lt = LocalTime.ofSecondOfDay(time * 60);
		return lt.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
}