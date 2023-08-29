/*
package samsungdxswacademy.binarysearch;

// 꽤 난잡하게 풀었다. 정해를 모르겠다.

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt(), M = sc.nextInt(), c1 = sc.nextInt(), c2 = sc.nextInt();
            int res = Integer.MAX_VALUE, cnt = 0;
            int[] cowsZ = new int[N];
            int[] horsesZ = new int[M];
            for (int j = 0; j < N; j++)
                cowsZ[j] = sc.nextInt();
            for (int j = 0; j < M; j++) {
                horsesZ[j] = sc.nextInt();
            }
            Arrays.sort(horsesZ);

            for (int j = 0; j < N; j++){
                int cowZ = cowsZ[j];
                int lIdxUpper = binarySearchUpper(cowZ, horsesZ, 0, horsesZ.length - 1);
                int lIdxLower = binarySearchLower(horsesZ[lIdxUpper], horsesZ);
                int rIdx = binarySearchUpper(cowZ, horsesZ, lIdxUpper + 1, horsesZ.length - 1);
                int lDist = getDist(c1, 0, cowZ, c2, 0, horsesZ[lIdxLower]);
                int rDist = getDist(c1, 0, cowZ, c2, 0, horsesZ[rIdx]);

                if (horsesZ[lIdxLower] >= cowZ)
                    rDist = Integer.MAX_VALUE;

                if (lDist == rDist){
                    if (res > lDist){
                        res = lDist;
                        cnt = rIdx - lIdxLower + 1;
                    } else if (res == lDist) {
                        cnt += rIdx - lIdxLower + 1;
                    }
                } else if (lDist < rDist) {
                    if (res > lDist){
                        res = lDist;
                        cnt = lIdxUpper - lIdxLower + 1;
                    } else if (res == lDist) {
                        cnt += lIdxUpper - lIdxLower + 1;
                    }
                }else{
                    if (res > rDist){
                        res = rDist;
                        cnt = rIdx - lIdxUpper;
                    } else if (res == rDist) {
                        cnt += rIdx - lIdxUpper;
                    }
                }

            }
            System.out.println("#" + i + " " + res + " " + cnt);
        }
    }

    static int getDist(int x1, int y1, int z1, int x2, int y2, int z2){
        return abs(x2 - x1) + abs(y2 - y1) + abs(z2 - z1);
    }

    static int binarySearchUpper(int findNum, int[] arr, int start, int end){
        start = min(start, end);
        int initStart = start;
        while (start <= end){
            int mid = (start + end) / 2;

            if (arr[mid] <= findNum)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return max(end, initStart);
    }

    static int binarySearchLower(int findNum, int[] arr){
        int start = 0, end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;

            if (arr[mid] < findNum)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return max(start, 0);
    }
}
*/
