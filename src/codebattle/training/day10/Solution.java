/*
package codebattle.training.day10;

import java.util.Scanner;

class Solution
{
    private static final int CMD_INIT 			= 100;
    private static final int CMD_JOIN			= 200;
    private static final int CMD_PLAY_ROUND		= 300;
    private static final int CMD_LEAVE			= 400;

    private static final int MAXN	= 10000;
    private static final int MAXM	= 1500;
    private static final int MAXL	= 10;

    private static char[][] mWordList = new char[MAXN][MAXL + 1];
    private static char[][] mSubjectList = new char[MAXN][MAXL + 1];
    private static int[] mCardList = new int[MAXM];

    private static void String2Char(int l, String s, char[] b)
    {
        int n = s.length();
        for (int i = 0; i < n; ++i)
            b[i] = s.charAt(i);
        for (int i = n; i < l; ++i)
            b[i] = '\0';
    }

    private static UserSolution usersolution = new UserSolution();

    private static boolean run(Scanner sc) throws Exception
    {
        int Q, N, M;

        char[] mBeginStr = new char[3];
        char[] mSubject = new char[MAXL + 1];

        int mID;

        int ret = -1, ans;

        Q = sc.nextInt();

        boolean okay = false;

        for (int q = 0; q < Q; ++q)
        {
            int cmd = sc.nextInt();

            switch(cmd)
            {
                case CMD_INIT:
                    N = sc.nextInt();
                    for (int i = 0; i < N; ++i)
                        String2Char(MAXL + 1, sc.next(), mWordList[i]);
                    for (int i = 0; i < N; ++i)
                        String2Char(MAXL + 1, sc.next(), mSubjectList[i]);
                    usersolution.init(N, mWordList, mSubjectList);
                    okay = true;
                    break;
                case CMD_JOIN:
                    mID = sc.nextInt();
                    M = sc.nextInt();
                    for (int i = 0; i < M; ++i)
                        mCardList[i] = sc.nextInt();
                    usersolution.join(mID, M, mCardList);
                    break;
                case CMD_PLAY_ROUND:
                    String2Char(3, sc.next(), mBeginStr);
                    String2Char(MAXL + 1, sc.next(), mSubject);
                    ret = usersolution.playRound(mBeginStr, mSubject);
                    ans = sc.nextInt();
                    if (ans != ret)
                        okay = false;
                    break;
                case CMD_LEAVE:
                    mID = sc.nextInt();
                    ret = usersolution.leave(mID);
                    ans = sc.nextInt();
                    if (ans != ret)
                        okay = false;
                    break;
                default:
                    okay = false;
                    break;
            }

        }

        return okay;
    }

    public static void main(String[] args) throws Exception
    {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();
        MARK = sc.nextInt();

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(sc) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        sc.close();
    }
}*/
