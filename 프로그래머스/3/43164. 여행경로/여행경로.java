class Solution {
    static String answer = "ㅇ";
	
	public String[] solution(String[][] tickets) {
        boolean[] flag = new boolean[tickets.length];
        f("ICN", "ICN", tickets, flag, 0);
        
        return answer.split(",");
    }
	
	static void f(String temp, String next, String[][] tickets, boolean[] flag, int n) {
		if(n == tickets.length) {
			if(answer.compareTo(temp) > 0) {
				answer = temp;
			}
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if(!flag[i] && tickets[i][0].equals(next)) {
				flag[i] = true;
				f(temp + "," + tickets[i][1], tickets[i][1], tickets, flag, n+1);
				flag[i] = false;
			}
		}
	}
}