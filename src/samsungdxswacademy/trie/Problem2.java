/*
package samsungdxswacademy.trie;

import java.util.Scanner;

public class Problem2 {
    static int K, nowK;
    static String res;
    static class Trie{
        Trie[] edges = new Trie[26];

        public void insert(String s, int idx){
            if (idx >= s.length())
                return;

            if (edges[s.charAt(idx) - 97] == null)
                edges[s.charAt(idx) - 97] = new Trie();
            edges[s.charAt(idx) - 97].insert(s, idx + 1);
        }

        public void dfs(String s){
            if (!res.equals("none"))
                return;

            if (nowK == K){
                res = s;
                return;
            }

            for (int i = 0; i < 26; i++){
                Trie next = edges[i];
                if (next != null){
                    nowK++;
                    next.dfs(s + (char)(i + 97));
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            nowK = 0;
            res = "none";
            K = sc.nextInt();
            String str = sc.next();
            Trie root = new Trie();
            for (int j = 0; j < str.length(); j++)
                root.insert(str, j);
            root.dfs("");

            System.out.println("#" + i + " " + res);
        }
    }
}
*/
