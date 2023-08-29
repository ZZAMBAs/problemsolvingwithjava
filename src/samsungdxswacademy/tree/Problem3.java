/*
package samsungdxswacademy.tree;

import java.util.Scanner;

class Node{
    String data;
    Node left, right;
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++){
            double res = 0;
            int N = sc.nextInt();
            Node[] nodes = new Node[N + 1];
            for (int j = 1; j <= N; j++)
                nodes[j] = new Node();
            for (int j = 1; j <= N; j++){
                int idx = sc.nextInt();
                String data = sc.next();
                nodes[idx].data = data;
                if (data.charAt(0) < 48){
                    nodes[idx].left = nodes[sc.nextInt()];
                    nodes[idx].right = nodes[sc.nextInt()];
                }
            }
            res = inOrder(nodes[1]);
            System.out.println("#" + i + " " + (int) res);
        }

    }

    static double inOrder(Node curNode){
        if (curNode.data.equals("+"))
            return inOrder(curNode.left) + inOrder(curNode.right);
        else if (curNode.data.equals("-"))
            return inOrder(curNode.left) - inOrder(curNode.right);
        else if (curNode.data.equals("*"))
            return inOrder(curNode.left) * inOrder(curNode.right);
        else if (curNode.data.equals("/"))
            return inOrder(curNode.left) / inOrder(curNode.right);
        else
            return Double.parseDouble(curNode.data);
    }
}
*/
