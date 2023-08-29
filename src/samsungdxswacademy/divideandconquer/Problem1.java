/*
package samsungdxswacademy.divideandconquer;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt();
            String[] s = new String[N];
            for (int j = 0; j < N; j++)
                s[j] = sc.next();
            mergeSort(0, N - 1, s);
            System.out.println("#" + i);
            String preS = "";
            for (String str : s) {
                if (preS.equals(str))
                    continue;
                System.out.println(str);
                preS = str;
            }
        }
    }

    static boolean checking(String s1, String s2){
        if (s1.length() != s2.length())
            return s1.length() < s2.length();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i))
                return true;
            if (s1.charAt(i) > s2.charAt(i))
                return false;
        }
        return false;
    }

    static void mergeSort(int start, int end, String[] s){
        if (start >= end)
            return;

        int mid = (start + end) / 2;
        mergeSort(start, mid, s);
        mergeSort(mid + 1, end, s);

        String[] temp = new String[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end)
            temp[k++] = checking(s[i], s[j]) ? s[i++] : s[j++];
        while (i <= mid)
            temp[k++] = s[i++];
        while (j <= end)
            temp[k++] = s[j++];

        for (String t : temp)
            s[start++] = t;
    }
}
*/
