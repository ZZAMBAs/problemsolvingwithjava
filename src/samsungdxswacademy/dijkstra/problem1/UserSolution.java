/*
package samsungdxswacademy.dijkstra.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class UserSolution {
    ArrayList<Pair>[] adj, adjReverse;
    HashMap<Integer, Integer> hashToIdx;
    int size;

    static class Pair implements Comparable<Pair>{
        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }

        int dest, weight;

        public Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public int init(int N, int sCity[], int eCity[], int mCost[]) {
        this.size = 0;
        this.hashToIdx = new HashMap<>();
        this.adj = new ArrayList[600];
        this.adjReverse = new ArrayList[600];
        for (int i = 0; i < N; i++){
            int start = sCity[i];
            int end = eCity[i];
            int cost = mCost[i];

            if (!hashToIdx.containsKey(start)) {
                hashToIdx.put(start, size++);
                adj[hashToIdx.get(start)] = new ArrayList<>();
                adjReverse[hashToIdx.get(start)] = new ArrayList<>();
            }
            if (!hashToIdx.containsKey(end)) {
                hashToIdx.put(end, size++);
                adj[hashToIdx.get(end)] = new ArrayList<>();
                adjReverse[hashToIdx.get(end)] = new ArrayList<>();
            }

            adj[hashToIdx.get(start)].add(new Pair(hashToIdx.get(end), cost));
            adjReverse[hashToIdx.get(end)].add(new Pair(hashToIdx.get(start), cost));
        }

        return size;
    }

    public void add(int sCity, int eCity, int mCost) {
        Integer start = hashToIdx.get(sCity);
        Integer dest = hashToIdx.get(eCity);
        adj[start].add(new Pair(dest, mCost));
        adjReverse[dest].add(new Pair(start, mCost));
    }

    public int cost(int mHub) {
        int[] cost = new int[600];
        for (int i = 0; i < this.size; i++)
            cost[i] = Integer.MAX_VALUE;

        int ret = 0;
        int idx = hashToIdx.get(mHub);
        calDist(idx, cost, 0);
        for (int i = 0; i < this.size; i++)
            ret += cost[i];
        for (int i = 0; i < this.size; i++)
            cost[i] = Integer.MAX_VALUE;
        calDist(idx, cost, 1);
        for (int i = 0; i < this.size; i++)
            ret += cost[i];

        return ret;
    }

    public void calDist(int startIdx, int[] cost, int isReverse){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(startIdx, 0));
        while (!pq.isEmpty()){
            Pair front = pq.poll();

            cost[front.dest] = Math.min(cost[front.dest], front.weight);

            ArrayList<Pair> adj;
            if (isReverse == 0)
                adj = this.adj[front.dest];
            else
                adj = this.adjReverse[front.dest];

            for (Pair adv : adj){
                int sumCost = front.weight + adv.weight;
                if (sumCost < cost[adv.dest]) {
                    cost[adv.dest] = sumCost;
                    pq.add(new Pair(adv.dest, sumCost));
                }
            }

        }

    }
}*/
