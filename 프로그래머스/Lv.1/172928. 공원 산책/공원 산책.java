class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for (int i = 0; i < park.length; i++) {
			if(park[i].contains("S")) {
				answer[0] = i;
				answer[1] = park[i].indexOf("S");
				break;
			}
		}

        String[] str;
        int n = 0;
        
        for (String route : routes) {
        	boolean flag = false;
			str = route.split(" ");
			n = Integer.parseInt(str[1]);
			if(str[0].equals("E")) {
				if(answer[1]+n > park[0].length()-1) continue;
				if(park[answer[0]].substring(answer[1]+1, answer[1]+n+1).indexOf("X") == -1) {
					answer[1] += n;
				}
			} else if(str[0].equals("S")) {
				if(answer[0]+n > park.length-1) continue;
				for (int i = answer[0]+1; i <= answer[0]+n; i++) {
					if(park[i].charAt(answer[1]) == 'X') {
						flag = true;
						break;
					}
				}
				if(!flag) {
					answer[0] += n;
				}
			} else if(str[0].equals("W")) {
				if(answer[1]-n < 0) continue;
				if(park[answer[0]].substring(answer[1]-n, answer[1]).indexOf("X") == -1) {
					answer[1] -= n;
				}
			} else {
				if(answer[0]-n < 0) continue;
				
				for (int i = answer[0]-1; i >= answer[0]-n; i--) {
					if(park[i].charAt(answer[1]) == 'X') {
						flag = true;
						break;
					}
				}
				if(!flag) {
					answer[0] -= n;
				}
			}
		}
        
        return answer;
    }
}