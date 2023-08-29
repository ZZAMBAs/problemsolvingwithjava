/*
package samsungdxswacademy.tree;

import java.util.Scanner;

public class Problem1 {
    static String res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++){
            res = "";
            int N;
            String c;
            N = sc.nextInt();
            String[] arr = new String[N + 1];
            for (int j = 0; j < N; j++){
                int idx = sc.nextInt();
                c = sc.next();
                arr[idx] = c;
                if (idx * 2 <= N) {
                    sc.nextLine();
                }
            }
            inOrder(arr, 1);
            System.out.println("#" + i + " " + res);
        }

    }

    static void inOrder(String[] arr, int idx){
        if (idx * 2 < arr.length)
            inOrder(arr, idx * 2);
        res += arr[idx];
        if (idx * 2 + 1 < arr.length)
            inOrder(arr, idx * 2 + 1);
    }
}
*/
