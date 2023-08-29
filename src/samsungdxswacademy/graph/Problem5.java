/*
package samsungdxswacademy.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem5 {
    static class Pair{
        int idx, cost;

        public Pair(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static class WeightAndDest implements Comparable<WeightAndDest> {
        int w;
        int dest;

        public WeightAndDest(int w, int dest) {
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
            int M = sc.nextInt();
            ArrayList<ArrayList<Pair>> pairs = new ArrayList<>(N + 1);
            for (int j = 0; j < N + 1; j++)
                pairs.add(new ArrayList<>());

            for (int j = 0; j < M; j++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                int c = sc.nextInt();
                pairs.get(s).add(new Pair(e, c));
                pairs.get(e).add(new Pair(s, c));
            }

            long l = prim(pairs, N);
            System.out.println("#" + i + " " + l);
        }
    }

    private static long prim(ArrayList<ArrayList<Pair>> pairs, Integer N) {
        long ret = 0;
        PriorityQueue<WeightAndDest> pq = new PriorityQueue<>();
        pq.add(new WeightAndDest(0, 1));
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()){
            WeightAndDest front = pq.poll();
            int curNode = front.dest;
            if (visited[curNode])
                continue;
            ret += front.w;
            visited[curNode] = true;
            for (Pair adv : pairs.get(curNode)){
                if (!visited[adv.idx])
                    pq.add(new WeightAndDest(adv.cost, adv.idx));
            }

        }
        return ret;
    }
}
*/
