package samsungswexpertacademy;

import java.util.Scanner;

public class Problem7673 {
    static int[][] board;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            N = sc.nextInt();
            board = new int[N][N];
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    board[j][k] = sc.nextInt();

        }
    }

}
