/*
package samsungdxswacademy.graph;

import java.util.Scanner;

public class Problem1 {
    static int res, connectedCore;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            connectedCore = res = 0;
            int N = sc.nextInt(), coreIdx = 0;
            Pair[] coreLoc = new Pair[12];
            int[][] map = new int[N][N];
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++) {
                    map[j][k] = sc.nextInt();
                    if (map[j][k] == 1)
                        coreLoc[coreIdx++] = new Pair(j, k);
                }
            int[] dir = new int[N];
            dfs(0, N, coreLoc, N, map, 0, 0);
            System.out.println("#" + i + " " + res);
        }
    }

    // 0 1 2 3 상 하 좌 우
    static void dfs(int idx, int limit, Pair[] coreLoc, int N, int[][] map, int con, int length){
        if (idx == limit){
            if (connectedCore < con){
                connectedCore = con;
                res = length;
            }else if (connectedCore == con && res > length)
                res = length;
            return;
        }

        if (!(coreLoc[idx].x == 0 || coreLoc[idx].x == N - 1 || coreLoc[idx].y == 0 || coreLoc[idx].y == N - 1)) {
            for (int i = 0; i < 4; i++) { // 코어 방향
                boolean sw = true;
                int curR = coreLoc[idx].x, curC = coreLoc[idx].y;
                while (!(curR == 0 || curR == N - 1 || curC == 0 || curC == N - 1)){
                    curR += dr[i];
                    curC += dc[i];
                    if (map[curR][curC] == 1) {
                        sw = false;
                        break;
                    }
                }

                if (!sw)
                    continue;

                if (curR == 0 || curR == N - 1 || curC == 0 || curC == N - 1) {
                    while (!(curR == coreLoc[idx].x && curC == coreLoc[idx].y)) {
                        length++;
                        map[curR][curC] = 1;
                        curR -= dr[i];
                        curC -= dc[i];
                    }
                    dfs(idx + 1, limit, coreLoc, N, map, con + 1, length);
                    while (!(curR == 0 || curR == N - 1 || curC == 0 || curC == N - 1)){
                        curR += dr[i];
                        curC += dc[i];
                        map[curR][curC] = 0;
                        length--;
                    }
                }

            }
        }
        // 코어 생략
        dfs(idx + 1, limit, coreLoc, N, map, con, length);
    }


}
*/
