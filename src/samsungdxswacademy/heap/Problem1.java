/*
package samsungdxswacademy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            System.out.print("#" + i);

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int N = sc.nextInt();
            for (int j = 0; j < N; j++) {
                int cmd = sc.nextInt();

                if (cmd == 1) {
                    int x = sc.nextInt();
                    pq.add(x);
                } else {
                    if (pq.isEmpty())
                        System.out.print(" " + -1);
                    else
                        System.out.print(" " + pq.poll());
                }
            }
            System.out.println();
        }
    }
}
*/
