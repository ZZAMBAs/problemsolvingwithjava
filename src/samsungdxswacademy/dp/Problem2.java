/*
package samsungdxswacademy.dp;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt(), K = sc.nextInt();
            int[][] dp = new int[N + 1][K + 1];
            int[][] things = new int[N + 1][2]; // [][0]: 부피, [][1]: 가치
            for (int j = 1; j <= N; j++){
                things[j][0] = sc.nextInt();
                things[j][1] = sc.nextInt();
            }
            for (int j = 1; j <= N; j++){
                int curV = things[j][0];
                int curW = things[j][1];
                for (int k = 1; k <= K; k++){
                    if (k < curV)
                        dp[j][k] = Math.max(dp[j - 1][k], dp[j][k - 1]);
                    else
                        dp[j][k] = Math.max(dp[j - 1][k - curV] + curW, dp[j - 1][k]);
                }
            }
            System.out.println("#" + i + " " + dp[N][K]);
        }
    }
}
*/
