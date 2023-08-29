/*
package samsungdxswacademy.segmenttree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1 {
    public static class Pair{
        int maxV, minV;

        public Pair(int maxV, int minV) {
            this.maxV = maxV;
            this.minV = minV;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] maxSizeMemo = new int[19];
        maxSizeMemo[0] = 1;
        for (int i = 1; i < 19; i++)
            maxSizeMemo[i] = maxSizeMemo[i - 1] * 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++){
            bw.write("#" + i);
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int q = Integer.parseInt(tk.nextToken());
            int maxSize = 0;
            for (int j = 0; j < 18; j++){
                if (maxSizeMemo[j] >= n) {
                    maxSize = maxSizeMemo[j + 1];
                    break;
                }
            }
            Pair[] segment = new Pair[maxSize];
            tk = new StringTokenizer(br.readLine());
            int temp = 0;
            for (int j = maxSize / 2; j < maxSize; j++) {
                if (temp < n) {
                    int parsedInt = Integer.parseInt(tk.nextToken());
                    segment[j] = new Pair(parsedInt, parsedInt);
                    temp++;
                }
                else
                    segment[j] = new Pair(0, 1000000000);
            }
            for (int j = maxSize - 1; j > 1; j--)
                segment[j / 2] = new Pair(Math.max(segment[j / 2 * 2].maxV, segment[j / 2 * 2 + 1].maxV),
                        Math.min(segment[j / 2 * 2].minV, segment[j / 2 * 2 + 1].minV));

            for (int j = 0; j < q; j++){
                tk = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(tk.nextToken());
                int fir = Integer.parseInt(tk.nextToken());
                int sec = Integer.parseInt(tk.nextToken());
                if (cmd == 0)
                    update(segment, fir, sec, maxSize);
                else
                    bw.write(" " +
                            (printMax(segment, 1, fir, sec - 1, 0, maxSize / 2 - 1) - printMin(segment, 1, fir, sec - 1,0, maxSize / 2 - 1))
                    );
            }

            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }

    public static void update(Pair[] segment, int i, int val, int maxSize){
        int idx = maxSize / 2 + i;
        segment[idx].minV = segment[idx].maxV = val;
        while (idx > 1){
            idx /= 2;
            segment[idx].maxV = Math.max(segment[idx * 2].maxV, segment[idx * 2 + 1].maxV);
            segment[idx].minV = Math.min(segment[idx * 2].minV, segment[idx * 2 + 1].minV);
        }
    }

    public static int printMax(Pair[] segment, int idx, int left, int right, int nodeL, int nodeR){
        if (left <= nodeL && right >= nodeR) return segment[idx].maxV;
        if (nodeR < left || nodeL > right) return 0;
        int mid = (nodeL + nodeR) / 2;
        return Math.max(printMax(segment, idx * 2, left, right, nodeL, mid), printMax(segment, idx * 2 + 1, left, right, mid + 1, nodeR));
    }

    public static int printMin(Pair[] segment, int idx, int left, int right, int nodeL, int nodeR){
        if (left <= nodeL && right >= nodeR) return segment[idx].minV;
        if (nodeR < left || nodeL > right) return 1000000000;
        int mid = (nodeL + nodeR) / 2;
        return Math.min(printMin(segment, idx * 2, left, right, nodeL, mid), printMin(segment, idx * 2 + 1, left, right, mid + 1, nodeR));
    }
}*/
