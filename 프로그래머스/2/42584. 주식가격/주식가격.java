class Solution {
    public int[] solution(int[] prices) {
        for (int i = 0; i < prices.length-1; i++) {
        	boolean flag = false;
			for (int j = i+1; j < prices.length; j++) {
				if(prices[i] > prices[j]) {
					prices[i] = j-i;
					flag = true;
					break;
				}
			}
			if(!flag) {
				prices[i] = prices.length - i - 1;
			}
		}
        
        prices[prices.length-1] = 0;
        
        return prices;
    }
}