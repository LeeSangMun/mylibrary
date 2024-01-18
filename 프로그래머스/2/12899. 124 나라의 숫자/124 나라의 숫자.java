class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] str = {"1", "2", "4"};
        sb.append(str[(n-1)%3]);
        
        while((n = (n-1)/3) != 0) {
        	sb.append(str[(n-1)%3]);
        }
        
        return sb.reverse().toString();
    }
}