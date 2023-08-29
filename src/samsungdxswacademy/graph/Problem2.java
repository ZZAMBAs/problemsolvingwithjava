/*
package samsungdxswacademy.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2 {
    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] board;
        for (int i = 1; i <= T; i++){
            int res = 0;
            int N = sc.nextInt();
            sc.nextLine();
            int[][] visited = new int[N][N];
            board = new String[N];
            for (int j = 0; j < N; j++) {
                board[j] = sc.nextLine();
                for (int k = 0; k < N; k++)
                    if(board[j].charAt(k) == '*')
                        visited[j][k] = 1;
            }

            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (visited[j][k] == 0 && nearSafe(j, k, board)) {
                        bfs(j, k, visited, board);
                        res++;
                    }
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    if(visited[j][k] == 0)
                        res++;
            System.out.println("#" + i + " " + res);
        }
    }

    static boolean nearSafe(int row, int col, String[] board){
        for (int i = 0; i < 8; i++){
            int nextR = row + dr[i];
            int nextC = col + dc[i];
            if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board.length && board[nextR].charAt(nextC) == '*')
                return false;
        }
        return true;
    }
    static void bfs(int row, int col, int[][] visited, String[] board){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = 1;
        while (!q.isEmpty()){
            Pair front = q.poll();

            if (!nearSafe(front.x, front.y, board))
                continue;

            for (int i = 0; i < 8; i++){
                int nextR = front.x + dr[i];
                int nextC = front.y + dc[i];
                if (nextR >= 0 && nextR < board.length && nextC >= 0 && nextC < board.length && visited[nextR][nextC] != 1) {
                    q.add(new Pair(nextR, nextC));
                    visited[nextR][nextC] = 1;
                }
            }

        }

    }

}
*/
