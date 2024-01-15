class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = { wallpaper.length - 1, wallpaper[0].length() - 1, 0, 0 };
		int y = 0;
		
		for (int i = 0; i < wallpaper.length; i++) {
			if((y = wallpaper[i].indexOf("#")) != -1) {
				if(answer[0] > i) answer[0] = i;
				if(answer[1] > y) answer[1] = y;
			}
			
			if((y = wallpaper[i].lastIndexOf("#")) != -1) {
				if(answer[2] < i+1) answer[2] = i+1;
				if(answer[3] < y+1) answer[3] = y+1;
			}
		}

		return answer;
    }
}