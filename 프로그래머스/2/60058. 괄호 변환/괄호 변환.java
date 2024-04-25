import java.util.*;

class Solution {
    public String solution(String p) {
        return f(p);
    }
	
	static String f(String p) {
		if(p.isEmpty())
			return "";
		
		String temp = "";
		int n = 0;
		int i = 1;
		
		if(p.charAt(0) == '(') {
			n++;
		} else {
			n--;
		}
		
		for (i = 1; i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				n++;
			} else {
				n--;
			}
			
			if(n == 0) {
				break;
			}
		}
		
		String v = i == p.length() ? "" : p.substring(i+1);
		
		if(p.charAt(0) == ')') {
			for (int j = 1; j < i; j++) {
				if(p.charAt(j) == '(') {
					temp += ')';
				} else {
					temp += '(';
				}
			}
			return "(" + f(v) + ")" + temp;
		} else {
			return p.substring(0, i+1) + f(v);
		}
	}
}