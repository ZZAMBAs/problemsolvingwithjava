/*
package samsungdxswacademy.segmenttree;

import java.util.Scanner;

public class Problem2 {
    static long swit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            System.out.print("#" + i);
            int n = sc.nextInt(), q = sc.nextInt();
            int size = 1;
            int pow2 = 1;
            int height = 1;
            for (int j = 0; j < 19; j++){
                if (n <= pow2){
                    size = pow2 * 2;
                    break;
                }
                pow2 *= 2;
                height += 1;
            }
            long[] a = new long[size];
            for (int j = 0; j < n; j++)
                a[size / 2 + j] = sc.nextInt();
            construct(a, size, height);
            for (int j = 0; j < q; j++){
                int cmd = sc.nextInt();
                int p1 = sc.nextInt(), p2 = sc.nextInt();
                if (cmd == 1){
                    swit = 0;
                    System.out.print(" " + printing(a, 1, p1, p2 - 1, 0, size / 2 - 1, 1));
                }
                else{
                    update(a, p1, p2, size);
                }
            }
            System.out.println();
        }
    }

    public static void construct(long[] a, int size, int height){
        int sw = 0;
        for (int depth = height - 1; depth > 0; depth--){
            size /= 2;
            for (int idx = size / 2; idx < size; idx++){
                if (sw == 0)
                    a[idx] = a[idx * 2] - a[idx * 2 + 1];
                else
                    a[idx] = a[idx * 2] + a[idx * 2 + 1];
            }
            sw++;
        }
    }

    public static void update(long[] a, int i, int x, int maxSize){
        int idx = maxSize / 2 + i, sw = 0;
        a[idx] = x;
        while (idx > 0){
            int par = idx / 2;
            if (sw == 0)
                a[par] = a[par * 2] - a[par * 2 + 1];
            else
                a[par] = a[par * 2] + a[par * 2 + 1];
            idx /= 2;
            sw++;
        }
    }

    public static long printing(long[] a, int idx, int left, int right, int nodeL, int nodeR, int height){ // left, right: 실제 측정하려는 범위, nodeL, nodeR: 현재 탐색 중 범위
        if (nodeR < left || nodeL > right) return 0;
        if (left <= nodeL && nodeR <= right){
            long ret = a[idx];
            if (swit % 2 == 1) ret *= -1;
            swit += nodeR - nodeL + 1;
            return ret;
        }

        int mid = (nodeL + nodeR) / 2;
        return printing(a, idx * 2, left, right, nodeL, mid, height + 1) + printing(a, idx * 2 + 1, left, right, mid + 1, nodeR, height + 1);
    }
}
*/
