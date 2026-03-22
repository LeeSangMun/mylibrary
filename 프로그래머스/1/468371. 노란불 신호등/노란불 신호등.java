class Solution {
    public int solution(int[][] signals) {
        int[][] temp = new int[signals.length][signals[0].length];

        for (int i = 0; i < temp.length; i++) {
            temp[i][0] = signals[i][0] + 1;
            temp[i][1] = signals[i][0] + signals[i][1];
            temp[i][2] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        int t = 0;
        boolean flag = true;

        while(++t <= 10000000) {
            for (int i = 0; i < temp.length; i++) {

                if((t-1) % temp[i][2] < temp[i][0] - 1 || (t-1) % temp[i][2] > temp[i][1] - 1) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                return t;

            flag = true;
        }

        return -1;
    }
}