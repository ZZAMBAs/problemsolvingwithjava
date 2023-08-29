/*
package samsungdxswacademy.trie;

import java.util.Scanner;

public class Problem1 {
    static int nowCnt;
    static String res;
    static class Trie{
        Trie[] edges;
        boolean isEnd;
        int OFFSET = 97;

        public Trie(){
            edges = new Trie[26];
            isEnd = false;
        }

        public void insert(String s, int idx){
            if (idx == s.length()){
                isEnd = true;
                return;
            }
            int character = s.charAt(idx) - OFFSET;
            if (edges[character] == null)
                edges[character] = new Trie();
            edges[character].insert(s, idx + 1);
        }
    }

    static void dfs(Trie t, String s, int K){
        if(t.isEnd){
            if(++nowCnt == K)
                res = s;
        }

        for (int i = 0; i < 26; i++){
            if (t.edges[i] != null)
                dfs(t.edges[i], s + (char)(i + 97), K);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            nowCnt = 0;
            int K = sc.nextInt();
            String str = sc.next();
            if (K <= 0 || K > str.length())
                res = "none";
            else{
                Trie root = new Trie();
                for (int j = 0; j < str.length(); j++){
                    root.insert(str, j);
                }
                dfs(root, "", K);
            }
            System.out.println("#" + i + " " + res);
        }
    }
}
*/
