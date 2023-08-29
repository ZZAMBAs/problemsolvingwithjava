/*
package samsungdxswacademy.binarysearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("C:/Users/rksid/OneDrive/바탕 화면/sample_input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int L = sc.nextInt(), N = sc.nextInt();
            int res = 0;
            int[][] arr = new int[N][2];
            int[] prefixSum = new int[N + 1];
            for (int j = 0; j < N; j++){
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
                prefixSum[j + 1] = prefixSum[j] + arr[j][1] - arr[j][0];
            }
            int startIdx, endIdx;

            for (startIdx = 0; startIdx < N; startIdx++){
                int start = arr[startIdx][0], end = start + L;
                endIdx = binarySearch(end, arr);
                int temp = Math.min(end, arr[endIdx][1]) - arr[endIdx][0];
                temp += prefixSum[endIdx] - prefixSum[startIdx];
                res = Math.max(res, temp);
            }
            System.out.println("#" + i + " " + res);
        }
    }

    static int binarySearch(int findNum, int[][] arr){
        int s = 0, e = arr.length - 1;
        while (s <= e){
            int mid = (s + e) / 2;
            if (arr[mid][0] <= findNum)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return e;
    }
}
*/
