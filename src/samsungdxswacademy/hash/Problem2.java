/*
package samsungdxswacademy.hash; // Rabin-Karp

import java.util.Scanner;

public class Problem2 {
    static final long MUL_VAL = 341L;
    static final long HASH_MOD = 2147483647L;
    static long[] pows = new long[100001];
    static boolean[] visitpows = new boolean[100001];
    public static void main(String[] args) {
        pows[0] = 1;
        visitpows[0] = true;
        for (int i = 1000; i <= 100000; i += 1000)
            pow(i);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            String B = sc.next();
            String S = sc.next();
            int res = 0;
            int sLength = S.length();
            int bLength = B.length();
            if (sLength <= bLength) {
                long bHash = h(B.substring(0, sLength));
                long sHash = h(S);
                if (sHash == bHash && S.equals(B.substring(0, sLength)))
                    res++;

                int BIdx = sLength;
                while (BIdx < bLength){
                    long subtract = (long) B.charAt(BIdx - sLength) * pows[sLength - 1];
                    bHash = (bHash - subtract) % HASH_MOD;
                    bHash *= MUL_VAL;
                    bHash = (bHash + (long)B.charAt(BIdx)) % HASH_MOD;
                    if (bHash < 0)
                        bHash += HASH_MOD;

                    if (sHash == bHash){ // 이건 사실 꼼수고 해시 값이 같으면 문자열도 같은지 비교 해야 함.
                        res++;
                    }
                    BIdx++;
                }
            }

            System.out.println("#" + i + " " + res);
        }
    }

    static long h(String val){
        int length = val.length();
        int exp = length - 1;
        long ret = 0;
        for (int i = 0; i < length; i++){
            ret = (ret + pow(exp--) * (long)val.charAt(i)) % HASH_MOD;
        }
        return ret;
    }


    static long pow(int b){
        if (visitpows[b])
            return pows[b];

        visitpows[b] = true;
        pows[b] = pow(b - 1) * MUL_VAL % HASH_MOD;
        return pows[b];
    }
}

*/
