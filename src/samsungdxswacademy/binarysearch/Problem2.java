/*
package samsungdxswacademy.binarysearch;
// 파라메트릭 서치
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            long N = sc.nextLong();
            long res = -1;
            long start = 1, end = 1414213563L;
            while(start <= end){
                long mid = (start + end) / 2;
                long val = mid * (mid + 1) / 2;
                if (val <= N)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            if (end * (end + 1) / 2 == N)
                res = end;
            System.out.println("#" + i + " " + res);
        }
    }
}
*/
