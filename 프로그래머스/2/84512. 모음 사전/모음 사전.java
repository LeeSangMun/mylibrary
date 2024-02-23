class Solution {
    static int answer = 0;
	static int cnt = 0;
	static String str = "AEIOU";

	public static int solution(String word) {
		f("", word);
		return answer;
	}

	static void f(String temp, String word) {
		if (temp.equals(word))
			answer = cnt;
		if (str.length() == temp.length())
			return;

		for (int i = 0; i < str.length(); i++) {
			cnt++;
			f(temp + str.charAt(i), word);
		}
	}
}