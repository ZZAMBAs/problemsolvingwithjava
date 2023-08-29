/*
package samsungdxswacademy.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt();
            long M = sc.nextLong();
            long res = 0;
            Long[] A = new Long[N];
            for (int j = 0; j < N; j++)
                A[j] = sc.nextLong();
            Arrays.sort(A, Comparator.reverseOrder());
            for (int j = 1; j <= N; j++){
                if (j > M)
                    break;

                long start = 1, end = 1000000000000000000L;
                while(start <= end){
                    long mid = (start + end) / 2;
                    long sum = 0;
                    for (int k = 0; k < j; k++)
                        sum += A[k] / mid;

                    if (sum < M)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
                res = Math.max(res, end);
            }
            System.out.println("#" + i + " " + res);
        }
    }
}*/
