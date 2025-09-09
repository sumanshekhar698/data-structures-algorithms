package com.dsa.leetcode.dp;

public interface _M_2327NumberOfPeopleAwareOfASecret {


    public static void main(String[] args) {

        System.out.println(peopleAwareOfSecret(6, 2, 4));

    }


    // this problem is like a chain reaction
    static public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1000000007;
        // dp[i] is number of people who found secret on day i
        int[] dp = new int[n + 1];//for n days
        dp[1] = 1;//starting point, person A knows the secret
        int share = 0;//no of people who can share the secret


        for (int i = 2; i <= n; i++) {//traversing over days
            if (i - delay > 0) {//can share the secret
                share = (share + dp[i - delay]) % MOD;

            }

            if (i - forget > 0) {
                share = (share - dp[i - forget] + MOD) % MOD;
            }

            dp[i] = share;


        }

        int totalSecretKnowers = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            totalSecretKnowers = (totalSecretKnowers + dp[i]) % MOD;
        }

        return totalSecretKnowers;

    }
}
