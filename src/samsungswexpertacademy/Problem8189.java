/*
package samsungswexpertacademy;
// 투 포인터
import java.util.Scanner;

public class Problem8189 {
    // 우편함에 쌓인 편지의 개수가 A개 이상이거나, 가장 오래 기다린 편지가 정확히 B시간 전에 온 편지면 우편함을 비우러 간다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
            int[] arr = new int[N + 1];
            int start = 0, end = 0;
            for (int j = 0; j < N; j++)
                arr[j] = sc.nextInt();
            while (end <= N){
                int cutTime = arr[start] + B;
                int cnt = end - start;
                if (arr[end] > cutTime || cnt == A){
                    int mailCheck = cnt / 2 + cnt % 2;
                    int val = arr[start] + B;
                    for (int k = 0; k < mailCheck; k++){
                        if (cnt == A)
                            arr[start] = arr[end - 1];
                        else
                            arr[start] = val;
                        start++;
                    }
                }
                else
                    end++;
            }
            end--;
            while (start != end){
                int cnt = end - start;
                int mailCheck = cnt / 2 + cnt % 2;
                int val = arr[start] + B;
                for (int k = 0; k < mailCheck; k++)
                    arr[start++] = val;
            }

            System.out.print("#" + i);
            for (int k = 0; k < N; k++)
                System.out.print(" " + arr[k]);
            System.out.println();
        }
    }
}
*/
