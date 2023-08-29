/*
package samsungdxswacademy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt();
            int mid = sc.nextInt();
            int res = 0;
            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            for (int j = 0; j < N; j++){
                for (int k = 0; k < 2; k++){
                    int num = sc.nextInt();
                    if (num < mid)
                        left.add(num);
                    else
                        right.add(num);
                }
                if (left.size() > right.size()){
                    for (int k = 0; k < left.size() - right.size(); k++){
                        right.add(mid);
                        mid = left.poll();
                    }
                }
                else{
                    for (int k = 0; k < right.size() - left.size(); k++){
                        left.add(mid);
                        mid = right.poll();
                    }
                }
                res = (res + mid) % 20171109;
            }
            System.out.println("#" + i + " " + res);
        }
    }
}
*/
