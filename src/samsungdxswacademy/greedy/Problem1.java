package samsungdxswacademy.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int res = 0;
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int j = 0; j < N; j++)
                A[j] = sc.nextInt();
            int M = sc.nextInt();
            int[] B = new int[M];
            for (int j = 0; j < M; j++)
                B[j] = sc.nextInt();

            PriorityQueue<Pair> pairs = new PriorityQueue<>(Comparator.reverseOrder());
            for(int j = 0; j < Math.max(N, M); j++) {
                if (j < N)
                    pairs.add(new Pair(A[j], 0));
                if (j < M)
                    pairs.add(new Pair(B[j], 1));
            }
            int cnt = (N + M) / 2 + (N + M) % 2;
            int[] count = new int[100001];
            while (cnt-- > 0){
                Pair cur = pairs.poll();
                if (cur.state == 1) {
                    res += cur.val;
                    M--;
                }
                else
                    count[cur.val]++;
            }
            for (int j = 0; j < N; j++){

            }


        }
    }

    static class Pair implements Comparable<Pair>{
        int val, state;

        public Pair(int val, int state) {
            this.val = val;
            this.state = state;
        }

        @Override
        public int compareTo(Pair o) {
            int compared = Integer.compare(this.val, o.val);
            if (compared == 0)
                return Integer.compare(this.state, o.state);
            return compared;
        }
    }
}
