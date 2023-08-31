/*
package codebattle.training.day11;

import java.util.Scanner;

class Solution {
    private static Scanner sc;
    private static UserSolution userSolution = new UserSolution();

    private static final int MAX_N = 30;

    private static int mLimitMoveCnt = 0;
    private static int houseInfo[][] = new int[MAX_N][MAX_N];
    private static int isCleaned[][] = new int[MAX_N][MAX_N];
    private static int robotInfo[] = new int[]{0, 0, 0}; // [0] : y, [1] : x, [2] : direction
    private static int moveRobotsCallCnt = 0;

    private static int dy[] = new int[]{ -1, 0, 1, 0 };
    private static int dx[] = new int[]{ 0, -1, 0, 1 };

    private static boolean ok = false;

    void scanFromRobot(int floorState[][])
    {
        int robot_y = robotInfo[0];
        int robot_x = robotInfo[1];
        int direction = robotInfo[2];

        if (direction == 0) // UP
        {
            for (int y = robot_y - 1, sy = 0; y <= robot_y + 1; y++, sy++)
            {
                for (int x = robot_x - 1, sx = 0; x <= robot_x + 1; x++, sx++)
                {
                    floorState[sy][sx] = houseInfo[y][x];
                }
            }
        }
        if (direction == 1) // LEFT
        {
            for (int y = robot_y - 1, sx = 2; y <= robot_y + 1; y++, sx--)
            {
                for (int x = robot_x - 1, sy = 0; x <= robot_x + 1; x++, sy++)
                {
                    floorState[sy][sx] = houseInfo[y][x];
                }
            }
        }
        else if (direction == 2) // DOWN
        {
            for (int y = robot_y - 1, sy = 2; y <= robot_y + 1; y++, sy--)
            {
                for (int x = robot_x - 1, sx = 2; x <= robot_x + 1; x++, sx--)
                {
                    floorState[sy][sx] = houseInfo[y][x];
                }
            }
        }
        else if (direction == 3) // RIGHT
        {
            for (int y = robot_y - 1, sx = 0; y <= robot_y + 1; y++, sx++)
            {
                for (int x = robot_x - 1, sy = 2; x <= robot_x + 1; x++, sy--)
                {
                    floorState[sy][sx] = houseInfo[y][x];
                }
            }
        }
    }

    int moveRobot(int mCommand)
    {
        moveRobotsCallCnt++;

        if (mCommand < 0 || mCommand >= 4)
            return 0;

        int next_dir = (robotInfo[2] + mCommand) % 4;

        int sy = robotInfo[0] + dy[next_dir];
        int sx = robotInfo[1] + dx[next_dir];

        if (houseInfo[sy][sx] == 1)
        {
            return 0;
        }
        else
        {
            robotInfo[0] = sy;
            robotInfo[1] = sx;
            robotInfo[2] = next_dir;
            isCleaned[sy][sx] = 1;
        }

        return 1;
    }

    private static boolean run() throws Exception {

        int N = sc.nextInt();
        int subTaskCount = sc.nextInt();

        userSolution.init(N, subTaskCount);
        ok = true;

        for (int i = 0; i < subTaskCount; i++)
        {
            for (int y = 0; y < N; y++)
            {
                for (int x = 0; x < N; x++)
                {
                    houseInfo[y][x] = sc.nextInt();
                    isCleaned[y][x] = 0;
                }
            }


            robotInfo[0] = sc.nextInt();
            robotInfo[1] = sc.nextInt();
            robotInfo[2] = sc.nextInt();
            mLimitMoveCnt = sc.nextInt();
            isCleaned[robotInfo[0]][robotInfo[1]] = 1;
            moveRobotsCallCnt = 0;

            userSolution.cleanHouse(mLimitMoveCnt);

            if (mLimitMoveCnt < moveRobotsCallCnt)
                ok = false;

            for(int y = 0;y < N;y++)
            {
                for(int x = 0;x < N;x++)
                {
                    if(houseInfo[y][x] == 1)
                        continue;

                    if(isCleaned[y][x] == 0)
                        ok = false;
                }
            }
        }
        return ok;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;

        System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        sc = new Scanner(System.in);

        T = sc.nextInt();
        MARK = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int score = run() ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }

        sc.close();
    }
}*/
