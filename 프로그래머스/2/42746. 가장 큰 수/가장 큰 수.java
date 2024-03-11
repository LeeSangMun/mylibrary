import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static String solution(int[] numbers) {
		String answer = Arrays.stream(numbers).boxed().map(String::valueOf).sorted(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String t1 = (s1 + s1.substring(0, 1).repeat(3)).substring(0, 4);
				String t2 = (s2 + s2.substring(0, 1).repeat(3)).substring(0, 4);
				if(t1.equals(t2)) {
					return (s2+s1).compareTo(s1+s2);
				}
				return t2.compareTo(t1);
			}
		}).collect(Collectors.joining());
		
		if(answer.replace("0", "").isEmpty())
			return "0";
		
		return answer;
	}
}