/*
package samsungdxswacademy.divideandconquer;

// 미친 문제

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            long nayeon = sc.nextInt(), dahyeon = sc.nextInt(), K = sc.nextInt();
            long mod = nayeon + dahyeon;
            long mul = divideAndConquer(K, mod);
            System.out.println("#" + i + " " + Math.min(nayeon * mul % mod, dahyeon * mul % mod));
        }
    }

    static long divideAndConquer(long cnt, long mod){
        if (cnt == 0)
            return 1L;

        long ret = divideAndConquer(cnt / 2L, mod);
        if (cnt % 2L == 1)
            return ret * ret * 2 % mod;
        else
            return ret * ret % mod;
    }
}*/
