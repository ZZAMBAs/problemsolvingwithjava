/*
package samsungdxswacademy.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem4 {
    static class Pair{
        long x, y;
        int idx;

        public Pair(long x, long y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    static class WeightAndDest implements Comparable<WeightAndDest> {
        double w;
        int dest;

        public WeightAndDest(double w, int dest) {
            this.w = w;
            this.dest = dest;
        }


        @Override
        public int compareTo(WeightAndDest o) {
            if (this.w > o.w)
                return 1;
            else if (this.w < o.w)
                return -1;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt();
            Pair[] pairs = new Pair[N];
            for (int j = 0; j < N; j++)
                pairs[j] = new Pair(sc.nextInt(), 0, j);
            for (int j = 0; j < N; j++)
                pairs[j].y = sc.nextInt();

            double e = sc.nextDouble();

            long l = prim(pairs, N);
            System.out.println("#" + i + " " + Math.round(e * l));
        }
    }

    private static long prim(Pair[] pairs, Integer N) {
        long ret = 0;
        PriorityQueue<WeightAndDest> pq = new PriorityQueue<>();
        pq.add(new WeightAndDest(0, 0));
        boolean[] visited = new boolean[N];
        while (!pq.isEmpty()){
            WeightAndDest front = pq.poll();
            if (visited[front.dest])
                continue;
            ret += Math.round(front.w * front.w);
            visited[front.dest] = true;
            for (int i = 0; i < N; i++){
                if (!visited[i]){
                    pq.add(new WeightAndDest(Math.sqrt(
                            Math.pow(pairs[i].x - pairs[front.dest].x, 2) + Math.pow(pairs[i].y - pairs[front.dest].y, 2)
                    ), i));
                }
            }

        }
        return ret;
    }
}
*/
