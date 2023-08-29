/*
package samsungdxswacademy.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// LCA를 최적 시간복잡도로 해야 풀리는 문제.

public class Problem3 {
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++){
            int N = Integer.parseInt(br.readLine());
            res = 0;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>(N + 1);
            Integer[][] parents = new Integer[N + 1][19];
            Integer[] depth = new Integer[N + 1];
            for (int j = 0; j < N + 1; j++) {
                adj.add(new ArrayList<>());
                for (int k = 0; k < 19; k++)
                    parents[j][k] = 0;
            }

            String[] strings = br.readLine().split(" ");
            for (int j = 2; j <= N; j++){
                Integer p = Integer.parseInt(strings[j - 2]);
                adj.get(j).add(p);
                adj.get(p).add(j);
            }

            ArrayList<Integer> seq = new ArrayList<>();
            bfs(seq, N, adj, parents, depth);
            for (int k = 1; Math.pow(2, k) < N; k++){
                for (int l = 2; l <= N; l++)
                    parents[l][k] = parents[parents[l][k - 1]][k - 1];
            }

            Integer curLoc = 1;
            for (Integer e : seq){
                if (depth[curLoc] > depth[e])
                    lca(curLoc, e, depth, parents);
                else
                    lca(e, curLoc, depth, parents);
                curLoc = e;
            }

            bw.write("#" + i + " " + res + "\n");
            bw.flush();
        }
    }

    static void bfs(ArrayList<Integer> seq, int N, ArrayList<ArrayList<Integer>> adj, Integer[][] parents, Integer[] depth){
        int dep = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        seq.add(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        while (!q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++){
                Integer front = q.poll();
                depth[front] = dep;
                for (Integer node : adj.get(front)){
                    if (!visited[node]){
                        parents[node][0] = front;
                        visited[node] = true;
                        seq.add(node);
                        q.add(node);
                    }
                }
            }
            dep++;
        }

    }

    static void lca(Integer curLoc, Integer next, Integer[] depth, Integer[][] parents){
        int depthDiff = depth[curLoc] - depth[next];
        res += depthDiff;
        int exp = 0;
        while (depthDiff > 0){
            if ((depthDiff & 1) == 1)
                curLoc = parents[curLoc][exp++];

            depthDiff = depthDiff >> 1;
        }
        if (curLoc == next)
            return;

        for (int i = 18; i >= 0; i--){
            if (!parents[curLoc][i].equals(parents[next][i])){
                curLoc = parents[curLoc][i];
                next = parents[next][i];
                res += (1L << i) * 2;
            }
        }
        res += 2;
    }
}
*/
