/*
package samsungdxswacademy.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, N, M, L;
        String cmd;
        T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            N = sc.nextInt();
            M = sc.nextInt();
            L = sc.nextInt();
            LinkedList<Integer> array = new LinkedList<>();
            for (int j = 0; j < N; j++)
                array.add(sc.nextInt());
            for (int j = 0; j < M; j++){
                cmd = sc.next();
                if (cmd.equals("I"))
                    array.add(sc.nextInt(), sc.nextInt());
                else if (cmd.equals("D"))
                    array.remove(sc.nextInt());
                else
                    array.set(sc.nextInt(), sc.nextInt());
            }
            Integer idx = -1;
            try {
                idx = array.get(L);
            }catch (IndexOutOfBoundsException ignored){}
            System.out.println("#" + i + " " + idx);
        }
    }
}
*/
