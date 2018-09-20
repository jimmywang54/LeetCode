class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount]);
    }
    
    private int coinChange(int[] coins, int rem, int[] count) {
        if(rem < 0) return -1;
        if(rem == 0) return 0;
        if(count[rem-1] != 0) return count[rem-1];
        int min = Integer.MAX_VALUE;
        for(int c : coins) {
            int res = coinChange(coins, rem-c, count);   
            if(res >= 0 && res < min) {
                min = 1 + res;   
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
