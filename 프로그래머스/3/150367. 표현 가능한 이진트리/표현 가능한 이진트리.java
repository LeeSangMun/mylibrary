import java.util.*;

class Solution {
    static int[] answer;
    
	public int[] solution(long[] numbers) {
		answer = new int[numbers.length];
		Arrays.fill(answer, 1);

		for (int i = 0; i < numbers.length; i++) {
			isBinary(toBinaryString(numbers[i]), i);
		}

		return answer;
	}

	static String toBinaryString(long number) {
		String s = Long.toBinaryString(number);
		int n = 1;

		while(true) {
			int len = (int)Math.pow(2, n++) - 1;
			if (len >= s.length()) {
				s = "0".repeat(len - s.length()) + s;
				break;
			}
		}
		
		return s;
	}

	static void isBinary(String number, int i) {
		if(number.length() == 1) return;
		
		int n = number.length() / 2;
		if(number.charAt(n) == '0') {
			isZero(number.substring(0, n), i);
			isZero(number.substring(n+1), i);
		} else {
			isBinary(number.substring(0, n), i);
			isBinary(number.substring(n+1), i);
		}
	}
	
	static void isZero(String number, int i) {
		if(number.length() == 0) return;
		
		int n = number.length() / 2;
		if(number.charAt(n) == '1') {
			answer[i] = 0;
			return;
		}
		
		isZero(number.substring(0, n), i);
		isZero(number.substring(n+1), i);
	}
}