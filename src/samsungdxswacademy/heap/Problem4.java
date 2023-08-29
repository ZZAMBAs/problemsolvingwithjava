/*
package samsungdxswacademy.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem4 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            res = 210000000;
            int N = sc.nextInt();
            long[] A = new long[N];
            for (int j = 0; j < N; j++)
                A[j] = sc.nextInt();
            long K = sc.nextInt();
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(K, 0));
            while (pq.peek().nowK != 0){
                Pair polled = pq.poll();
                for (long a : A){
                    pq.add(new Pair(polled.nowK / a, polled.res + polled.nowK % a));
                }
            }

            System.out.println("#" + i + " " + pq.poll().res);
        }
    }

    private static class Pair implements Comparable<Pair>{
        long nowK, res;

        public Pair(long nowK, long res) {
            this.nowK = nowK;
            this.res = res;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.res, o.res);
        }
    }
}
*/
