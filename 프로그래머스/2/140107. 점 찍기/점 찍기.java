import java.math.BigInteger;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        BigInteger bi = BigInteger.valueOf(d).multiply(BigInteger.valueOf(d));
        
        for (long i = 0; i <= d; i+=k) {
        	answer += bi.subtract(BigInteger.valueOf(i*i)).sqrt().divide(BigInteger.valueOf(k)).intValue()+1;
		}
        
        return answer;
    }
}