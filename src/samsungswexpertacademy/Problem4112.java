/*
package samsungswexpertacademy;
// bfs
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem4112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            if (a > b){
                int temp = b;
                b = a;
                a = temp;
            }
            int temp = 1;
            int depth = 1, startDepth = 1, endDepth = 1;
            while (temp <= 10100) {
                if (temp < a && a <= temp + depth + 1) startDepth = depth + 1;
                if (temp < b && b <= temp + depth + 1) endDepth = depth + 1;
                temp += depth + 1;
                depth++;
            }

            System.out.println("#" + i + " " + bfs(a, b, startDepth, endDepth));
        }
    }

    static int bfs(int start, int end, int curDepth, int endDepth){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int travel = 0, ret = Integer.MAX_VALUE;
        boolean[] visited = new boolean[11000];
        while (!q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++){
                Integer num = q.poll();

                if (num == end)
                    return travel;
                if (curDepth == endDepth){
                   ret = Math.min(ret, travel + Math.abs(end - num));
                   continue;
                }

                if (!visited[num + curDepth]){
                    visited[num + curDepth] = true;
                    q.add(num + curDepth);
                }
                if (!visited[num + curDepth + 1]){
                    visited[num + curDepth + 1] = true;
                    q.add(num + curDepth + 1);
                }
            }
            curDepth++;
            travel++;
        }
        return ret;
    }
}
*/
