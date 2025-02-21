class Solution {
    public int solution(int n, int w, int num) {
        if(w == 1)
			return n - num + 1;
        
        int answer = ((n - 1) / w + 1) % 2 == 0 ? Math.abs((n - 1) % w - (w - 1)) : (n - 1) % w;
        int temp = ((num - 1) / w + 1) % 2 == 0 ? Math.abs((num - 1) % w - (w - 1)) : (num - 1) % w;

        return n / w - (num - 1) / w + ((n / w + 1) % 2 == 0 ? (answer > temp ? 0 : 1) : (answer >= temp ? 1 : 0));
    }
}