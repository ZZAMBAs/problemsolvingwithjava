package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem28437 {
    static int[] A, res;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[100001];
        res = new int[100001];

        while (N-- > 0)
            A[sc.nextInt()] = 1;
        int Q = sc.nextInt();
        dp = new int[100001];
        Arrays.fill(dp, -1);
        dp[1] = A[1];
        for(int i = 0; i < Q; i++) {
            System.out.print(fdp(sc.nextInt()) + " ");
        }
    }

    static int fdp(int num){
        if(dp[num] >= 0)
            return dp[num];
        dp[num] = A[num];
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) {
                dp[num] += fdp(num / i);
                if(num / i != i)
                    dp[num] += fdp(i);
            }
        }
        dp[num] += fdp(1);
        return dp[num];
    }
}
