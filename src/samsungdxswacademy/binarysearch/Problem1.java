/*
package samsungdxswacademy.binarysearch;

// 아래 풀이는 투 포인터지만 이분 탐색으로도 가능하다.

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int n = sc.nextInt(), p = sc.nextInt();
            int res = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            int s = 0, e = 0, temp = p;
            while (e < n - 1){
                int diff = arr[e + 1] - arr[e] - 1;
                if (diff <= temp){
                    temp -= diff;
                    e++;
                }
                else{
                    res = Math.max(res, e - s + 1 + p);
                    if (s < e)
                        temp += arr[s + 1] - arr[s] - 1;
                    s++;
                    if (s > e)
                        e = s;
                }
            }
            res = Math.max(res, e - s + 1 + p);
            System.out.println("#" + i + " " + res);
        }
    }
}
*/
