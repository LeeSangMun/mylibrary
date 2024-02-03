class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(t*m > sb.length()) {
        	sb.append(Integer.toString(i++, n).toUpperCase());
        }
        
        for (int j = p-1; j < t*m; j+=m) {
			answer += sb.charAt(j);
		}
        return answer;
    }
}