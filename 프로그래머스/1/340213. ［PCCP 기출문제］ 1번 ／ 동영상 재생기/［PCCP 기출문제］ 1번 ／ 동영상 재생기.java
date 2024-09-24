class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        if(pos.compareTo(op_start) >= 0 && pos.compareTo(op_end) <= 0) {
        	pos = op_end;
        }
        
        int t = f(pos);
        int e = f(video_len);
        int os = f(op_start), oe = f(op_end);
        
        for (int i = 0; i < commands.length; i++) {
			if(commands[i].equals("prev")) {
				t -= 10;
				t = t < 0 ? 0 : t;
				
			} else {
				t += 10;
				t = t > e ? e : t;
			}
			if(t >= os && t <= oe) {
				t = oe;
			}
		}
        
        return String.format("%02d:%02d", t / 60, t % 60);
    }
	
	static int f(String time) {
		String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
	}
}