class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
        	sb.append(n % k);
        	n /= k;
        }
        
        String[] temp = sb.reverse().toString().split("0+");
        int answer = temp.length;
        long num = 0;
        
        for (String str : temp) {
        	if(str.equals("1")) answer--;
        	
        	num = Long.parseLong(str);
        	for (long i = 2; i <= (int)Math.sqrt(num); i++) {
				if(num%i == 0) {
					answer--;
					break;
				}
			}
		}
        
        return answer;
    }
}