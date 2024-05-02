class Solution {
    static int answer = 0;
	
	public int solution(String begin, String target, String[] words) {
        boolean[] flag = new boolean[words.length];
        answer = words.length + 1;
        f(begin, target, words, flag, 0);
        
        return answer == words.length+1 ? 0 : answer;
    }
	
	static void f(String begin, String target, String[] words, boolean[] flag, int n) {
		if(begin.equals(target)) {
			answer = Math.min(answer, n);
		}
		
		for (int i = 0; i < words.length; i++) {
			if(!flag[i]) {
				String temp = words[i];
				for (int j = 0; j < begin.length(); j++) {
					temp = temp.replaceFirst(begin.substring(j, j+1), "");
				}
				
				if(temp.length() == 1) {
					flag[i] = true;
					f(words[i], target, words, flag, n+1);
					flag[i] = false;
				}
			}
		}
	}
}