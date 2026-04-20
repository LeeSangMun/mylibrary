class Solution {
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] cost, int[][] hint) {
        f(cost, hint, new int[cost.length], 0, 0);

        return answer;
    }

    static void f(int[][] cost, int[][] hint, int[] arr, int totalCost, int count) {
        if(count == cost.length) {
            answer = Integer.min(answer, totalCost);
            return;
        }

        int[] tempArr = arr.clone();
        f(cost, hint, tempArr, totalCost + cost[count][Integer.min(tempArr[count], cost.length - 1)], count + 1);

        if(count == cost.length - 1)
            return;

        tempArr = arr.clone();
        for (int i = 1; i < hint[count].length; i++) {
            tempArr[hint[count][i] - 1]++;
        }
        
        f(cost, hint, tempArr, totalCost + cost[count][Integer.min(tempArr[count], cost.length - 1)] + hint[count][0], count + 1);
    }
}