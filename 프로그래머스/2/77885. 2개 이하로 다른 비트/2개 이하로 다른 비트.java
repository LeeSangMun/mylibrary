import java.math.BigInteger;

class Solution {
    public long[] solution(long[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]%2 == 0 || !BigInteger.valueOf(numbers[i]).testBit(1)) {
				numbers[i]++;
            
			} else {
				StringBuilder sb = new StringBuilder(("0" + Long.toBinaryString(numbers[i])));
				int idx = sb.lastIndexOf("0");
				sb.replace(idx, idx+2, "10");
				numbers[i] = Long.valueOf(sb.toString(), 2);
			}
		}
		
		return numbers;
    }
}