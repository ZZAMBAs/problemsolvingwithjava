/*
package samsungdxswacademy.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem2 {
    static int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt();
            sc.nextLine();
            String[] maps = new String[N];
            for (int j = 0; j < N; j++)
                maps[j] = sc.nextLine();

            System.out.println("#" + i + " " + dijkstra(maps));
        }
    }

    static class Loc implements Comparable<Loc> {
        int r, c, w;

        public Loc(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Loc o) {
            return this.w - o.w;
        }
    }

    static int dijkstra(String[] maps){
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        pq.add(new Loc(0, 0, 0));
        boolean[][] visited = new boolean[maps.length][maps.length];
        while (!pq.isEmpty()){
            Loc curLoc = pq.poll();
            visited[curLoc.r][curLoc.c] = true;
            if (curLoc.r == maps.length - 1 && curLoc.c == maps.length - 1)
                return curLoc.w;

            for (int i = 0; i < 4; i++){
                int nextR = curLoc.r + dr[i];
                int nextC = curLoc.c + dc[i];
                if (nextR >= 0 && nextR < maps.length && nextC >= 0 && nextC < maps.length && !visited[nextR][nextC]){
                    pq.add(new Loc(nextR, nextC, curLoc.w + maps[nextR].charAt(nextC) - 48));
                }
            }
        }
        return -1;
    }
}
*/
