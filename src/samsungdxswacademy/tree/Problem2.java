/*
package samsungdxswacademy.tree;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++){
            int N = sc.nextInt();
            boolean sw = true;
            for (int j = 1; j <= N; j++){
                int idx = sc.nextInt();
                String s = sc.next();
                if (idx * 2 <= N) {
                    if (s.charAt(0) < 58 && s.charAt(0) >= 48)
                        sw = false;
                    sc.nextLine();
                }
                if (idx * 2 > N && (s.charAt(0) < 48 || s.charAt(0) >= 58))
                    sw = false;
            }
            System.out.println("#" + i + " " + (sw ? "1" : "0"));
        }

    }
}
*/
