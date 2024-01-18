class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int n = s.length();
        
        while(!s.equals("1")) {
        	s = s.replace("0", "");
        	answer[1] += n - s.length();
        	answer[0]++;
        	s = Integer.toBinaryString(s.length());
        	n = s.length();
        }
        
        return answer;
    }
}