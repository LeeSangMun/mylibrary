import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        BigInteger bi = new BigInteger("1");
		
        for(int i=share+1; i<=balls; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        
        for(int i=2; i<=balls-share; i++) {
        	bi = bi.divide(BigInteger.valueOf(i));
        }
        
        return bi.intValue();
    }
}