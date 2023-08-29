/*
package samsungdxswacademy.tree;

import java.util.HashSet;
import java.util.Scanner;

public class Problem4 {
    static int res;
    static class Node{
        Integer idx;
        Node parent, left, right;

        public Node(Integer idx) {
            this.idx = idx;
            this.parent = this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            res = 0;
            int V = sc.nextInt();
            int E = sc.nextInt();
            int find1 = sc.nextInt();
            int find2 = sc.nextInt();
            Node sameAncestor = null;
            Node[] nodes = new Node[V + 1];
            for (int j = 1; j <= V; j++)
                nodes[j] = new Node(j);

            for (int j = 0; j < E; j++){
                int pIdx = sc.nextInt();
                int cIdx = sc.nextInt();
                nodes[cIdx].parent = nodes[pIdx];
                if (nodes[pIdx].left != null)
                    nodes[pIdx].right = nodes[cIdx];
                else
                    nodes[pIdx].left = nodes[cIdx];
            }
            HashSet<Integer> set = new HashSet<>();
            Node curNode = nodes[find1];
            while (curNode != null) {
                set.add(curNode.idx);
                curNode = curNode.parent;
            }
            curNode = nodes[find2];
            while (curNode != null){
                if (set.contains(curNode.idx)){
                    sameAncestor = curNode;
                    break;
                }
                curNode = curNode.parent;
            }
            dfs(sameAncestor);
            System.out.println("#" + i + " " + sameAncestor.idx + " " + res);
        }
    }

    static void dfs(Node curNode){
        res++;
        if (curNode.left != null)
            dfs(curNode.left);
        if (curNode.right != null)
            dfs(curNode.right);
    }
}
*/
