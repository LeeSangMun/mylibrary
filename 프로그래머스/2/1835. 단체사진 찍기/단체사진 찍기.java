class Solution {
    static int answer = 0;
	
	public int solution(int n, String[] data) {
        answer = 0;
        String[] name = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] visited = new boolean[name.length];
        
        f(name, visited, data, "");
        
        return answer;
    }
	
	static void f(String[] name, boolean[] visited, String[] data, String str) {
		if(name.length == str.length()) {
			int i = 0;
			for (i = 0; i < data.length; i++) {
				char ch = data[i].charAt(3);
				int n = Math.abs(str.indexOf(data[i].charAt(0)) - str.indexOf(data[i].charAt(2))) - 1;
				if(ch == '=') {
					if(n != (data[i].charAt(4) - '0')) {
						break;
					}
				} else if(ch == '<') {
					if(n >= (data[i].charAt(4) - '0')) {
						break;
					}
				} else {
					if(n <= (data[i].charAt(4) - '0')) {
						break;
					}
				}
			}
			
			if(i == data.length) {
				answer++;
			}
			
			return;
		}
		
		for (int i = 0; i < name.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				f(name, visited, data, str + name[i]);
				visited[i] = false;
			}
		}
	}
}