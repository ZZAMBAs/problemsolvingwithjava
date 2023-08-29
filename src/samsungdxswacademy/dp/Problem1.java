/*
package samsungdxswacademy.dp;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            String s1, s2;
            s1 = sc.next();
            s2 = sc.next();
            sc.nextLine();
            if (s1.length() < s2.length()) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }
            int[][] dp = new int[s2.length() + 1][s1.length() + 1];
            for (int j = 1; j <= s2.length(); j++){
                char cmpC = s2.charAt(j - 1);
                for (int k = 1; k <= s1.length(); k++){
                    if (s1.charAt(k - 1) == cmpC)
                        dp[j][k] = Math.max(dp[j - 1][k - 1] + 1, Math.max(dp[j][k - 1], dp[j - 1][k]));
                    else
                        dp[j][k] = Math.max(dp[j - 1][k - 1], Math.max(dp[j][k - 1], dp[j - 1][k]));
                }
            }

            System.out.println("#" + i + " " + dp[s2.length()][s1.length()]);
        }
    }
}
*/
