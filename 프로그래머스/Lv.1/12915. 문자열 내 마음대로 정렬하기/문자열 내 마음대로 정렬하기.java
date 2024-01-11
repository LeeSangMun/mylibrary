import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, Comparator.comparing((String s) -> s.charAt(n)).thenComparing(String::compareTo));
        return strings;
    }
}