import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        switch(n) {
            case 1:
                return Arrays.copyOfRange(num_list, 0, b+1);
            case 2:
                return Arrays.copyOfRange(num_list, a, num_list.length);
            case 3:
                return Arrays.copyOfRange(num_list, a, b+1);
            default:
                int[] answer = new int[(b-a)/c+1];
                int idx = 0;
                for(int i=a; i<=b; i+=c) {
                    answer[idx++] = num_list[i];
                }
                return answer;
        }
    }
}