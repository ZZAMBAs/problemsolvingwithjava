/*
package samsungdxswacademy.hash;

import java.util.HashSet;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            HashSet<String> set = new HashSet<>();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int res = 0;
            for (int j = 0; j < N; j++)
                set.add(sc.next());
            for (int j = 0; j < M; j++){
                if (set.contains(sc.next()))
                    res++;
            }
            System.out.println("#" + i + " " + res);
        }
    }
}
*/
