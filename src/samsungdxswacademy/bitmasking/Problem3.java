/*
package samsungdxswacademy.bitmasking;

import java.util.Scanner;
// 어려움. 비트마스킹 + DP
public class Problem3 {
    public static void main(String[] args) {
        int T;
        String s;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= T; i++){
            s = sc.nextLine();
            int cnt = 0;
            int[][] dp = new int[16][s.length() + 1];
            dp[0b0001][0] = 1;
            for(int j = 1; j <= s.length(); j++){
                int curPersonBit = s.charAt(j - 1) - 65;
                for (int k = 0; k < 16; k++){
                    for (int l = 0; l < 16; l++){
                        if ((k & l) == 0 || (k & 1 << curPersonBit) == 0)
                            continue;
                        dp[k][j] += dp[l][j - 1];
                        dp[k][j] %= 1000000007;
                    }
                }
            }
            for (int j = 0; j < 16; j++)
                cnt = (cnt + dp[j][s.length()]) % 1000000007;
            System.out.println("#" + i + " " + cnt);
        }
    }
}
*/