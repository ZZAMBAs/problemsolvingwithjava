package samsungdxswacademy.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3 {
    static int HASHMOD = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= T; i++){
            int res = 0;
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            String[] eungi = new String[H];
            String[] teacher = new String[N];
            long[] teacherFirstHash = new long[N];
            for (int j = 0; j < H; j++)
                eungi[j] = bf.readLine();
            for (int j = 0; j < N; j++)
                teacher[j] = bf.readLine();

            if (H > N || W > M){
                System.out.println("#" + i + " 0");
                continue;
            }

            long eungiHash = calHash(eungi, W, H, 0, 0);
            long teacherHash = teacherFirstHash[0] = calHash(teacher, W, H, 0, 0);
            long[] rowHashes = new long[N];
            long[][] colHashes = new long[N - H + 1][M];

            for (int j = 0; j <= N - H; j++){
                if (j != 0){ // 아래로 이동
                    teacherHash = teacherFirstHash[j - 1];
                    teacherHash = (teacherHash - calHashRow(teacher, W, H, j - 1, 0, rowHashes) + HASHMOD) % HASHMOD;
                    teacherHash = ((teacherHash << W) + HASHMOD) % HASHMOD;
                    teacherHash = (teacherHash + (calHashRow(teacher, W, H, j + H - 1, 0, rowHashes) >> W * (H - 1)) + HASHMOD) % HASHMOD;
                    teacherFirstHash[j] = teacherHash;
                }

                for (int k = 0; k <= M - W; k++){
                    if (k != 0){ // 오른쪽으로 이동
                        teacherHash = (teacherHash - calHashCol(teacher, W, H, j, k - 1, colHashes) + HASHMOD) % HASHMOD;
                        teacherHash = (teacherHash << 1) % HASHMOD;
                        teacherHash = (teacherHash + (calHashCol(teacher, W, H, j, k + W - 1, colHashes) >> W - 1) + HASHMOD) % HASHMOD;
                    }
                    if (eungiHash == teacherHash)
                        res++;
                }

            }

            System.out.println("#" + i + " " + res);
        }
    }

    static long calHash(String[] original, int width, int height, int curR, int curC){
        long exp = (long) width * height - 1;
        long ret = 0;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                ret = (ret + ((long) (original[curR + i].charAt(curC + j) - 97) << exp--)) % HASHMOD;
        return ret;
    }
    static long calHashCol(String[] original, int width, int height, int curR, int curC, long[][] colHashes){
        if (colHashes[curR][curC] > 0)
            return colHashes[curR][curC];

        long exp = (long) width * height - 1;
        long ret = 0;
        for (int i = 0; i < height; i++){
            ret = (ret + ((long) (original[curR + i].charAt(curC) - 97) << exp) + HASHMOD) % HASHMOD;
            exp -= width;
        }
        colHashes[curR][curC] = ret;
        return colHashes[curR][curC];
    }

    static long calHashRow(String[] original, int width, int height, int curR, int curC, long[] rowHashes){
        if (rowHashes[curR] > 0)
            return rowHashes[curR];

        long exp = (long) width * height - 1;
        long ret = 0;
        for (int i = 0; i < width; i++){
            ret = (ret + ((long) (original[curR].charAt(curC + i) - 97) << exp--) + HASHMOD) % HASHMOD;
        }
        rowHashes[curR] = ret;
        return rowHashes[curR];
    }
}
